package com.example.mongodb_learn.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.mongodb_learn.dto.AuthorDTO;
import com.example.mongodb_learn.dto.CommentDTO;
import com.example.mongodb_learn.entities.Post;
import com.example.mongodb_learn.entities.User;
import com.example.mongodb_learn.repositories.PostRepository;
import com.example.mongodb_learn.repositories.UserRepository;

@Configuration  // Indica que esta classe é uma classe de configuração Spring, usada para definir beans e outras configurações.
public class Instantion implements CommandLineRunner {  // Implementa CommandLineRunner, faz com que um código seja executado assim que a aplicação for iniciada.
	
	@Autowired
	private UserRepository userRepository;  // Injeção de dependência do repositório de usuários para interagir com o MongoDB.
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();  // Limpa todos os dados existentes no repositório de usuários.
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));  // Insere os novos usuários no repositório.
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Aproveie", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um otimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
