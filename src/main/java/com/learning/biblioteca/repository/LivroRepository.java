package com.learning.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.biblioteca.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	public Livro findByIsbn(String isbn);
}
