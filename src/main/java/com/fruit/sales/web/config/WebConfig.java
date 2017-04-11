package com.fruit.sales.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc
//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		System.out.println("------");
		registry.addMapping("/rest/**").
		allowedOrigins("*")
		.allowCredentials(true);
		
//		registry.addMapping("/**")
//		.allowedOrigins("*")
//		.allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name())
//		.allowedHeaders("*")
//		.allowCredentials(true)
//		.maxAge(1800);
	}

	
}
