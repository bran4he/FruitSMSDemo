package com.fruit.sales.dao;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fruit.sales.dao.UserDao;
import com.fruit.sales.entity.User;
import com.fruit.sales.test.BaseTest;

public class UserTest extends BaseTest{

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testUser_find(){
		User user = userDao.findById("1000");
		System.out.println(user.toString());
	}
	
	@Test
	public void testUser_add(){
		User u = new User();
		u.setId(userDao.getNextId());
		u.setUsername("user_test");
		u.setPassword("test_pwd");
		u.setInsertBy("bran");
		u.setInsertDate(new Date());
		u.setUpdateBy("admin");
		u.setUpdateDate(new Date());
		userDao.save(u);
	}
	
	
	@Test
	public void testUser_del(){
		User u = new User();
		u.setId("1001");
		userDao.delete(u);
		
		System.out.println(userDao.findById("1002").toString());
	}
	
	
	//test reflection
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
//		Field[] fields = User.class.getDeclaredFields();
//		for(Field f : fields){
//			System.out.println(f.toGenericString());
//		}
		
//		Field[] fields = User.class.getFields();
//		for(Field f : fields){
//			System.out.println(f.toGenericString());
//		}

		User u = new User();
		u.setId("2222");
		u.setUsername("user_test");
		u.setPassword("test_pwd");
		u.setInsertBy("bran");
		u.setInsertDate(new Date());
		u.setUpdateBy("admin");
		u.setUpdateDate(new Date());
		
		Field[] fields = FieldUtils.getAllFields(User.class);
//		fields[0].setAccessible(true);
//		System.out.println(fields[0].getName());
		for(Field f : fields){
			//show all types - ok
//			System.out.println(f.getGenericType().getTypeName());
			//get all field values - ok
			f.setAccessible(true);
			if("id".equalsIgnoreCase(f.getName())){
				System.out.println(f.get(u));
			}
			
//			System.out.println(f.toGenericString());
//			System.out.println(FieldUtils.readField(f, u, true));
//			System.out.println(f.get(u).getClass().getName());
			
		}		
	}
}
