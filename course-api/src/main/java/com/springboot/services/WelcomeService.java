package com.springboot.services;

import org.springframework.stereotype.Service;

//create a instance and inject in controller
@Service
public class WelcomeService{

	public String retreiveMessage(){
		return "Good Morning" ;
	}
}