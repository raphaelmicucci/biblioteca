package com.company.biblioteca.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.company.biblioteca.exception.LivroNullException;

@ControllerAdvice
public class LivroControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(LivroNullException.class)
	public ResponseEntity<Object> capturaErroNull(){
		
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("message", "Verifique os dados do livro");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	

}
