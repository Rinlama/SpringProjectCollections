package com.bluelight.nycproject.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bluelight.nycproject.entity.User;
import com.bluelight.nycproject.services.PostServices;
import com.bluelight.nycproject.services.UserService;

@Controller
public class ProfileController {

	@Autowired
	private PostServices postService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model,Principal principal){
		
		String email=principal.getName();
		
		User user=userService.findOne(email);
		
		model.addAttribute("posts",postService.findUserPost(user));
		
		return "views/profile";
	}
}
