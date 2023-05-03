package com.subodh.springbooot;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringboootApplication {
//      @Value("$(logging.file.name)")
//      private String loggerPath;
//      private static final Logger LOGGER = LoggerFactory.getLogger();
	public static void main(String[] args) {
		
		SpringApplication.run(SpringboootApplication.class, args);
	}

}
