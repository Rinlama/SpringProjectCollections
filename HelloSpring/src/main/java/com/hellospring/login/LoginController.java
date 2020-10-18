package com.hellospring.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellospring.login.LoginService;

@Controller
public class LoginController {

	//Set the Login Serivce -Auto Wired
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String user,@RequestParam String password,ModelMap model){
	if(service.validateUser(user, password)){
		model.put("user", user);
		model.put("password", password);
			return "welcome";		
	}else{
		model.put("errorMessage", "No match");
		return "login";	
	}

	}
	
}
