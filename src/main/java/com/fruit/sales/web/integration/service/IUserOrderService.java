package com.fruit.sales.web.integration.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fruit.sales.dao.OrderDetailDao;
import com.fruit.sales.vo.IOrderDetailVO;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.common.OrderConstant;
import com.fruit.sales.dao.OrderDao;
import com.fruit.sales.dto.FruitOrder;
import com.fruit.sales.dto.UserOrder;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.entity.Order;
import com.fruit.sales.entity.OrderAddress;
import com.fruit.sales.entity.OrderDetail;
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.service.FruitConfigService;
import com.fruit.sales.service.OrderAddressService;
import com.fruit.sales.service.OrderDetailService;
import com.fruit.sales.service.OrderService;
import com.fruit.sales.service.PubConfigService;
import com.fruit.sales.vo.IOrderVO;
import com.fruit.sales.web.integration.common.UserOrderConstant;
import com.fruit.sales.wechat.RestultCode;
import com.fruit.sales.wechat.ReturnResult;
import org.springframework.util.Assert;

@Service
public class IUserOrderService {

	private static final Logger logger = LoggerFactory.getLogger(IUserOrderService.class);
	
	@Autowired
	private OrderService service;

	@Autowired
	private AssignService assinService;
	
	@Autowired
	private FruitConfigService fruitConfigService;
	
	@Autowired
	private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDaoDao;

	@Autowired
	private OrderAddressService orderAddressService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private PubConfigService pubConfigService;


	public int getWaitOrderNumsCurrMonth(String wechatId){
		return orderDao.getWaitOrderNumsCurrMonth(wechatId);
	}

	/**
	 * validate order status, only wait for delivery status can be canceled.
	 *
	 * @param orderId
	 * @return
	 */
	private void validateOrder(String orderId) {
		Order order = orderService.findById(orderId);

		Assert.notNull(order, "cannot find this order with id:" + orderId);
		Assert.isTrue(StringUtils.equals(OrderConstant.WAIT_FOR, order.getStatusId()),
				"order status:" + order.getStatusId()+", but only wait_for order(1) can be canceled!");
	}

	@Transactional
	public ReturnResult cancleUserOrder(String orderId) throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();

		validateOrder(orderId);

		Order order = orderService.findById(orderId);
		order.setStatusId(OrderConstant.CUSTOMER_CANCLE);
		orderService.update(order);
		
		//get order detail
		List<OrderDetail> oderDetailLst = orderDetailService.findByOrderId(order.getId());
		
		int total = oderDetailLst.stream().mapToInt(it -> it.getOrderUnit()).sum();
		
		int orderUnit = total;
		
		Assign assign = assinService.findById(order.getAssignId());
		assign.setBalanceUnit(assign.getBalanceUnit() + orderUnit);
		assinService.update(assign);
		
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(order);
		rr.setMsg(orderJson);
		
		return rr;
	}

	private List<IOrderVO> queryOrderDetail(List<IOrderVO> orderLst){

		orderLst.stream().forEach(it -> {
            ArrayList<IOrderDetailVO> orderDetailVOLst = new ArrayList<IOrderDetailVO>(10);

			List<OrderDetail> orderDetailLst = orderDetailDaoDao.findListByFiled("orderId", it.getId());

			for (OrderDetail od : orderDetailLst) {
                IOrderDetailVO odvo = new IOrderDetailVO();
                odvo.setId(od.getId());
                odvo.setFruitId(od.getFruitId());
                odvo.setFruitName(od.getFruitName());
                odvo.setOrderUnit(od.getOrderUnit());

                orderDetailVOLst.add(odvo);

            }
            it.setOrderDetail(orderDetailVOLst);

        });


		return orderLst;
	}



	public ReturnResult queryUserOrder(String wechatId, String status) throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();
		
		List<IOrderVO> orderLst = orderDao.iQueryUserOrder(wechatId, status);

		//add order detail info
		orderLst = queryOrderDetail(orderLst);

		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(orderLst);
		rr.setMsg(orderJson);
		
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		
		return rr;
	}
	
	public ReturnResult queryUserAddress(String wechatId) throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();
		
		List<OrderAddress> addressLst = orderAddressService.findByOpenId(wechatId);
		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(addressLst);
		rr.setMsg(orderJson);
		
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		
		return rr;
	}
	
	public ReturnResult deleteUserAddress(String addressId) throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();
		
		boolean flag = orderAddressService.deleteById(addressId);
		
		if(flag){
			rr.setCode(RestultCode.SUCCESS.toString());
			rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		}else{
			rr.setCode(RestultCode.EXCEPTION.toString());
		}
		
		return rr;
	}

	
	private void setDefaultOrderParams(Order order, UserOrder userOrder){
		
//		private String address;
//		private String contactName;
//		private String contactPhone;
//		private String remark;
		//get data from userOrder
		order.setAddress(userOrder.getAddress());
		order.setRemark(userOrder.getRemark());
		order.setContactName(userOrder.getContactName());
		order.setContactPhone(userOrder.getContactPhone());
		
		order.setDeliveryDate(new DateTime().plusDays(7).toDate());
		order.setDeliveryBy("DeliveryBy");
		order.setDeliveryRemark("DeliveryRemark");
		order.setFinishDate(new DateTime().plusDays(7).toDate());
		order.setFinishBy("FinishBy");
		order.setFinishRemark("FinishRemark");
		order.setExtendData("extdata");
	}
	
	public ReturnResult validationUserOrder(Assign assign, UserOrder userOrder){
		ReturnResult rr = new ReturnResult();
		
		List<FruitOrder> lst = userOrder.getFruitList();
		
		for (FruitOrder fruitOrder : lst) {
			FruitConfig fruitConfig = fruitConfigService.findById(fruitOrder.getFruitId());
			
			//check the order date
			//delete this field
//			if(fruitConfig.getMaxOrderDay().compareTo(new Date()) < 0){
//				rr.setCode(RestultCode.EXCEPTION.toString());
//				rr.setValue(UserOrderConstant.EXCEED_MAX_ORDER_DATE);
//				rr.setMsg(fruitOrder.getFruitName());
//				return rr;
//			}
			
			//检查水果设置参数max order num
			if(fruitConfig.getMaxOrderNum() < fruitOrder.getOrderUnit()){
				rr.setCode(RestultCode.EXCEPTION.toString());
				rr.setValue(UserOrderConstant.EXCEED_MAX_ORDER_LIMIT);
				rr.setMsg(fruitOrder.getFruitName());
				return rr;
			}
			
			
			//check assign balance unit, no need, front-end will check
//			if(balanceUnitFromAssign < fruitOrder.getOrderUnit()){
//				rr.setCode(RestultCode.EXCEPTION.toString());
//				rr.setValue(UserOrderConstant.EXCEED_ASSIGN_BALANCE_UNIT);
//				rr.setMsg(fruitOrder.getFruitName());
//				return rr;
//			}
			
			
		}
		
		
		return rr;
	}
	
	@Transactional
	public ReturnResult order(Assign assign, UserOrder userOrder, Integer isDefaultAddr) throws JsonProcessingException{

		ReturnResult rr = new ReturnResult();
		

		//check max order to day of public config
		PubConfig pubConfig = pubConfigService.findByName(BusinessConstant.MAX_ORDER_DAY_TO);
		if(new DateTime().getDayOfMonth() > Integer.valueOf(pubConfig.getValue())){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(UserOrderConstant.EXCEED_ORDER_DAY_CFG);
			return rr;
		}
		
		rr = validationUserOrder(assign, userOrder);
		if(StringUtils.equalsIgnoreCase(RestultCode.EXCEPTION.toString(), rr.getCode())){
			return rr;
		}
		
		//update assign
		int balanceUnitFromAssign = assign.getBalanceUnit();
		assign.setBalanceUnit(balanceUnitFromAssign - userOrder.getTotalUnit());
		assinService.update(assign);
		
		Order order = new Order();
		
		
		//save order
		order.setAssignId(assign.getId());
		order.setSlaveName(assign.getSlaveName());
		order.setSlavePhone(assign.getSlavePhone());
		order.setStatusId(OrderConstant.WAIT_FOR);
		order.setPlanDeliveryDate(new DateTime().plusDays(7).toDate());
		
		setDefaultOrderParams(order, userOrder);
		logger.info("order before save: \n{}", order);
		Order newOrder = service.add(order);
		
		//save orderDetail
		List<FruitOrder> fruitLst = userOrder.getFruitList();
		List<OrderDetail> orderDetailLst = fruitLst.stream().map(it -> {
			OrderDetail od = new OrderDetail();

			//set order id
			od.setOrderId(newOrder.getId());
			
			od.setFruitId(it.getFruitId());
			od.setFruitName(it.getFruitName());
			od.setOrderUnit(it.getOrderUnit());
			
			od.setNewDefaultDateAndBy();
			
			return od;
		}).collect(Collectors.toList());
		
		int updatedCount = orderDetailService.addBatch(orderDetailLst);
		
		logger.info("Integration API bacth save orderDetail :{} and success :{}",
				orderDetailLst.size(), updatedCount);
		
		//save user common address
		saveAddress(newOrder, assign, isDefaultAddr);

		//retrun message
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(newOrder);
		rr.setMsg(orderJson);
		
		return rr;
	
	}

	private void saveAddress(Order newOrder, Assign assign, Integer defaultAddr){
		//save user common address
		OrderAddress addr = new OrderAddress();
		addr.setId(null);
		addr.setAddress(newOrder.getAddress());
		addr.setContactName(newOrder.getContactName());
		addr.setContactPhone(newOrder.getContactPhone());
		addr.setWechatOpenid(assign.getWechatOpenid());
		//default address or not
		addr.setDefaultAddr(defaultAddr);

		List<OrderAddress> addrLst = orderAddressService.findByOpenId(assign.getWechatOpenid());
		if(addrLst.size()>0){
			if(BusinessConstant.DEFAULT_ADDRESS.equals(defaultAddr)){
				//clear all status
				orderAddressService.clearDefaultStatusAddr(assign.getWechatOpenid());
			}

			long count = addrLst.stream().filter(add -> add.equals(addr)).count();
			if(count == 0){
				orderAddressService.add(addr);
			}
		}else{
			orderAddressService.add(addr);
		}
	}
	
}
