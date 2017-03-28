package com.fruit.sales.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.entity.LoginLog;
import com.fruit.sales.vo.LoginLogVO;

@Repository
public class LoginLogDao extends BaseDaoImpl<LoginLog>{

	private static final long serialVersionUID = -3451574326191666390L;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * load all VO for UI 
	 * @return
	 */
	public List<LoginLogVO> findAllVO(){
		String sql = "select log.*, u.username from T_LOGIN_LOG log join T_USER u on log.userId = u.id order by log.id";
		List<LoginLogVO> lst = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			LoginLogVO vo = new LoginLogVO();
			vo.setId(resultSet.getString("id"));
			vo.setUserId(resultSet.getString("userId"));
			vo.setLoginDate(resultSet.getDate("loginDate"));
			vo.setLoginIP(resultSet.getString("loginIP"));
			vo.setUsername(resultSet.getString("username"));
			return vo;
		});
		
		
		return lst;
	}
}
