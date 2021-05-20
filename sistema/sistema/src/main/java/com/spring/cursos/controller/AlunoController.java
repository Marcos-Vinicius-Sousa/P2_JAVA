package com.spring.cursos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.spring.cursos.model.Aluno;
import com.spring.cursos.model.Curso;
import com.spring.cursos.services.AlunoService;
import com.spring.cursos.services.CursoService;


@Controller
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	@Autowired
	private CursoService _cursos;
	
	@RequestMapping(value="/listaalunos", method=RequestMethod.GET)
	public ModelAndView getAlunos(){
        ModelAndView mv = new ModelAndView("listaaluno");
        List<Aluno> alunos = service.findAll();
        mv.addObject("alunos", alunos);
        return mv;
    }
	
	
	
	 @RequestMapping(value="/aluno", method=RequestMethod.GET)
	    public String getAlunoForm(Model model) {
		 List<Curso> cursos = _cursos.findAll();
			model.addAttribute("cursos", cursos);
			model.addAttribute("aluno", new Aluno());
	        return "cadastraraluno";
	    }


	 @PostMapping(value="/aluno")
		public String aluno(Aluno aluno, Model model) {
		 model.addAttribute("aluno", aluno);	
		 service.create(aluno);
			return "listaalunos";
		}
	 
	 
	 @RequestMapping(value="/aluno/delete/{id}", method = RequestMethod.DELETE)
	 public String deleteAluno(@PathVariable Long id) {
	     service.delete(id);
	     return "redirect:/listaalunos";
	 }
	 
	 @RequestMapping(value="/aluno/update/{id}", method=RequestMethod.GET)
	 public ModelAndView putAluno(@PathVariable Long id ) {
		    ModelAndView mv = new ModelAndView("updatealuno");
		    Aluno update = service.findById(id);
		    mv.addObject("update", update);
		    return mv;
		}
	 
	 @PostMapping(value="/aluno/update/{id}")
	 public String putAluno(Aluno aluno, Model model) {
		 model.addAttribute("aluno", aluno);	
		 service.update(aluno);
			return "listaalunos";

		}

}
