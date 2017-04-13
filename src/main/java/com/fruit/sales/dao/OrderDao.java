package com.fruit.sales.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fruit.sales.common.OrderConstant;
import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.entity.Order;
import com.fruit.sales.vo.IOrderVO;

@Repository
public class OrderDao extends BaseDaoImpl<Order>{

	private static final long serialVersionUID = 5068479458247623935L;

	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
	
	public int updateMutiStatus(String[] idArr, String status){
		StringBuffer sql = new StringBuffer("UPDATE T_ORDER set statusId= ")
							.append(status).append(" WHERE id in(");
		for(int i=0 ; i< idArr.length; i++){
			if(i == idArr.length-1 ){
				sql.append(idArr[i]);
			}else{
				sql.append(idArr[i]).append(", ");
			}
		}
		sql.append(") ");
		int count = getJdbcTemplate().update(sql.toString());
		return count;
	}
	
	
	
	public List<IOrderVO> iQueryUserOrder(String wechatId, String status){
		
		StringBuffer sql = new StringBuffer("select oo.*, os.name as statusValue , aa.wechatOpenid as wechatOpenid from T_ORDER oo join T_ASSIGN aa on oo.assignId = aa.id join T_ORDER_STATUS os on oo.statusId = os.id ");
		
		sql.append("WHERE wechatOpenid='").append(wechatId).append("' ");
		
		if(!StringUtils.equalsIgnoreCase(OrderConstant.ALL, status)){
			sql.append("AND oo.statusId = ").append(status).append(" ");
		}
		
		sql.append("order by updateDate ");
		
		logger.info("iQueryUserOrder sql:\n{}", sql.toString());
		
		List<IOrderVO> lst = getJdbcTemplate().query(sql.toString(),(resultSet, rowNum) ->{
			IOrderVO iOrderVO = new IOrderVO();
			iOrderVO.setId(resultSet.getString("id"));
			iOrderVO.setFruitName(resultSet.getString("fruitName"));
			iOrderVO.setOrderUnit(resultSet.getInt("orderUnit"));
			iOrderVO.setAddress(resultSet.getString("address"));
			iOrderVO.setContactName(resultSet.getString("contactName"));
			iOrderVO.setContactPhone(resultSet.getString("contactPhone"));
			iOrderVO.setRemark(resultSet.getString("remark"));
			
			iOrderVO.setStatusId(resultSet.getString("statusId"));
			iOrderVO.setStatusValue(resultSet.getString("statusValue"));
			iOrderVO.setWechatOpenid(resultSet.getString("wechatOpenid"));
			
			return iOrderVO;
		});
		
		return lst;
	}
	

	
}
