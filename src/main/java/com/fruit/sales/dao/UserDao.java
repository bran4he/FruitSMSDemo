package com.fruit.sales.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.entity.User;
import com.fruit.sales.entity.mapper.UserRowMapper;

@Repository
public class UserDao extends BaseDaoImpl<User>{

	private static final long serialVersionUID = 3977669604913801634L;

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	public User findUserByName(String username){
		User user = null;
		String sql = "select * from T_USER where username = ? ";

		List<User> lst = (List<User>) getJdbcTemplate().query(sql, new Object[]{username}, new UserRowMapper());
		logger.info("find user by username:{} and get result:{}", username, lst);
		if(lst != null && lst.size()>0){
			user = lst.get(0);
		}
		return user;
	}

}
