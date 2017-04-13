package com.fruit.sales.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.entity.OrderDetail;

@Repository
public class OrderDetailDao extends BaseDaoImpl<OrderDetail> {

	private static final long serialVersionUID = -2208659801591106429L;

	public int findMaxOrderUnitByFruitId(String fruitId){
		StringBuffer sql = new StringBuffer("select max(orderUnit)as maxUnit from T_ORDER_DETAIL where fruitId = ? ");
		return getJdbcTemplate().queryForObject(sql.toString(), Integer.class, new Object[]{fruitId});
	}
	
	public int addOrderDetailList(List<OrderDetail> lst){
		String sql = "insert into T_ORDER_DETAIL (id, fruitId, fruitName, orderId, orderUnit, insertDate, insertBy, updateDate, updateBy) values (null,?,?,?,?,?,?,?,?) ";
		
		int[] arr = getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter(){

			@Override
			public int getBatchSize() {
				return lst.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				ps.setString(1, lst.get(i).getFruitId());
				ps.setString(2, lst.get(i).getFruitName());
				ps.setString(3, lst.get(i).getOrderId());
				ps.setInt(4, lst.get(i).getOrderUnit());
				ps.setDate(5, new Date(lst.get(i).getInsertDate().getTime()));
				ps.setString(6, lst.get(i).getInsertBy());
				ps.setDate(7, new Date(lst.get(i).getUpdateDate().getTime()));
				ps.setString(8, lst.get(i).getUpdateBy());
			}
			
		});
		
		int sumCount = 0;
		for(int i : arr){
			sumCount += i;
		}
		return sumCount;
	}
}
