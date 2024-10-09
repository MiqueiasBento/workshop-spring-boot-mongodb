package com.example.mongodb_learn.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb_learn.entities.Post;

@Repository  // Indica que é um componente de repositório do Spring, responsável por interagir com o banco de dados.
public interface PostRepository extends MongoRepository<Post, String> {

}
