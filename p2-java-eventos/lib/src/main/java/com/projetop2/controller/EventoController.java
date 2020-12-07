package com.projetop2.controller;

import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetop2.model.Convidado;
import com.projetop2.model.ConvidadoService;
import com.projetop2.model.Evento;
import com.projetop2.model.EventoService;


@Controller
public class EventoController {

	@Autowired
    private ApplicationContext context;

    @GetMapping("/evento")
    public String cadastrar(Model model) {
        model.addAttribute("evt",new Evento());
        return "formevento";
    }

    @PostMapping("/evento")
    public String acao(@ModelAttribute Evento evt,Model model) {
        model.addAttribute("evt",evt);
        EventoService edao = context.getBean(EventoService.class);
        edao.insert(evt);
        return "eventosucesso";
    }
    
    @GetMapping("descrev/{id}")
    public String read(@PathVariable("id") int id, Model model){
		EventoService edao = context.getBean(EventoService.class);
		Map<String,Object> evento = edao.getEvento(id);
		Evento evt = new Evento((String)evento.get("nm_evento"),(String)evento.get("local"));
		model.addAttribute("evt",evt);
		return "eventosucesso";
    }
    
   
	
	@GetMapping("/eventos")
	public String listar(Model model) {
		EventoService edao = context.getBean(EventoService.class);
		List<Map<String,Object>> evento = edao.getEventos();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						
		model.addAttribute("evento",evento);
		return "listaeventos";
	}
	
	@PostMapping("/apagareve/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		EventoService edao = context.getBean(EventoService.class);
		edao.deleteEvento(id);
		return "redirect:/eventos";
	}

	
	
}
