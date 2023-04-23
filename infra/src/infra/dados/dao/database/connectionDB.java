package infra.dados.dao.database;

import java.sql.*;

public class connectionDB {
	private static Connection conn = null;
	
	public static Connection getConn(){
		
		if(conn == null) {
			
			try {
			Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/t1_paradigmas","postgres","");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

	}

		return conn;
	}
}
