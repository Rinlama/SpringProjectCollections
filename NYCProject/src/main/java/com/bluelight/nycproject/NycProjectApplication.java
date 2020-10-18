package com.bluelight.nycproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bluelight.nycproject.entity.User;
import com.bluelight.nycproject.services.UserService;

@SpringBootApplication
@ComponentScan("com.bluelight")
@EntityScan("com.bluelight")
@EnableJpaRepositories("com.bluelight")
public class NycProjectApplication  implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	public static void main(String[] args){
		SpringApplication.run(NycProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		{
			User newAdmin=new User("admin@mail.com","ADMIN","123456");
			userService.createAdmin(newAdmin);
		}
	}

}
