package com.bluelight.nycproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bluelight.nycproject.entity.Role;
import com.bluelight.nycproject.entity.User;
import com.bluelight.nycproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void createUser(User user){
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole=new Role("USER");
		List<Role> roles=new ArrayList<Role>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	public void createAdmin(User user){
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole=new Role("ADMIN");
		List<Role> roles=new ArrayList<Role>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public User findOne(String email){
		return userRepository.findById(email).orElse(null);
	}
	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		User u=userRepository.findById(email).orElse(null);
		if(u!=null)
			return true;
		
		return false;
	}
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	public List<User>  findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByNameLike("%" + name + "%");
	}


}
