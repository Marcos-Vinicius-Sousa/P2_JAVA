package com.spring.cursos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cursos.model.Curso;
import com.spring.cursos.repositories.CursoRepository;



@Service
public class CursoService{

	@Autowired
	private CursoRepository repository;
	
	
	
	public Curso create(Curso obj) {
		repository.save(obj);
		return obj;
	}

	
	public Curso findById(Long id) {
		Optional<Curso> _curso = repository.findById(id);
		return _curso.orElse(null);
	}

	
	public List<Curso> findAll() {
		return repository.findAll();
	}

	
	public Curso update(Curso obj) {
		repository.existsById(obj.getId());
		return repository.save(obj);
	}

	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
