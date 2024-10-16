package com.example.mongodb_learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb_learn.dto.UserDTO;
import com.example.mongodb_learn.entities.User;
import com.example.mongodb_learn.repositories.UserRepository;
import com.example.mongodb_learn.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();	// O metodo findAll ja vem pronto dentro do Spring Data
	}
	
	public User findById(String id) {
		// Funcao simpliifado, caso contrario o retorno do "userRepository.findById(id)" seria um Optional
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		
		return userRepository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setId(user.getId());
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}
