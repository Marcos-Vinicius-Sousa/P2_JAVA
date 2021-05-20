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
import com.spring.cursos.model.Prova;
import com.spring.cursos.services.ProvaService;


@Controller
public class ProvaController {
	
	@Autowired
	private ProvaService service;

	

	@RequestMapping(value="listaprova", method=RequestMethod.GET)
    public ModelAndView getProvas(){
        ModelAndView mv = new ModelAndView("listaprova");
        List<Prova> provas= service.findAll();
        mv.addObject("provas", provas);
        return mv;
    }

	@RequestMapping(value="/prova", method=RequestMethod.GET)
    public String getProvaForm(Model model) {
		model.addAttribute("prova", new Prova());
        return "cadastrarprova";
    }

	@PostMapping(value="/prova")
	public String prova(Prova prova, Model model) {
	 model.addAttribute("prova", prova);	
	 service.create(prova);
		return "redirect:/listaprovas";
	}
	
	@RequestMapping(value="/prova/delete/{id}", method = RequestMethod.DELETE)
	 public String deleteCurso(@PathVariable Long id) {
	     service.delete(id);
	     return "redirect:/listaprovas";
	 }
	
	
	@RequestMapping(value="prova/edit/{id}", method=RequestMethod.GET)
	 public ModelAndView putProva(@PathVariable Long id ) {
		    ModelAndView mv = new ModelAndView("updateprova");
		    Prova update = service.findById(id);
		    mv.addObject("update", update);
		    return mv;
		}
	
	
	@PostMapping(value="prova/edit/{id}")
	 public String putProva(Prova prova, Model model) {
		 model.addAttribute("prova", prova);	
		 service.update(prova);
		 return "redirect:/listaprovas";
		}


}
