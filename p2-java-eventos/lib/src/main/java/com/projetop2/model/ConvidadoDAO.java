package com.projetop2.model;


import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.projetop2.model.Convidado;

@Repository
public class ConvidadoDAO {

	
	@Autowired 
    DataSource dataSource;

    JdbcTemplate jdbc;
    
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insert(Convidado cvd) {
        String sql = "INSERT INTO convidado " +
    "(nm_convidado,rg) VALUES (?,?)" ;
        jdbc.update(sql, new Object[]{
                cvd.getNomeConvidado(), cvd.getRg()
        });
    }
    
    public Map<String, Object> getConvidado(int id) {
    	String sql = "SELECT * FROM convidado WHERE convidado.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getConvidados() {
    	String sql = "SELECT * FROM convidado";
    	List<Map<String, Object>> convidados = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return convidados;
    }
    
    public void deleteConvidado(int id) {
        String sql = "DELETE FROM convidado WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updateConvidado(int id,Convidado cvd) {
    	String sql = "UPDATE evento SET nm_convidado = ?, rg = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		cvd.getNomeConvidado(), cvd.getRg(),id
         });
    }
}
