package com.pransquare.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableJpaRepositories(basePackages = "com.pransquare.dashboard.repositories")
@EntityScan(basePackages = "com.pransquare.dashboard.entities")
@ComponentScan(basePackages = "com.pransquare.dashboard")
public class MasterConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterConfigApplication.class, args);
	}

}
