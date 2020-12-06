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
import com.projetop2.model.Convidado;
import com.projetop2.model.ConvidadoService;


@Controller
public class ConvidadoUpdController {

	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/updco/{id}")
    public String updateFormCon(@PathVariable("id") int id, Model model){
		ConvidadoService cdao = context.getBean(ConvidadoService.class);
		Map<String,Object> antigo = cdao.getConvidado(id);
		Convidado evt = new Convidado((String)antigo.get("nm_Convidado"),(String)antigo.get("rg"));
		model.addAttribute("antigo",evt);
		model.addAttribute("id",id);
		return "formconvidado";
    }
	
	@PostMapping("/updco/{id}")
	public String updateEv(@PathVariable("id") int id,@ModelAttribute Convidado evt, Model model) {
		ConvidadoService edao = context.getBean(ConvidadoService.class);
		edao.updateConvidado(id, evt);
		return "redirect:/convidados";
	
	}
}
