package com.example.mongodb_learn.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.mongodb_learn.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice	// Torna a classe responsável por interceptar e tratar exceções de forma global para os controladores REST
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)  // Define que o método trata a exceção personalizada ObjectNotFoundException
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;  // Define o status HTTP 404 (Not Found) para o erro

		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Nao encontrado", e.getMessage(), request.getRequestURI());
		
		// Retorna uma resposta HTTP com o status e o corpo do erro formatado
		return ResponseEntity.status(status).body(err);
	}
}

