package com.spring.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cursos.model.Curso;
import com.spring.cursos.model.Professor;
import com.spring.cursos.services.CursoService;
import com.spring.cursos.services.ProfessorService;


@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService service;
	
	@Autowired
	private CursoService _cursos;
	
	

	@RequestMapping(value="listaprofessores", method=RequestMethod.GET)
    public ModelAndView getProfessores(){
        ModelAndView mv = new ModelAndView("listaprofessores");
        List<Professor> professores = service.findAll();
        mv.addObject("professores", professores);
        return mv;
    }

	@RequestMapping(value="/professor", method=RequestMethod.GET)
    public String getProfessorForm(Model model) {
		List<Curso> cursos = _cursos.findAll();
		model.addAttribute("cursos", cursos);
		model.addAttribute("professor", new Professor());
		
        return "cadastrarprofessor";
    }

	@PostMapping(value="/professor")
	public String professor(Professor professor, Model model) {
	 model.addAttribute("professor", professor);	
	 service.create(professor);
		return "redirect:/listaprofessores";
	}
	
	@GetMapping(value="/professor/delete/{id}")
	 public String deleteProfessor(@PathVariable Long id) {
	     service.delete(id);
	     return "redirect:/listaprofessores";
	 }
	
	
	@RequestMapping(value="/editando/{id}", method=RequestMethod.GET)
	 public ModelAndView putProfessor(@PathVariable Long id ) {
		    ModelAndView mv = new ModelAndView("updateprofessor");
		    Professor update = service.findById(id);
		    mv.addObject("update", update);
		    return mv;
		}
	
	
	@PostMapping(value="/editando/{id}")
	 public String putProfessor(Professor professor, Model model) {
		 model.addAttribute("professor", professor);	
		 service.update(professor);
		 return "redirect:/listaprofessores";
		}
	
	
	

}
