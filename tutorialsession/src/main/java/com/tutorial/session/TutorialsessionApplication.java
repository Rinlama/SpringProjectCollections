package com.tutorial.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tutorial.entity.Tracker;
import com.tutorial.service.TrackerService;

@SpringBootApplication
@ComponentScan("com.tutorial")
@EnableJpaRepositories("com.tutorial")
@EntityScan("com.tutorial")
public class TutorialsessionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TutorialsessionApplication.class, args);
	}
	
	@Autowired
	private TrackerService trackerService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Tracker tracker= new Tracker("test","21.21","21.21");
		trackerService.addTracker(tracker);
	}

}
