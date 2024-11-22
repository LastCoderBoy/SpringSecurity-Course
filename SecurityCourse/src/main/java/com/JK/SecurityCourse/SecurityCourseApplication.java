package com.JK.SecurityCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SecurityCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityCourseApplication.class, args);
	}

}
