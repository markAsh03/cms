package com.markash.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication()
@MapperScan(basePackages = { "com.markash.cms.dao" })
public class CmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CmsApplication.class);
	}
}

