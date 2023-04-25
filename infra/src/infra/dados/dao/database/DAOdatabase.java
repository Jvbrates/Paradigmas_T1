package infra.dados.dao.database;

import infra.dados.dao.DAO;
import infra.entidades.Registro;
//import infra.dados.dao.database.connectionDB;
import infra.negocios.DadoNaoEncontrado;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Map;

public abstract class DAOdatabase<T extends Registro> implements DAO<T> {
	static String tableName;
	
	
	final static Connection conn =  connectionDB.getConn();
	
	abstract protected Map<String, String> createMapAdd(T elemento);
	
	public void adicionar(T t) throws IllegalArgumentException, IllegalAccessException {
		
		
		String sql = "INSERT INTO ? VALUES ( ";
	    Field[] allFields = t.getClass().getDeclaredFields();
	    
	    for(Field field: allFields) {
	        field.setAccessible(true);
	
		    if(field.getType().toString() != "Arraylist" && field.get(t) != null) {
		    	sql+="? ,";
		    	}
		    }
	    
	    //Aqui remove a virgula
	    sql+=");";
	    
	    try {
			PreparedStatement p = conn.prepareStatement(sql);
			int i = 1;
		    for(Field field: allFields) {
		        field.setAccessible(true);
		        
		       switch(field.getType().toString()) {
			       
			       case "ArrayList":{
			    	   break;
			       }
			       case "int":{
			    	   p.setInt(i, field.getInt(t));
			    	   break;
			       }
			       case "class java.lang.String":{
			    	   p.setString(i, (String)field.get(t));
			    	   break;
			       }
			       
			       default :{
			    	   p.setInt(i, ((Registro)(field.get(t))).getId());
			       }
			       
		       }
		        
		    }
		    
		    
		    int r = p.executeUpdate();
		    if(r == 0) {
		    	System.out.println("Deu merda");
		    } else {
		    	System.out.println("Deu Certo");
		    }
		    
		    
		    
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	};
	
	
	
	
	public T buscar(T elemento) throws DadoNaoEncontrado{
		return elemento;
	};
	


}
