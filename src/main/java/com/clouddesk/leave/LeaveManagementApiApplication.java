package com.clouddesk.leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LeaveManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveManagementApiApplication.class, args);
	}

}
