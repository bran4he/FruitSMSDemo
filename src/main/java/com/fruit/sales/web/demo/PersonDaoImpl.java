package com.fruit.sales.web.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Person findByName(String name) {
		String sql = "select * from t_user where name = ?";
		List<Person> lst = jdbcTemplate.query(sql, new Object[]{name}, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p = new Person();
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("sex"));
				return p;
			}
			
		});
		if(lst.size()>0){
			return lst.get(0);
		}
		return null;
	}

}
