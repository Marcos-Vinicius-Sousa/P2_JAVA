package com.spring.sistemat2s.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.sistemat2s.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

	List<Movimentacao>listarMovimentacaoPorContainer(Long id);
	
}
