package com.j.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.j.service.SearchStore;

@Configuration
public class Config {

	@Bean
	public SearchStore getSearchStore() {	
		SearchStore s = new SearchStore();		
		return s;
	}
}
