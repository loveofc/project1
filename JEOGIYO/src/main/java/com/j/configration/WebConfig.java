package com.j.configration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Value("#{menu['resource.path']}")
	private String resourcePath;
	
	@Value("#{menu['upload.path']}")
	private String imgPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String[] arr = resourcePath.split(",");
		registry.addResourceHandler(imgPath).addResourceLocations(arr);

	}
	

}
