package com.fruit.sales.web.integration.service;

import java.util.Date;
import java.util.List;

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
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.entity.Order;
import com.fruit.sales.entity.OrderAddress;
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.service.FruitConfigService;
import com.fruit.sales.service.OrderAddressService;
import com.fruit.sales.service.OrderService;
import com.fruit.sales.service.PubConfigService;
import com.fruit.sales.vo.IOrderVO;
import com.fruit.sales.web.integration.common.UserOrderConstant;
import com.fruit.sales.wechat.RestultCode;
import com.fruit.sales.wechat.ReturnResult;

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
	private OrderAddressService orderAddressService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PubConfigService pubConfigService;

	
	@Transactional
	public ReturnResult cancleUserOrder(String orderId) throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();
		
		Order order = orderService.findById(orderId);
		order.setStatusId(OrderConstant.CUSTOMER_CANCLE);
		orderService.update(order);
		
		int orderUnit = order.getOrderUnit();
		
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
	
	public ReturnResult queryUserOrder(String wechatId, String status) throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();
		
		List<IOrderVO> orderLst = orderDao.iQueryUserOrder(wechatId, status);
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

	
	private void setDefaultOrderParams(Order order){
		order.setDeliveryDate(new DateTime().plusDays(7).toDate());
		order.setDeliveryBy("DeliveryBy");
		order.setDeliveryRemark("DeliveryRemark");
		order.setFinishDate(new DateTime().plusDays(7).toDate());
		order.setFinishBy("FinishBy");
		order.setFinishRemark("FinishRemark");
		order.setExtendData("extdata");
	}
	
	
	@Transactional
	public ReturnResult order(Assign assign, Order order) throws JsonProcessingException{

		ReturnResult rr = new ReturnResult();
		
		FruitConfig fruitConfig = fruitConfigService.findById(order.getFruitId());
		//TODO
//		int balanceUnitFromFruit = fruitConfig.getBalanceNum();
		
		int balanceUnitFromAssign = assign.getBalanceUnit();
		
		//check max order to day of public config
		PubConfig pubConfig = pubConfigService.findByName(BusinessConstant.MAX_ORDER_DAY_TO);
		if(new DateTime().getDayOfMonth() > Integer.valueOf(pubConfig.getValue())){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(UserOrderConstant.EXCEED_ORDER_DAY_CFG);
			return rr;
		}
		
		//check the order date
		if(fruitConfig.getMaxOrderDay().compareTo(new Date()) < 0){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(UserOrderConstant.EXCEED_MAX_ORDER_DATE);
			return rr;
		}
		
		//检查水果设置参数 max provide num - balance num
		//TODO wait for new requirements
//		if(fruitConfig.getBalanceNum() < order.getOrderUnit()){
//			rr.setCode(RestultCode.EXCEPTION.toString());
//			rr.setValue(UserOrderConstant.EXCEED_FRUIT_BALANCE);
//			return rr;
//		}
		
		
		//检查水果设置参数max order num
		if(fruitConfig.getMaxOrderNum() < order.getOrderUnit()){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(UserOrderConstant.EXCEED_MAX_ORDER_LIMIT);
			return rr;
		}
		
		
		//check assign balance unit
		if(balanceUnitFromAssign < order.getOrderUnit()){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(UserOrderConstant.EXCEED_ASSIGN_BALANCE_UNIT);
			return rr;
		}
		
		//update assign
		assign.setBalanceUnit(balanceUnitFromAssign - order.getOrderUnit());
		assinService.update(assign);
		
		//update fruitConfig
		//TODO 
//		fruitConfig.setBalanceNum(balanceUnitFromFruit - order.getOrderUnit());
//		fruitConfigService.update(fruitConfig);
		
		//save order
		order.setAssignId(assign.getId());
		order.setStatusId(OrderConstant.WAIT_FOR);
		order.setPlanDeliveryDate(new DateTime().plusDays(7).toDate());
		
		setDefaultOrderParams(order);
		
		logger.info("order before save: \n{}", order);
		
		//save user common address
		OrderAddress addr = new OrderAddress();
		addr.setId(null);
		addr.setAddress(order.getAddress());
		addr.setContactName(order.getContactName());
		addr.setContactPhone(order.getContactPhone());
		addr.setWechatOpenid(assign.getWechatOpenid());
		
		List<OrderAddress> addrLst = orderAddressService.findByOpenId(assign.getWechatOpenid());
		if(addrLst.size()>0){
			long count = addrLst.stream().filter(add -> add.equals(addr)).count();
			if(count == 0){
				orderAddressService.add(addr);
			}
		}else{
			orderAddressService.add(addr);
		}
		
		service.add(order);
		
		//retrun message
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(order);
		rr.setMsg(orderJson);
		
		return rr;
	
	}
	
}
