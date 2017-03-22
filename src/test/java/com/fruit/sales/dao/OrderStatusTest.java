package com.fruit.sales.dao;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.serviceImpl.OrderStatusServiceImpl;
import com.fruit.sales.test.BaseTest;
import com.fruit.sales.web.demo.PersonDaoImpl;
 
public class OrderStatusTest extends BaseTest{

	/* -------------------dao */
	@Autowired
	private OrderStatusDao orderStatusDao;
	
	@Test
	public void testGetOS(){
		OrderStatus os = orderStatusDao.findById("1");
		System.out.println(os.toString());
	}
	
	@Test
	public void testAddOS(){
		OrderStatus os = new OrderStatus();
		os.setName("this is a test data");
		orderStatusDao.save(os);
	}
	
	/* -------------------service */
	@Autowired
	private OrderStatusServiceImpl orderStatusService;
	
	@Test
	public void testGetAllOS(){
		System.out.println("==============================");
		List<OrderStatus> lst = orderStatusService.listAll();
		System.out.println(lst.size());
		System.out.println(lst);
	}
	
	/* -------------------action/web */	
	//refer : http://stackoverflow.com/questions/14563489/how-to-test-a-spring-controller-method-by-using-mockmvc
	private MockMvc mockMvc;
	
    @Autowired WebApplicationContext wac; 
    @Autowired MockHttpSession session;
    @Autowired MockHttpServletRequest request;
	
	@Before
    public void before() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	} 
	
	@Test
	public void testGetAllOS_web(){
		System.out.println("----------------------------start");
		MvcResult result;
		try {
			result = this.mockMvc.perform(get("/os/all"))
			        .andExpect(status().isOk())
			        .andReturn();
			
			System.out.println(result.getResponse().getContentAsString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------end");
	}
	
	
	/* -------------------test demo */
	@Autowired
	private PersonDaoImpl personDao;
	
	@Test
	public void testPersonFind(){
		System.out.println(personDao.findByName("jack"));
		Assert.assertEquals(personDao.findByName("jack").getAge(), 101);
	}
}
