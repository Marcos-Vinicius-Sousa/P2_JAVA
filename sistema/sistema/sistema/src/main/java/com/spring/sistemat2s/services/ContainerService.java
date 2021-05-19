package com.spring.sistemat2s.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sistemat2s.model.Container;
import com.spring.sistemat2s.repositories.ContainerRepository;

@Service
public class ContainerService {

	@Autowired
	private ContainerRepository repo;

	public List<Container> findAll() {
		return repo.findAll();
	}

	public Container insert(Container obj) {
		return repo.save(obj);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Container update(Container obj) {
		repo.existsById(obj.getId());
		return repo.save(obj);
	}

	public Container findbyId(Long id) {
		Optional<Container> _container = repo.findById(id);
		return _container.orElse(null);
	}

}
