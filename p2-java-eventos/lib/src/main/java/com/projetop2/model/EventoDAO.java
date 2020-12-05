package com.projetop2.model;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.projetop2.model.Evento;

@Repository
public class EventoDAO {

	
	 @Autowired 
	    DataSource dataSource;

	    JdbcTemplate jdbc;
	    
	    @PostConstruct
	    private void initialize(){
	        jdbc = new JdbcTemplate(dataSource);
	    }

	    public void insert(Evento evt) {
	        String sql = "INSERT INTO evento " +
	    "(nm_evento,local) VALUES (?,?)" ;
	        jdbc.update(sql, new Object[]{
	                evt.getNome(), evt.getLocal()
	        });
	    }
	    
	    public Map<String, Object> getEvento(int id) {
	    	String sql = "SELECT * FROM evento WHERE evento.id = ?";
	    	return jdbc.queryForMap(sql,new Object[] {id});
	    }
	    
	    public List<Map<String, Object>> getEventos() {
	    	String sql = "SELECT * FROM evento";
	    	List<Map<String, Object>> eventos = (List<Map<String, Object>>) jdbc.queryForList(sql);
	    	return eventos;
	    }
	    
	    public void deleteEvento(int id) {
	        String sql = "DELETE FROM evento WHERE id = ?" ;
	        jdbc.update(sql, new Object[] {id});
	    }
	    
	    public void updateEvento(int id,Evento evt) {
	    	String sql = "UPDATE evento SET nm_evento = ?, local = ? WHERE id = ?";
	    	 jdbc.update(sql, new Object[]{
	         		evt.getNome(), evt.getLocal(),id
	         });
	    }
}
