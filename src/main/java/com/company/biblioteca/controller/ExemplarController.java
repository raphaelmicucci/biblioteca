package com.company.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.biblioteca.entity.Exemplar;
import com.company.biblioteca.service.ExemplarService;

@RestController
@RequestMapping("/exemplares")
public class ExemplarController {
	
	@Autowired
	private ExemplarService service;
	
	@PostMapping
	public ResponseEntity<Exemplar> salvaExemplar(@RequestBody Exemplar exemplar){
		exemplar = service.save(exemplar);
		
		return ResponseEntity.ok().body(exemplar);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Exemplar> buscaExemplar(@PathVariable Long id) {
		
		Exemplar exemplar = service.findById(id);
		
		return ResponseEntity.ok().body(exemplar);
	}
	
	@GetMapping
	public ResponseEntity<List<Exemplar>> buscaTodosExemplares() {
		
		List<Exemplar> exemplares = service.findAll();
		
		return ResponseEntity.ok().body(exemplares);
	}
}
