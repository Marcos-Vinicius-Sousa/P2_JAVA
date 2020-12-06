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
import com.projetop2.model.ConvidadoService;


@Controller
public class ConvidadoController {

	
	@Autowired
    private ApplicationContext context;

    @GetMapping("/convidado")
    public String cadastrar(Model model) {
        model.addAttribute("con",new Evento());
        return "formcon";
    }

    @PostMapping("/convidao")
    public String acao(@ModelAttribute Convidado cnd,Model model) {
        model.addAttribute("event",cnd);
        ConvidadoService cdao = context.getBean(ConvidadoService.class);
        cdao.insert(cnd);
        return "convidadosucesso";
    }
    
    @GetMapping("descrcon/{id}")
    public String read(@PathVariable("id") int id, Model model){
		ConvidadoService edao = context.getBean(ConvidadoService.class);
		Map<String,Object> convidado = edao.getConvidado(id);
		Convidado con = new Convidado((String)convidado.get("nm_convidado"),(String)convidado.get("rg"));
		model.addAttribute("con",con);
		return "convidadosucesso";
    }
	
	@GetMapping("/convidados")
	public String listar(Model model) {
		ConvidadoService pdao = context.getBean(ConvidadoService.class);
		List<Map<String,Object>> convidados = pdao.getConvidados();
		model.addAttribute("convidados",convidados);
		return "formlistconvidados";
	}
	
	@PostMapping("/apagarcon/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		ConvidadoService pdao = context.getBean(ConvidadoService.class);
		pdao.deleteConvidado(id);
		return "redirect:/convidados";
	}

	
}
