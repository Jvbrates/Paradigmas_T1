package biblioteca.dados.database;

import biblioteca.entidades.Editora;
import infra.dados.dao.database.DAOdatabase;

public class DAOEditora extends DAOdatabase<Editora>{

	public DAOEditora() {
		super(Editora.class);
	}

}
