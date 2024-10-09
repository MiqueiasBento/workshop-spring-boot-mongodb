package com.example.mongodb_learn.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.mongodb_learn.entities.User;
import com.example.mongodb_learn.repositories.UserRepository;

@Configuration  // Indica que esta classe é uma classe de configuração Spring, usada para definir beans e outras configurações.
public class Instantion implements CommandLineRunner {  // Implementa CommandLineRunner, faz com que um código seja executado assim que a aplicação for iniciada.
	
	@Autowired
	private UserRepository userRepository;  // Injeção de dependência do repositório de usuários para interagir com o MongoDB.
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();  // Limpa todos os dados existentes no repositório de usuários.
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));  // Insere os novos usuários no repositório.
	}
}
