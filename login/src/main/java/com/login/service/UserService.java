package com.login.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.login.entity.User;
import com.login.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	
	@Autowired UserRepository repo;
	
	// select all records
//	public List<User> listAll() {
//		return (List<User>) repo.findAll();
//	}
	
	// get record by PK
	public User get(Long id) {
		return repo.findById(id).get();
	}
	
	// delete record by PK
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Optional<User> findUserByUsername(User u) {
		return repo.findUserByUsername(u.getUsername());
	}
	
	public User findByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	// login
	public Optional<User> validateUser(User login) {
		return repo.findByUsernameAndPw(login.getUsername(), login.getPw());
	}
	
	public Optional<User> findById(Long id) {
		return repo.findById(id);
	}
}