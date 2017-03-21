package com.fruit.sales.web.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonServcice {

	@Autowired
	private PersonDaoImpl personDao;

	@Override
	public Person find(String name) {
		// TODO Auto-generated method stub
		return personDao.findByName(name);
	}

}
