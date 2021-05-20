package com.spring.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.cursos.model.Nota;



@Repository
public interface NotaRepository extends JpaRepository<Nota,Long>{

}
