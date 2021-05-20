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
import com.spring.cursos.model.Nota;
import com.spring.cursos.services.NotaService;


@Controller
public class NotaController {
	
	@Autowired
	private NotaService service;
	
	

	@RequestMapping(value="listanota", method=RequestMethod.GET)
    public ModelAndView getProvas(){
        ModelAndView mv = new ModelAndView("listanota");
        List<Nota> notas= service.findAll();
        mv.addObject("notas", notas);
        return mv;
    }

	@RequestMapping(value="/nota", method=RequestMethod.GET)
    public String geNotaForm(Model model) {
		model.addAttribute("nota", new Nota());
        return "cadastrarnota";
    }

	@PostMapping(value="/nota")
	public String nota(Nota nota, Model model) {
	 model.addAttribute("nota", nota);	
	 service.create(nota);
		return "redirect:/listanotas";
	}
	
	@RequestMapping(value="/nota/delete/{id}", method = RequestMethod.DELETE)
	 public String deleteNota(@PathVariable Long id) {
	     service.delete(id);
	     return "redirect:/listanotas";
	 }
	
	
	@RequestMapping(value="/nota/edit/{id}", method=RequestMethod.GET)
	 public ModelAndView putNota(@PathVariable Long id ) {
		    ModelAndView mv = new ModelAndView("updatenota");
		    Nota update = service.findById(id);
		    mv.addObject("update", update);
		    return mv;
		}
	
	
	@PostMapping(value="/nota/edit/{id}")
	 public String putNota(Nota nota, Model model) {
		 model.addAttribute("nota", nota);	
		 service.update(nota);
		 return "redirect:/listanotas";
		}

}