package biblioteca.dados.database;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Editora;
import biblioteca.entidades.Livro;
import infra.dados.dao.DAO;

public class FabricaDAOdatabase extends FabricaDAO {
	
	private static final DAOLivro daoLivros = new DAOLivro();
	private static final DAOEditora daoEditoras = new DAOEditora();
	public DAO<Livro> getDAOLivros() {
		return daoLivros;
	}
	public DAO<Editora> getDAOEditoras() {
		return daoEditoras;
	}
}
