package com.fruit.sales.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.entity.mapper.OrderStatusRowMapper;

@Repository
public class OrderStatusDaoImpl implements OrderStatusDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public OrderStatus get(String id) {
		String sql = "select * from T_ORDER_STATUS where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id },new OrderStatusRowMapper());
	}

	@Override
	public List<OrderStatus> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from T_ORDER_STATUS";
		List<OrderStatus> lst = jdbcTemplate.query(sql, new OrderStatusRowMapper());
		return lst;
	}

	@Override
	public OrderStatus insert(OrderStatus os) {
		String sql = "insert into T_ORDER_STATUS values (null, ?)";
		jdbcTemplate.update(sql, new Object[]{os.getName()});
		return os;
	}
}
