package com.spring.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cursos.model.Curso;



@Repository
public interface CursoRepository extends JpaRepository<Curso,Long>{

}
