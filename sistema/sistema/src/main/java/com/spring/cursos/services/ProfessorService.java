package com.spring.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.cursos.model.Professor;
import com.spring.cursos.repositories.ProfessorRepository;
import java.util.Optional;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;
	
	
	public Professor create(Professor obj) {
		repository.save(obj);
		return obj;
	}

	
	public Professor findById(Long id) {
		Optional<Professor> _professor = repository.findById(id);
		return _professor.orElse(null);
	}

	
	public List<Professor> findAll() {
		return repository.findAll();
	}

	
	public Professor update(Professor obj) {
		repository.existsById(obj.getId());
		return repository.save(obj);	
	}

	
	public void delete(Long id) {
			repository.deleteById(id);
			}
}
