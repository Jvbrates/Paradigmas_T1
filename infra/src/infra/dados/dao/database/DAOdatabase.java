package infra.dados.dao.database;

import infra.dados.dao.DAO;
import infra.entidades.Registro;
//import infra.dados.dao.database.connectionDB;
import infra.negocios.DadoNaoEncontrado;
import java.sql.*;
import java.util.Map;

public abstract class DAOdatabase<T extends Registro> implements DAO<T> {
	static String tableName;
	
	
	final static Connection conn =  connectionDB.getConn();
	
	abstract protected Map<String, String> createMapAdd(T elemento);
	
	public void adicionar(T t) {

		Map<String, String> M = createMapAdd(t);

		
		String prepare_sql = "INSERT INTO ? VALUES ( "+ " ?".repeat(M.size()) + " )";
		
		try {
			
			int i = 0;
			PreparedStatement p = conn.prepareStatement(prepare_sql, Statement.RETURN_GENERATED_KEYS);
			p.setString(0, tableName);
			for (Map.Entry<String, String> item: M.entrySet()) {
				i++;
				if(item.getKey().charAt(0) == '_') {
					p.setInt(i, Integer.parseInt(item.getValue()));
				} else {
					p.setString(i, item.getValue());
				}
		        
				
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
