package com.fruit.sales.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fruit.sales.entity.OrderStatus;

public class OrderStatusRowMapper implements RowMapper<OrderStatus> {

	@Override
	public OrderStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderStatus os = new OrderStatus();
		os.setId(rs.getString("id"));
		os.setName(rs.getString("name"));
		return os;
	}

}
