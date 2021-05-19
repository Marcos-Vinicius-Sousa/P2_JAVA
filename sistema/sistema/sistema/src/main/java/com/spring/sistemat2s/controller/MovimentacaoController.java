package com.spring.sistemat2s.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.spring.sistemat2s.model.Movimentacao;
import com.spring.sistemat2s.services.MovimentacaoService;


@Controller
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoService service;
	
	@RequestMapping(value="/sobre", method=RequestMethod.GET)
    public ModelAndView sobre(){
        ModelAndView mv = new ModelAndView("sobre");
        return mv;
    }
	
	@RequestMapping(value="/listamovimentacao", method=RequestMethod.GET)
    public ModelAndView getMovimentacaos(){
        ModelAndView mv = new ModelAndView("listamovimentacao");
        List<Movimentacao> movimentacoes = service.findAll();
        mv.addObject("movimentacoes", movimentacoes);
        return mv;
    }
	
	@GetMapping(value="/movimentacoes/{codigo}")
	public ResponseEntity<List<Movimentacao>> 
	getByContainer(@PathVariable("codigo")  Long codigo){
		return ResponseEntity.ok(service.listarMovimentacaoPorContainer(codigo));
		
	}
	
	 @RequestMapping(value="/movimentacao", method=RequestMethod.GET)
	    public String getMovimentacaoForm(Model model) {
			model.addAttribute("movimentacao", new Movimentacao());
	        return "movimentacao";
	    }
	 
	 @PostMapping(value="/movimentacao")
		public String movimentacao(Movimentacao movimentacao, Model model) {
		 model.addAttribute("movimentacao", movimentacao);	
		 service.insert(movimentacao);
			return "sucessomovimentacao";
		}
	 
	 @RequestMapping(value="/movimentacao/delete/{id}", method = RequestMethod.DELETE)
	 public String deleteMovimentacao(@PathVariable Long id) {
	     service.delete(id);
	     return "redirect:/listamovimentacao";
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView putMovimentacao(@PathVariable Long id ) {
		    ModelAndView mv = new ModelAndView("updatemovimentacao");
		    Movimentacao update = service.findbyId(id);
		    mv.addObject("update", update);
		    return mv;
		}
	 
	 @PostMapping(value="/update/{id}")
	 public String putMovimentacao(Movimentacao movimentacao, Model model) {
		 model.addAttribute("movimentacao", movimentacao);	
		 service.update(movimentacao);
			return "sucessomovimentacao";
		}
	 
	

}
