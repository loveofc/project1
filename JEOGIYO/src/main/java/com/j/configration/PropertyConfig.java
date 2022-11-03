package com.j.configration;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertyConfig {
	
	@Bean
	public PropertiesFactoryBean menu()  {
		PropertiesFactoryBean pb = new PropertiesFactoryBean();
		ClassPathResource cr = new ClassPathResource("application.properties");
		
		pb.setLocation(cr);
		pb.setFileEncoding("utf-8");
		
		return pb;
	}
	
	@Bean
	public PropertiesFactoryBean naver()  {
		PropertiesFactoryBean pb = new PropertiesFactoryBean();
		ClassPathResource cr = new ClassPathResource("application.properties");
		
		pb.setLocation(cr);
		pb.setFileEncoding("utf-8");
		
		return pb;
	}
}
