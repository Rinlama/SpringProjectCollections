package com.learnspring.courseapispringintr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.learnspring"} )
@EntityScan("com.learnspring")
@EnableJpaRepositories("com.learnspring")
public class CourseApiSpringintrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiSpringintrApplication.class, args);
	}

}
