package com.subodh.springbooot.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
//import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

	@Autowired
	private Environment environment;

//	@Value("${user.name}")
//	private String username;
//	
//	@Value("${user.email}")
//	private String email;

	@Profile("dev")
	@Bean
	public void loadDevProfile() {
		System.out.println("username-dev:" + environment.getProperty("users.name") + "email-dev:"
				+ environment.getProperty("users.email"));
	}

	@Profile("int")
	@Bean
	public void loadIntProfile() {
		System.out.println("username-int:" + environment.getProperty("users.name") + "email-int:"
				+ environment.getProperty("users.email"));
	}
}
