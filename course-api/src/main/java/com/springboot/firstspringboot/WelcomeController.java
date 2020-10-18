package com.springboot.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.services.WelcomeService;

@RestController
public class WelcomeController {
	
	@Autowired
	public WelcomeService service;

	@RequestMapping("/welcome")
	public String welcome(){
		return service.retreiveMessage();
	}
}

