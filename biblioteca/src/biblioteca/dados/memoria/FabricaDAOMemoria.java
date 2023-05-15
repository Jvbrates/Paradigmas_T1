package biblioteca.dados.memoria;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.*;
import biblioteca.negocio.Reservas;
import infra.dados.dao.DAO;

public class FabricaDAOMemoria extends FabricaDAO {
	
	private static final DAOLivros daoLivros = new DAOLivros();
	private static final DAOEditoras daoEditoras = new DAOEditoras();
	public DAO<Livro> getDAOLivros() {
		return daoLivros;
	}
	public DAO<Editora> getDAOEditoras() {
		return daoEditoras;
	}

	@Override
	public DAO<Usuario> getDAOUsuarios() {
		return null;
	}

	@Override
	public DAO<Exemplar> getDAOExemplares() {
		return null;
	}

	@Override
	public DAO<Emprestimo> getDAOEmprestimos() {
		return null;
	}

	@Override
	public DAO<Reserva> getDAOReservas() {
		return null;
	}

	@Override
	public DAO<Multa> getDAOMultas() {return null;	}
}
