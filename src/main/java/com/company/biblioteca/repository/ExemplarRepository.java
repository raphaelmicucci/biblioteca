package com.company.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.biblioteca.entity.Exemplar;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long>{

}
