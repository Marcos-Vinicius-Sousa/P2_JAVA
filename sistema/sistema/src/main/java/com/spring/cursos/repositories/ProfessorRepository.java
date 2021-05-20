package com.spring.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.cursos.model.Professor;



@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
