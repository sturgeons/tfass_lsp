package com.fxtech.ldplatform.core;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:spring-*.xml")
@ComponentScan(basePackages = "com.fxtech.ldplatform")
@EnableCaching
public class Application {
	private static Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		log.info("Applictaion Startup.");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(org.apache.commons.dbcp.BasicDataSource.class).build();
	}
}
