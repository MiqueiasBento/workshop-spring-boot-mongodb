package com.example.mongodb_learn.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb_learn.dto.UserDTO;
import com.example.mongodb_learn.entities.User;
import com.example.mongodb_learn.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;

	@GetMapping // Mapeia uma operacao GET
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();	// service agora pode ser capaz de trazer todos os usuários do banco de dados
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());	// Conversao de uma lista de User para UserDTO
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);	// service agora pode ser capaz de trazer todos os usuários do banco de dados
		return ResponseEntity.ok().body(new UserDTO(user));
	}
}