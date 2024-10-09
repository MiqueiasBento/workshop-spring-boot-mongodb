package com.example.mongodb_learn.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb_learn.entities.User;
import com.example.mongodb_learn.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // Mapeia uma operacao GET
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();	// service agora pode ser capaz de trazer todos os usuários do banco de dados
		return ResponseEntity.ok().body(list);
	}
}