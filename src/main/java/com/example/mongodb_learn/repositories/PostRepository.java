package com.example.mongodb_learn.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mongodb_learn.entities.Post;


@Repository  // Indica que é um componente de repositório do Spring, responsável por interagir com o banco de dados.
public interface PostRepository extends MongoRepository<Post, String> {
	
	// Especifica uma consulta personalizada no MongoDB
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")  // Define uma consulta personalizada no MongoDB, buscando documentos onde o campo 'title' corresponda a uma expressão regular (regex) fornecida como parâmetro
	List<Post> searchTitle(String text);  // Método que retorna uma lista de posts cujo título contém o texto passado, ignorando capitalizacao
	
	List<Post> findByTitleContainingIgnoreCase(String title);	// Spring Data ja fica responsavel por montar essa consulta
														// O uso do IgnoreCase resolve problemas de sensibilidade a capitalizacao
}
