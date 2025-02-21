package com.learning.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.biblioteca.entity.Exemplar;
import com.learning.biblioteca.entity.Livro;
import com.learning.biblioteca.exception.LivroNullException;
import com.learning.biblioteca.repository.ExemplarRepository;
import com.learning.biblioteca.repository.LivroRepository;

@Service
public class ExemplarService {
	
	@Autowired
	private ExemplarRepository exemplarRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public Exemplar save(Exemplar exemplar) {
		if (exemplar.getLivro() == null || exemplar.getLivro().getId() == null) {
			throw new LivroNullException();
		}
		Livro livro = livroRepository.findById(exemplar.getLivro().getId())
				.orElseThrow(() -> new RuntimeException("Livro não encontrado"));
		
		exemplar.setLivro(livro);
		return exemplarRepository.save(exemplar);
	}
	
	public Exemplar findById(Long id) {
		return exemplarRepository.findById(id).orElse(null);
	}
	
	public List<Exemplar> findAll(){
		return exemplarRepository.findAll();
	}
}
