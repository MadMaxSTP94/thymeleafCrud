package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class UserCrudApplication {
	@Bean
	public DataSource dataSource(@Value("${db.url}")String url,
								 @Value("${db.username}") String username,
								 @Value("${db.password}") String password) {
		var dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserCrudApplication.class, args);
	}

}
