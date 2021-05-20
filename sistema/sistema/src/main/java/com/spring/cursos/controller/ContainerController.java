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

import com.spring.cursos.model.Container;
import com.spring.cursos.services.ContainerService;




@Controller
public class ContainerController {
	
	@Autowired
	private ContainerService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
	
	@RequestMapping(value="/listacontainer", method=RequestMethod.GET)
    public ModelAndView getContainers(){
        ModelAndView mv = new ModelAndView("listacontainer");
        List<Container> containers = service.findAll();
        mv.addObject("containers", containers);
        return mv;
    }
	
	 @RequestMapping(value="/container", method=RequestMethod.GET)
	    public String getContainerForm(Model model) {
			model.addAttribute("container", new Container());
	        return "container";
	    }
	 
	 @PostMapping(value="/container")
		public String container(Container container, Model model) {
		 model.addAttribute("container", container);	
		 service.insert(container);
			return "sucesso";
		}
	 
	 @RequestMapping(value="/container/delete/{id}", method = RequestMethod.DELETE)
	 public String deleteContainer(@PathVariable Long id) {
	     service.delete(id);
	     return "redirect:/listacontainer";
	 }
	 
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	 public ModelAndView putContainer(@PathVariable Long id ) {
		    ModelAndView mv = new ModelAndView("updatecontainer");
		    Container update = service.findbyId(id);
		    mv.addObject("update", update);
		    return mv;
		}
	 
	 @PostMapping(value="/edit/{id}")
	 public String putContainer(Container container, Model model) {
		 model.addAttribute("container", container);	
		 service.update(container);
			return "sucesso";
		}
		
	 
}
	

