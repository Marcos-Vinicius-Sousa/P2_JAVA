package com.spring.cursos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_container")
public class Container {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nm_cliente")
	private String nomeCliente;

	@Column(name = "cd_container")
	private String numContainer;

	@Column(name = "nm_tipo")
	private Integer tipo;

	@Column(name = "nm_status")
	private String status;

	@Column(name = "nm_categoria")
	private String categoria;

	public Container() {
	}

	

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}



	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNumContainer() {
		return numContainer;
	}

	public void setNumContainer(String numContainer) {
		this.numContainer = numContainer;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	  @OneToMany(mappedBy = "container") 
	  private List<Movimentacao> movimentacoes;


}
