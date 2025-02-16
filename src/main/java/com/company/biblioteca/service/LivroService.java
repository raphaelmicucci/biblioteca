package com.company.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.biblioteca.entity.Livro;
import com.company.biblioteca.exception.LivroNullException;
import com.company.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	
	public Livro save(Livro livro) {
		if (livro.getTitulo() == null || livro.getAutor() == null) {
			throw new LivroNullException();
		}
		return repository.save(livro);
	}
	
	public Livro findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Livro> findAll() {
		return repository.findAll();
	}
}
