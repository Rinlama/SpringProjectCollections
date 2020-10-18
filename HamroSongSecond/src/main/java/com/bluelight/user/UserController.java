package com.bluelight.user;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.bluelight.artist.Artist;
import com.bluelight.model.User;
import com.bluelight.services.UserService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userservice;

   @RequestMapping(method=RequestMethod.GET,value="/user/{username}")
   public ResponseEntity<?> getArtist(@Valid @PathVariable("username") String username,HttpServletRequest request){
	   
	   String auth=request.getHeader("Authorization");
	    String requestUserName=new String(Base64.getDecoder().decode(auth.split(" ")[1])).split(":")[0];
	   	  
	   logger.debug("Log work" + auth.split(" ")[0]);
	   
	   User user=userservice.loadUserByUsername(requestUserName);
	   
	   if(user!=null){
		   return ResponseEntity.ok().body(user);
	   }else{
		   throw new UsernameNotFoundException("no user");
	   }
  
   }
	
}
