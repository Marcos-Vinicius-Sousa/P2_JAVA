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
import com.projetop2.model.Artista;
import com.projetop2.model.ArtistaService;


@Controller
public class ArtistaController {

	
	@Autowired
    private ApplicationContext context;

    @GetMapping("/artista")
    public String cadastrar(Model model) {
        model.addAttribute("art",new Artista());
        return "formarti";
    }

    @PostMapping("/artista")
    public String acao(@ModelAttribute Artista art,Model model) {
        model.addAttribute("artist",art);
        ArtistaService adao = context.getBean(ArtistaService.class);
        adao.insert(art);
        return "artistasucesso";
    }
    
    @GetMapping("descr/{id}")
    public String read(@PathVariable("id") int id, Model model){
		ArtistaService adao = context.getBean(ArtistaService.class);
		Map<String,Object> artista = adao.getArtista(id);
		Artista art = new Artista((String)artista.get("nm_Artista"),(String)artista.get("nm_esilo_musical"));
		model.addAttribute("art",art);
		return "eventosucesso";
    }
	
	@GetMapping("/artistas")
	public String listar(Model model) {
		ArtistaService pdao = context.getBean(ArtistaService.class);
		List<Map<String,Object>> artistas = pdao.getArtistas();
		model.addAttribute("artistas",artistas);
		return "formlistartistas";
	}
	
	@PostMapping("/apagar/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		ArtistaService pdao = context.getBean(ArtistaService.class);
		pdao.deleteArtista(id);
		return "redirect:/artistas";
	}

}
