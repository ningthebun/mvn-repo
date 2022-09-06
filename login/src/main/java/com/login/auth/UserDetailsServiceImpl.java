package com.login.auth;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.login.entity.User;
import com.login.service.UserService;

// abstract class - extends
// interface - implements

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired UserService userService;
	@Autowired PasswordEncoder passwordEncoder;
	
	// UserDetails only has 1 method below
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Account not found.");
		} else {
			// print in console
			System.out.println("UserDetailsService:" + user.getUsername());
			System.out.println("UserDetailsService:" + user.getPw());
		}
		
		// because got 2 User files so need to specify which User to use
		UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
		
		UserDetails userDetails = userBuilder.username(user.getUsername())
											 .password(user.getPw())
											 .roles(user.getRole())
											 .passwordEncoder(passwordEncoder::encode)
											 .build();
		
		return userDetails;
	}
}