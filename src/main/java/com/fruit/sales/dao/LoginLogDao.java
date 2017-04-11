package com.fruit.sales.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.LoginLog;
import com.fruit.sales.vo.LoginLogVO;

@Repository
public class LoginLogDao extends BaseDaoImpl<LoginLog>{

	private static final long serialVersionUID = -3451574326191666390L;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public QueryResult<LoginLogVO> findByVOPageList(QueryParam queryParam) {
		StringBuffer sql = new StringBuffer("select log.*, u.username from T_LOGIN_LOG log join T_USER u on log.userId = u.id ");
		
		StringBuffer orderBy = new StringBuffer();
		orderBy.append("order by ").append(queryParam.getSidx()).append(" ").append(queryParam.getSord()).append(" ");
		
		StringBuffer limit = new StringBuffer();
		int pageNo = queryParam.getPage();
		int pageSize = queryParam.getRows();
		int indexFirst = (pageNo - 1) * pageSize;
		int indexLast = pageSize;
		limit.append(" limit "+indexFirst+"," + indexLast + " ");
		
		sql.append(orderBy).append(limit);
		
		List<LoginLogVO> lst = jdbcTemplate.query(sql.toString(), (resultSet, rowNum) -> {
			LoginLogVO vo = new LoginLogVO();
			vo.setId(resultSet.getString("id"));
			vo.setUserId(resultSet.getString("userId"));
			//fix page not show minutes and seconds
			vo.setLoginDate(resultSet.getTimestamp("loginDate"));
			vo.setLoginIP(resultSet.getString("loginIP"));
			vo.setUsername(resultSet.getString("username"));
			return vo;
		});
		
		
		String Sqlcount = "select count(*) from T_LOGIN_LOG";
		int count = jdbcTemplate.queryForObject(Sqlcount, Integer.class);
		
		return new QueryResult<LoginLogVO>(lst, count, pageNo, pageSize);
	}
	
	
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
