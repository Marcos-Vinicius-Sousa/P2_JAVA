package com.spring.cursos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.cursos.model.Aluno;
import com.spring.cursos.model.Curso;
import com.spring.cursos.repositories.AlunoRepository;
import com.spring.cursos.repositories.CursoRepository;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private CursoRepository repoCurso;
	
	
	public Aluno create(Aluno obj) {
		repository.save(obj);
		return obj;
	}

	
	public Aluno findById(Long id) {
		Optional<Aluno> _aluno = repository.findById(id);
		return _aluno.orElse(null);
	}

	
	public List<Aluno> findAll() {
		return repository.findAll();
	}

	
	public Aluno update(Aluno obj) {
		repository.existsById(obj.getId());
		return repository.save(obj);
	}

	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/*public Aluno cadastroAlunoCurso( Long idAluno , Long idCurso) {
		
		Optional<Aluno> alunoExistente = repository.findById(idAluno);
		Optional<Curso> cursoExistente = repoCurso.findById(idCurso);
		
		if(alunoExistente.isPresent() && cursoExistente.isPresent()) {
			alunoExistente.get().getCursos().add(cursoExistente.get());
			
			repository.save(alunoExistente.get());
			
			return repository.save(alunoExistente.get());
		}
		
		return null;
	}
	 */

}
