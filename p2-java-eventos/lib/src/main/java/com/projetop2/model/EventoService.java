package com.projetop2.model;

import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EventoService {

	@Autowired 
    EventoDAO evt;

    public void insert(Evento evo) {
      evt.insert(evo);
    }
    
    public Map<String, Object> getEvento(int id) {
		  return evt.getEvento(id);
	  }
	  
    public List<Map<String, Object>> getEventos() {
	      return evt.getEventos();
	  }
	  
	  public void deleteEvento(int id) {
		  evt.deleteEvento(id);
	  }
	  
	  public void updateEvento(int id, Evento eva) {
		  evt.updateEvento(id, eva);
	  }
}
