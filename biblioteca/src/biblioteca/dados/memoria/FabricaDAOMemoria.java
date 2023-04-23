package biblioteca.dados.memoria;

import infra.dados.dao.DAO;
import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Editora;
import biblioteca.entidades.Livro;

public class FabricaDAOMemoria extends FabricaDAO {
	
	private static final DAOLivros daoLivros = new DAOLivros();
	private static final DAOEditoras daoEditoras = new DAOEditoras();
	public DAO<Livro> getDAOLivros() {
		return daoLivros;
	}
	public DAO<Editora> getDAOEditoras() {
		return daoEditoras;
	}
}
