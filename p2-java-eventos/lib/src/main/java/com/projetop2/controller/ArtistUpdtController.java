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

import com.projetop2.model.Artista;
import com.projetop2.model.ArtistaService;


@Controller
public class ArtistUpdtController {

	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/updart/{id}")
    public String updateFormArt(@PathVariable("id") int id, Model model){
		ArtistaService adao = context.getBean(ArtistaService.class);
		Map<String,Object> antigo = adao.getArtista(id);
		Artista art = new Artista((String)antigo.get("nm_artista"),(String)antigo.get("nm_estilo_musical"));
		model.addAttribute("antigo",art);
		model.addAttribute("id",id);
		return "artistaupdt";
    }
	
	@PostMapping("/updart/{id}")
	public String updateEv(@PathVariable("id") int id,@ModelAttribute Artista art, Model model) {
		ArtistaService adao = context.getBean(ArtistaService.class);
		adao.updateArtista(id, art);
		return "redirect:/artistas";
	}
}
