package com.example.mongodb_learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb_learn.entities.Post;
import com.example.mongodb_learn.repositories.PostRepository;
import com.example.mongodb_learn.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		// Retorna um objeto Post caso encontre, senao retorna uma excecao
		return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}
}
