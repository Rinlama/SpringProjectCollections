package com.bluelight.nycproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexContoller {

	@GetMapping(value="/")
	public String showIndexPage(){
		
		return "index";
	}
	@GetMapping(value="/login")
	public String showLoginPage(){
		
		return "views/login";
	}
}
