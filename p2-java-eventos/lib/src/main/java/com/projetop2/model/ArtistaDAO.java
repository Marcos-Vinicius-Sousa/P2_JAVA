package com.projetop2.model;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.projetop2.model.Artista;

@Repository
public class ArtistaDAO {

	@Autowired 
    DataSource dataSource;

    JdbcTemplate jdbc;
    
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insert(Artista art) {
        String sql = "INSERT INTO artista " +
    "(nm_artista,nm_estilo_musical) VALUES (?,?)" ;
        jdbc.update(sql, new Object[]{
                art.getNomeArtista(), art.getEstiloMusical()
        });
    }
    
    public Map<String, Object> getArtista(int id) {
    	String sql = "SELECT * FROM artista WHERE artista.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getArtistas() {
    	String sql = "SELECT * FROM artista";
    	List<Map<String, Object>> artistas = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return artistas;
    }
    
    public void deleteArtista(int id) {
        String sql = "DELETE FROM artista WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updateArtista(int id,Artista art) {
    	String sql = "UPDATE artista SET nm_artista = ?, nm_estilo_musical = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		art.getNomeArtista(), art.getEstiloMusical(),id
         });
    }
}
