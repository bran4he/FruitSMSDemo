package com.fruit.sales.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fruit.sales.test.BaseTest;
import com.fruit.sales.web.demo.Demo;
import com.fruit.sales.web.demo.DemoDao;

public class NewDaoTest extends BaseTest{

	@Autowired
	private DemoDao demoDao;
	
	@Test
	public void testDemo_find(){
		Demo demo = demoDao.findById(1);
		System.out.println(demo.toString());
	}
	
	@Test
	public void testDemo_save(){
		Demo demo = new Demo("1", "test", 100, "s");
		demoDao.save(demo);
	}
	
	@Test
	public void testDemo_update(){
		Demo demo = demoDao.findById(1);
		System.out.println(demo.toString());
		
		demo.setAge(88);
		demoDao.update(demo);
	}
	
	@Test
	public void testDemo_delete(){
		Demo demo = demoDao.findById(1);
		System.out.println(demo.toString());
		
		demoDao.delete(demo);
		System.out.println(demoDao.findById(1));
	}
	
	
	@Test
	public void testDemo_findByPageList(){
		QueryResult<Demo> lst = demoDao.findByPageList(2, 5);
		System.out.println(lst.getTotalRow());
		System.out.println(lst.getList());
	}
}
