package com.fruit.sales.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.fruit.sales.dao.base.BaseDaoImpl;
import com.fruit.sales.entity.FruitConfig;

@Repository
public class FruitConfigDao extends BaseDaoImpl<FruitConfig>{

	private static final long serialVersionUID = 1825926396066774693L;
	
	
	
	public List<FruitConfig> listCurrentMonthFruit(){
		String sql = "select * from T_FRUIT_CONFIG where date_format(fruitMonth,'%Y-%m')=date_format(now(),'%Y-%m') ";
		
		List<FruitConfig> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(FruitConfig.class));
//		if(lst != null && lst.size()>0){
//			return lst;
//		}
		return lst;
	}

}
