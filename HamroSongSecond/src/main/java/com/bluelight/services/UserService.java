package com.bluelight.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bluelight.model.PasswordResetToken;
import com.bluelight.model.User;
import com.bluelight.repository.PasswordTokenRepository;
import com.bluelight.repository.UserRepository;

@Service("userDetailsService")
public class UserService implements UserDetailsService  {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordTokenRepository passwordTokenRepository;

	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findOneByUsername(username);
	}
	
	public User save(User user){
		return userRepository.save(user);
	}

	public void createPasswordResetTokenForUser(User user, String token) {
	    PasswordResetToken myToken = new PasswordResetToken(token, user);
	    passwordTokenRepository.save(myToken);
	}

}
