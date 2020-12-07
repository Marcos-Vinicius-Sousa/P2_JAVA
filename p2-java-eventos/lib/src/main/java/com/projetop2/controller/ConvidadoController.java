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
        model.addAttribute("con",new Convidado());
        return "formconvidado";
    }

    @PostMapping("/convidado")
    public String acao(@ModelAttribute Convidado con,Model model) {
        model.addAttribute("con",con);
        ConvidadoService cdao = context.getBean(ConvidadoService.class);
        cdao.insert(con);
        return "convidadosucesso";
    }
    
    @GetMapping("descrcon/{id}")
    public String read(@PathVariable("id") int id, Model model){
		ConvidadoService cdao = context.getBean(ConvidadoService.class);
		Map<String,Object> convidado = cdao.getConvidado(id);
		Convidado con = new Convidado((String)convidado.get("nm_convidado"),(String)convidado.get("rg"));
		model.addAttribute("con",con);
		return "convidadosucesso";
    }
	
	@GetMapping("/convidados")
	public String listarConv(Model model) {
		ConvidadoService cdao = context.getBean(ConvidadoService.class);
		List<Map<String,Object>> con = cdao.getConvidados();
		model.addAttribute("convidados",con);
		return "listaconvidados";
	}
	
	@PostMapping("/apagarcon/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		ConvidadoService cdao = context.getBean(ConvidadoService.class);
		cdao.deleteConvidado(id);
		return "redirect:/convidados";
	}

	
}
