package com.spring.sistemat2s.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.sistemat2s.model.Movimentacao;
import com.spring.sistemat2s.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repo;

	public List<Movimentacao> findAll() {
		return repo.findAll();
	}

	public Movimentacao insert(Movimentacao obj) {
		repo.save(obj);
		return obj;
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Movimentacao> listarMovimentacaoPorContainer(Long id) {
		return repo.listarMovimentacaoPorContainer(id);
	}

	public Movimentacao update(Movimentacao obj) {
		repo.existsById(obj.getId());
		return repo.save(obj);
	}

	public Movimentacao findbyId(Long id) {
		Optional<Movimentacao> _movimentacao = repo.findById(id);
		return _movimentacao.orElse(null);
	}
	

}
