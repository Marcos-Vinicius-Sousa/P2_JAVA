package com.spring.cursos.repositories;

import org.springframework.stereotype.Repository;

import com.spring.cursos.model.Prova;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProvaRepository extends JpaRepository<Prova,Long>{

}
