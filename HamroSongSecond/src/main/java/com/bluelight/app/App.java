package com.bluelight.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableConfigurationProperties({
    com.bluelight.fileStorage.FileStorageProperties.class
})
@ComponentScan("com.bluelight")
@EnableJpaRepositories("com.bluelight")
@EntityScan("com.bluelight")
@EnableJpaAuditing
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
