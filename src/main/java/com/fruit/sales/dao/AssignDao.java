package com.fruit.sales.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.entity.Assign;

@Repository
public class AssignDao extends BaseDaoImpl<Assign>{

	private static final long serialVersionUID = 5537670032376754186L;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean existSlavePhone(String phone){
		StringBuffer sql = new StringBuffer("select count(*) from T_ASSIGN where slavePhone = ");
		sql.append(phone);
		int count = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		if(count > 0){
			return true;
		}
		return false;
	}
	
}
