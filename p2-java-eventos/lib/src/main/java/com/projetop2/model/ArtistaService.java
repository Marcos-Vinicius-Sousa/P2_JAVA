package com.projetop2.model;


import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArtistaService {

	@Autowired 
    ArtistaDAO adao;

    public void insert(Artista art) {
      adao.insert(art);
    }
    
    public Map<String, Object> getArtista(int id) {
		  return adao.getArtista(id);
	  }
	  
    public List<Map<String, Object>> getArtistas() {
	      return adao.getArtistas();
	  }
	  
	  public void deleteArtista(int id) {
		  adao.deleteArtista(id);
	  }
	  
	  public void updateArtista(int id, Artista art) {
		  adao.updateArtista(id, art);
	  }
}
