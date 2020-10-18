package com.customer.crm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomerController {
	
	@Autowired(required=true)
	CustomerJPARepository customerRepo;
	
	@GetMapping("/")
	public String index(Model model){
		return "customer";
	}

	@RequestMapping(method=RequestMethod.GET,value="/customers")
	public String getcustomers(HttpServletRequest request,Model model){	
		
		model.addAttribute("customerlist", customerRepo.findAll());
		return "customer";
	}
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public String postcustomers(){
		return "test";
	}
	@RequestMapping(method=RequestMethod.PUT,value="/customers")
	public String putcustomers(){
		return "test";
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/customers")
	public String deletecustomers(){
		return "test";
	}
	
	
}
