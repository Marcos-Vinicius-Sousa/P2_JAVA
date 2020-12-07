package com.projetop2.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.projetop2.model.Evento;
import com.projetop2.model.EventoService;

@Controller
public class EventoUpdController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/updev/{id}")
    public String updateFormEvt(@PathVariable("id") int id, Model model){
		EventoService edao = context.getBean(EventoService.class);
		Map<String,Object> antigo = edao.getEvento(id);
		Evento evt = new Evento((String)antigo.get("nome"),(String)antigo.get("local"));
		model.addAttribute("antigo",evt);
		model.addAttribute("id",id);
		return "eventoupdt";
    }
	
	@PostMapping("/updev/{id}")
	public String updateEv(@PathVariable("id") int id,@ModelAttribute Evento evt, Model model) {
		EventoService edao = context.getBean(EventoService.class);
		edao.updateEvento(id, evt);
		return "redirect:/eventos";
	}
}
