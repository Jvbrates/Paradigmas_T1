package infra.dados.dao.database;

import infra.dados.dao.DAO;
import infra.entidades.Registro;
//import infra.dados.dao.database.connectionDB;
import infra.negocios.DadoNaoEncontrado;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.sql.RowSet;


public abstract class DAOdatabase<T extends Registro> implements DAO<T> {
		
	final static Connection conn =  connectionDB.getConn();
	
	protected static String tableName;
	T instance;
	
	public DAOdatabase(String i) {
		tableName = i;
	}
	
	public String getTableName() {
		return tableName;
	}
	
		
	/*
	 * Percorre os parametros do registro.
	 * Caso id esteja definido raise exception
	 * Caso o parametro seja um Inteiro/Long ou String, coloca o valor no sql
	 * Caso o parametro seja um object get_id for insert as foreing key in the table
	 * Array são ignoradas e devem ser tratadas pela classe filha*/
	public void adicionar(T t) throws IllegalArgumentException, IllegalAccessException, Exception {
		
		
		
		String prefix_sql = "INSERT INTO "+t.getClass().getSimpleName().toLowerCase()+" (";
		String suffix_sql = " VALUES ( ";
		
		
	    Field[] allFields = t.getClass().getDeclaredFields();
	    
	    
	    for(Field field: allFields) {
	        field.setAccessible(true);
	        
	        // Por favor que este IF funcione
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
	    	
			PreparedStatement p = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			System.out.println("Passou do prepared statement");
			int i = 1;
		    for(Field field: allFields) {
		        field.setAccessible(true);
		        
		        
		       switch(field.getType().toString()) {
			       
			       case "class java.util.ArrayList":{
			    	   break;
			       }
			       case "int":
			       case "long":{
			    	   if(field.getName() != "id") {
			    	   System.out.println(field.get(t) + " | " + field.getType().toString() + " " + i);
			    	   p.setInt(i, field.getInt(t));
			    	   i++;
			    	   } else {
			    		   if((long)(field.get(t)) != 0) {
			    			   throw new Exception("Id definido, isto não deve ocorrer "+ field.get(t));
			    		   }
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
			    	   System.out.println( field.getName()+" _|" + field.getType().toString() + " " + i);
			    	   long id = (
			    			   (
			    					   (Registro)(
			    							   field.get(t)
			    							   )
	    					   )
			    			   .getId()
			    			   );
			    	   p.setLong(i, id);
			    	   i++;
			       }
			       
		       }
		        
		    }

		    
		    int r = p.executeUpdate();
		    
		    try (ResultSet generatedKeys = p.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	System.out.print(generatedKeys.getLong(1));
	                t.setId(generatedKeys.getLong(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
		    
		   if(r == 0) {
		    	System.out.println("Deu merda");
		    } else {
		    	System.out.println("Deu Certo");
		    }
		    
		    
		    
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  return;
	    
	    
	};
	
	/*Remove com base no ID*/
	public void remover(T t) throws DadoNaoEncontrado, Exception, SQLException{
		if(t.getId() == 0) {
			throw new Exception("Id não definido");
		}
		
		String sql = "DELETE FROM "+t.getClass().getSimpleName().toLowerCase()+" WHERE ID = ?";
		PreparedStatement p = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
			p.setLong(1, t.getId());
			int affectd_rows = p.executeUpdate();
			if(affectd_rows == 0) {
				throw new DadoNaoEncontrado();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	};
	
	
	abstract protected Collection<T> CollectionFromRSet(ResultSet rset) throws Exception;
	
	public Collection<T> buscar(T t) throws DadoNaoEncontrado, Exception, IllegalAccessException{
		String sql = "SELECT * FROM "+getTableName()+" WHERE ";
		
		Field[] allFields = null;
		if(t != null) {
		
			allFields = t.getClass().getDeclaredFields();
	    
	    
			for(Field field: allFields) {
	        field.setAccessible(true);
	        
	        // Por favor que este IF funcione
		    if(!(field.getType().toString().equalsIgnoreCase("class java.util.ArrayList")) 
		    		&& field.get(t) != null) 
			    {
		    		if(field.getName() == "id" && field.getLong(t) == 0) {
		    			continue;
	    			}
			    	System.out.println(field.getName()+"| " +field.getType().toString() + ":" + field.get(t));
			    	sql+=field.getName()+" ";
			    	
			    	switch(field.getType().toString()) {
				       
				       case "class java.util.ArrayList":{
				    	   break;
				       }
				       case "int":
				       case "long":{
				    	   
				    	   sql+=" = ? AND";
				    			  
				    	   break;
				       }
				       case "class java.lang.String":{
				    	   sql+= "LIKE ? AND ";
				    	   break;
				       }
				       
				       default :{
				    	   sql+=" = ? AND";
				       }
				       
			       }
		    	}
		    
			}
		}
				
		sql += " 1 = 1";
		
		System.out.println(sql);
		
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			int i = 1;
			if(t != null) {
			    for(Field field: allFields) {
			        field.setAccessible(true);
			        
			       if(field.get(t) == null || (field.getName()=="id" && field.getLong(t) == 0))
					continue;
			        
			       switch(field.getType().toString()) {
			       
				       case "class java.util.ArrayList":{
				    	   break;
				       }
				       case "int":{
				    	   p.setInt(i, field.getInt(t));
				    	   i++;
				    	   break;
				       }
				       case "long":{
				    	   p.setLong(i, field.getLong(t));
				    	   i++;
				    	   break;
				    	  
				       }
				       case "class java.lang.String":{
				    	   System.out.println(field.get(t)+ field.getName());
				    	   p.setString(i, "%"+(String)field.get(t)+"%");
				    	   i++;
				    	   break;
				       }
				       
				       default :{
				    	   System.out.println( field.getName()+" _|" + field.getType().toString() + " " + i);
				    	   long id = (
				    			   (
				    					   (Registro)(
				    							   field.get(t)
				    							   )
		    					   )
				    			   .getId()
				    			   );
				    	   p.setLong(i, id);
				    	   i++;
				    	   
				       }
				       
			       }
			       
			    }
			}
		    System.out.println(sql);
		    
		    ResultSet r = p.executeQuery();
		    
		    
		    
		    return CollectionFromRSet(r);

			
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		return null;
		
	};
	
	public Collection<T> buscarTodos() throws SQLException, Exception{
		
		 Collection<T> a = buscar(instance); 
		
		return null;
		
	};
	


}
