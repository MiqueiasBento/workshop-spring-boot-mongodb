package com.example.mongodb_learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb_learn.entities.User;
import com.example.mongodb_learn.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();	// O metodo findAll ja vem pronto dentro do Spring Data
	}
}
