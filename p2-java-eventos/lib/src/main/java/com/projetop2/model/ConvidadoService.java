package com.projetop2.model;

import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConvidadoService {

	
	@Autowired 
    ConvidadoDAO cdao;

    public void insert(Convidado con) {
      cdao.insert(con);
    }
    
    public Map<String, Object> getConvidado(int id) {
		  return cdao.getConvidado(id);
	  }
	  
    public List<Map<String, Object>> getConvidados() {
	      return cdao.getConvidados();
	  }
	  
	  public void deleteConvidado(int id) {
		  cdao.deleteConvidado(id);
	  }
	  
	  public void updateConvidado(int id, Convidado cnd) {
		  cdao.updateConvidado(id, cnd);
	  }
}
