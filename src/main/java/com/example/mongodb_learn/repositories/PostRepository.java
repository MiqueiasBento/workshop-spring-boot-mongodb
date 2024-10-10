package com.example.mongodb_learn.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb_learn.entities.Post;
import java.util.List;


@Repository  // Indica que é um componente de repositório do Spring, responsável por interagir com o banco de dados.
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String title);	// Spring Data ja fica responsavel por montar essa consulta
														// O uso do IgnoreCase resolve problemas de sensibilidade a capitalizacao
}
