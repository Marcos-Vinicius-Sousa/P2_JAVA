package com.spring.cursos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_movimentacao")
@NamedQueries({@NamedQuery(name="Movimentacao.listarMovimentacaoPorContainer",
query= "select m from Movimentacao m JOIN m.container c where c.id = ?1")})
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nm_movimentacao")
	private String tpMovimentacao;

	@Column(name = "dt_inicio_movimentacao")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dataInicio;

	@Column(name = "dt_fim_movimentacao")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dataFim;
	
	@ManyToOne 
	@JoinColumn(name="container_id") 
	private Container container;
	
	public Movimentacao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTpMovimentacao() {
		return tpMovimentacao;
	}

	public void setTpMovimentacao(String tpMovimentacao) {
		this.tpMovimentacao = tpMovimentacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container=container;
		
	}

	public Movimentacao(String tpMovimentacao, Date dataInicio, Date dataFim, Container container) {
		super();
		this.tpMovimentacao = tpMovimentacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.container = container;
	}
	
	

	
	  
	 
	 

}
