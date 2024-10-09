package com.example.mongodb_learn.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb_learn.entities.User;

@Repository  // Indica que é um componente de repositório do Spring, responsável por interagir com o banco de dados.
public interface UserRepository extends MongoRepository<User, String> {  // Para operações CRUD no MongoDB, usando o tipo "User" e a chave primária como "String".
	/*
	 * Esse código define um repositório para a entidade User usando MongoDB como banco de dados. 
	 * Ao estender a interface MongoRepository, ele herda métodos padrão como save(), findAll(), 
	 * findById(), entre outros, que facilitam o trabalho com dados no MongoDB.
	 */
}
