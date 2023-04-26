package infra.dados.dao.database;

import infra.dados.dao.DAO;
import infra.entidades.Registro;
//import infra.dados.dao.database.connectionDB;
import infra.negocios.DadoNaoEncontrado;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Map;

import org.hamcrest.core.IsInstanceOf;

public abstract class DAOdatabase<T extends Registro> implements DAO<T> {
	public String tableName;
	
	
	final static Connection conn =  connectionDB.getConn();
	
	abstract protected Map<String, String> createMapAdd(T elemento);
	
	public void adicionar(T t) throws IllegalArgumentException, IllegalAccessException {
		
		
		
		String prefix_sql = "INSERT INTO "+t.getClass().getSimpleName().toLowerCase()+" (";
		String suffix_sql = " VALUES ( ";
	    Field[] allFields = t.getClass().getDeclaredFields();
	    
	    for(Field field: allFields) {
	        field.setAccessible(true);
	        
	        
		    if(!(field.getType().toString().equalsIgnoreCase("class java.util.ArrayList")) 
		    		&& field.get(t) != null
		    		&& field.getName() != "id") {
		    	
		    	System.out.println(field.getName()+"| " +field.getType().toString() + ":" + field.get(t));
		    	prefix_sql+=(field.getName()+", ");
		    	suffix_sql+="?, ";
		    	}
		    }
	    
	    //Aqui remove a virgula
	    prefix_sql = prefix_sql.substring(0, prefix_sql.length()-2);
	    suffix_sql = suffix_sql.substring(0, suffix_sql.length()-2);
	    
	    //fecha o parenteses
	    prefix_sql+=")";
	    suffix_sql+=")";
	    
	    //Une as partes do sql
	    String sql = prefix_sql+suffix_sql;
	    
	    System.out.print(sql);
	    
	    //throw new IllegalAccessException("Exception message");
	    
	    try {
			PreparedStatement p = conn.prepareStatement(sql);
			System.out.println("Passou do prepared statement");
			int i = 1;
		    for(Field field: allFields) {
		        field.setAccessible(true);
		        
		        
		       switch(field.getType().toString()) {
			       
			       case "class java.util.ArrayList":{
			    	   break;
			       }
			       case "int":{
			    	   if(field.getName() != "id") {
			    	   System.out.println(field.get(t) + " | " + field.getType().toString() + " " + i);
			    	   p.setInt(i, field.getInt(t));
			    	   i++;
			    	   }
			    	   break;
			       }
			       case "class java.lang.String":{
			    	   System.out.println(field.get(t) + " | " + field.getType().toString() + " " + i + " "  + field.getName());
			    	   p.setString(i, (String)field.get(t));
			    	   i++;
			    	   break;
			       }
			       
			       default :{
			    	   System.out.println(((Registro)(field.get(t))).getId() + " | " + field.getType().toString() + " " + i);
			    	   p.setInt(i, ((Registro)(field.get(t))).getId());
			    	   i++;
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
