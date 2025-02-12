package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer{
	
	// images 링크가 들어오면, 찾는 위치를 c:upload 에서 찾아라
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// web 구축 시 사용되는 images 위치를 지정
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///C:/upload/");
		
		// 파일업로드에서 파일 위치를 지정
		registry.addResourceHandler("/upload/board/**")
		.addResourceLocations("file:///C:/upload/board/");
		
	}

}
