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
import com.spring.cursos.services.CursoService;


@Controller
public class CursoController {

	@Autowired
	private CursoService service;

	@RequestMapping(value="/listacursos", method=RequestMethod.GET)
    public ModelAndView getCursos(){
        ModelAndView mv = new ModelAndView("listacursos");
        List<Curso> cursos= service.findAll();
        mv.addObject("cursos", cursos);
        return mv;
    }

	@RequestMapping(value="/curso", method=RequestMethod.GET)
    public String getCursoForm(Model model) {
		model.addAttribute("curso", new Curso());
        return "cadastrarcurso";
    }

	@PostMapping(value="/curso")
	public String curso(Curso curso, Model model) {
	 model.addAttribute("curso", curso);	
	 service.create(curso);
		return "redirect:/listacursos";
	}
	
	@GetMapping(value="/curso/delete/{id}")
	 public String deleteCurso(@PathVariable Long id) {
	     service.delete(id);
	     return "redirect:/listacursos";
	 }
	
	
	@RequestMapping(value="/edita/{id}", method=RequestMethod.GET)
	 public ModelAndView putCurso(@PathVariable Long id ) {
		    ModelAndView mv = new ModelAndView("updatecurso");
		    Curso update = service.findById(id);
		    mv.addObject("update", update);
		    return mv;
		}
	
	
	@PostMapping(value="/edita/{id}")
	 public String putCurso(Curso curso, Model model) {
		 model.addAttribute("curso", curso);	
		 service.update(curso);
		 return "redirect:/listacursos";
		}

}
