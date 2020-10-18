package com.bluelight.HamroSong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bluelight.filestorage.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
@ComponentScan("com.bluelight")
@EnableJpaRepositories("com.bluelight")
@EntityScan("com.bluelight")
@EnableJpaAuditing
public class HamroSongApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamroSongApplication.class, args);
	}

}
