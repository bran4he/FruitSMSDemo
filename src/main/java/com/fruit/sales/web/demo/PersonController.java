package com.fruit.sales.web.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/manage")
@Controller
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonServiceImpl personService;
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "data.json", method = RequestMethod.GET)
	public @ResponseBody Object getJson() throws IOException{
		
		String file = PersonController.class.getResource("/data.json").getFile();
		
		BufferedReader br = new BufferedReader(new FileReader(file)) ;
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		return sb.toString();
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username")String userName,
			@RequestParam("password")String passWord){
		logger.info("============username: {}", userName);
		logger.info("============password:{}", passWord);
		return "manage";
	}
	
	
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public @ResponseBody Person getPerson() {
		Person person = new Person();
		person.setAge(99);
		person.setName("jack");
		person.setSex("F");
		logger.info(person.toString());
		return person;
	}
	
	
	@RequestMapping(value="/find/{name}", method = RequestMethod.GET) 
	public @ResponseBody Person find(@PathVariable String name){
		return personService.find(name);
	}
}
