package com.learning.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.biblioteca.entity.Livro;
import com.learning.biblioteca.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@PostMapping
	public ResponseEntity<Livro> salvaLivro(@RequestBody Livro livro) {
		
		livro = service.save(livro);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> buscaLivro(@PathVariable Long id) {
		
		Livro livro = service.findById(id);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> buscaTodosLivros() {
		
		List<Livro> livros = service.findAll();
		
		return ResponseEntity.ok().body(livros);
	}
	
}
