package com.spring.cursos.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nm_professor")
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="curso_id")
	private Curso curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
	

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Curso getCurso() {
		return curso;
	}
	
	/*
	public String getCurso() {
		return curso.getNome();
	} */
	
	/* 
	 * <div class="mb-3">
						<label>Curso:</label>
							<div class="input-group">
							<select name="cursos" id="cursos" class="form-control">
								<option th:each="cursos : ${cursos}"
								th:value="${cursos.id}"
								th:data="${cursos.id}"
								th:text="${cursos.nome}">
							</select>
							</div>
					</div>
	 */

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor() {
		
	}
	
	public Professor( String nome,  String cpf,  String email,
			 String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		
	}
	
	
}
