package com.spring.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cursos.model.Aluno;



@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
