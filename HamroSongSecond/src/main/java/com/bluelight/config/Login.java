package com.bluelight.config;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluelight.exception.GenericResponse;
import com.bluelight.exception.ResourceNotFoundException;
import com.bluelight.model.PasswordResetToken;
import com.bluelight.model.Role;
import com.bluelight.model.User;
import com.bluelight.repository.PasswordTokenRepository;
import com.bluelight.repository.RoleRepository;
import com.bluelight.repository.UserRepository;
import com.bluelight.services.UserService;

import javassist.tools.web.BadHttpRequest;

@CrossOrigin("*")
@RestController
public class Login {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userservice;
	
	@Autowired
	UserDetailsService userdetailsService;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordTokenRepository passwordTokenRepository;
	
    @Autowired
    private ServletContext servletContext;
    
    @Autowired
    PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<?> login(@Valid @RequestBody User user){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		
		User myuser=userservice.loadUserByUsername(user.getUsername());
	
		if(myuser!=null){
		

			logger.debug("This is debug : " + passwordEncoder.matches( user.getPassword(),myuser.getPassword()));
			if(passwordEncoder.matches(user.getPassword(),myuser.getPassword())){
			    HashMap<String, String> rtn = new LinkedHashMap<String, String>();
			    rtn.put("auth", "basic " + encodebase64(user.getUsername(),user.getPassword()) + "");
			    rtn.put("firstname",myuser.getFirstname());
			    rtn.put("lastname", myuser.getLastname());
			    rtn.put("userid", myuser.getId().toString());
			    
			    logger.debug("firstname L: " +  myuser.toString());

				return ResponseEntity.ok().headers(responseHeaders).body(rtn);
				
			}else{
				throw new ResourceNotFoundException("Password not match");
			
			}
			
		}else{
			throw new ResourceNotFoundException("User not found");
		}
		
	}
	
	
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ResponseEntity<?> Signup(@Valid @RequestBody User user){
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");

		User temp=new User();
		
		String passwordencode = passwordEncoder.encode(user.getPassword());
		
		temp.setPassword(passwordencode);
		temp.setUsername(user.getUsername());
		temp.setFirstname(user.getFirstname());
		temp.setLastname(user.getLastname());
		temp.setEnabled(true);
		temp.setRoles(Arrays.asList(roleRepository.findByName("USER")));
	//	logger.debug(Arrays.asList(roleRepository.findByName("USER")).toString());
		
		UserDetails userDetails=userdetailsService.loadUserByUsername(user.getUsername());
		
		if(userDetails==null){
			
			userservice.save(temp);
			
			User savedUser=(User) userdetailsService.loadUserByUsername(temp.getUsername());
			
		    HashMap<String, String> rtn = new LinkedHashMap<String, String>();
		    rtn.put("auth", "basic " + encodebase64(user.getUsername(),user.getPassword()) + "");
		    rtn.put("firstname",savedUser.getFirstname());
		    rtn.put("lastname", savedUser.getLastname());
		    rtn.put("userid", savedUser.getId().toString());
		    
			return ResponseEntity.ok().headers(responseHeaders).body(rtn);
		}else{
			 throw new IllegalArgumentException("User already exist");
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(responseHeaders).body(badrequest);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/resetpassword")
	public String resetPassword(@RequestParam("email") String email,HttpServletRequest request){
		
		User user = userservice.loadUserByUsername(email);
		
		if (user == null) {
		    throw new UsernameNotFoundException("User Not found");
		}
		String token = UUID.randomUUID().toString();
		userservice.createPasswordResetTokenForUser(user, token);
		
		
		String message=constructResetTokenEmail(request.getScheme()+"://"+request.getServerName() + ":" + request.getServerPort(),token,user);
		return message;
			
	}
	
	private String constructResetTokenEmail(
			  String contextPath, String token, User user) {
			    String url = contextPath + "/changepassword?id=" + 
			      user.getId() + "&token=" + token;
			    String message = "reset password";
			    return ("Reset Password" + message + " \r\n" + url);
			}
	

	
	@RequestMapping(method=RequestMethod.GET, value="/changepassword",produces = "application/json")
	public String changePassword(@RequestParam("id") long userid,@RequestParam("token") String token){
		
		  String result = validatePasswordResetToken(userid, token);
		    return result;
			
	}
	
	
	@RequestMapping(value="/updatepassword",method=RequestMethod.POST)
	public String changepassword(@RequestBody PasswordResetToken token){
		 
		String result = validatePasswordResetToken(token.getUser().getId(), token.getToken());
		
		

		return result;
	}
	
	public String validatePasswordResetToken(long id,String token){
		
		PasswordResetToken passToken = 
			      passwordTokenRepository.findByToken(token);
			    if ((passToken == null) || (passToken.getUser()
			        .getId() != id)) {
			        return "invalidToken";
			    }
			    
			    Calendar passTokenDate= Calendar.getInstance();
			    
			    passTokenDate.setTime(passToken.getExpiryDate());
			    passTokenDate.add(Calendar.DAY_OF_MONTH, 1);
			 
			    Calendar cal = Calendar.getInstance();
			    
			    if(passTokenDate.getTimeInMillis()<cal.getTimeInMillis()){
			       return "Your token is expired";
			      }else{
			       return "changepassword";
			      }
	}
	

	
	

//	**********************HELPER*****************
	private String encodebase64(String username,String password){
		String str=username + ":" + password;
		byte[] encodedBytesUser = Base64.getEncoder().encode(str.getBytes());
		return new String(encodedBytesUser);
	}
	
	private void log(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		
	}
	

	
}
