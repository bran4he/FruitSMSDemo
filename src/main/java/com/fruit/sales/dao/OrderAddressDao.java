package com.fruit.sales.dao;

import com.fruit.sales.common.BusinessConstant;
import org.springframework.stereotype.Repository;

import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.entity.OrderAddress;

@Repository
public class OrderAddressDao extends BaseDaoImpl<OrderAddress> {

	private static final long serialVersionUID = 4285875366123865343L;

	public void setAddrToNotDefault(String wechatOpenid){
		StringBuffer sql = new StringBuffer("update T_ORDER_ADDRESS set defaultAddr = ")
				.append(BusinessConstant.NOT_DEFAULT_ADDRESS)
				.append(" where wechatOpenid = '")
				.append(wechatOpenid)
				.append("'");
//		String sql = "update T_ORDER_ADDRESS set defaultAddr = 0 where wechatOpenid = ?" + wechatOpenid;
		getJdbcTemplate().update(sql.toString());

	}

}
