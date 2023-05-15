package biblioteca.dados.database;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.*;
import biblioteca.negocio.Reservas;
import infra.dados.dao.DAO;

public class FabricaDAOdatabase extends FabricaDAO {
	
	private static final DAOLivro daoLivros = new DAOLivro();
	private static final DAOEditora daoEditoras = new DAOEditora();

	private static final DAOUsuario daoUsuarios = new DAOUsuario();
	private static final DAOExemplar daoExemplares = new DAOExemplar();

	private static final DAOReserva daoReservas = new DAOReserva();
	private static final DAOEmprestimo daoEmprestimo = new DAOEmprestimo();

	private static final DAOMulta daoMulta = new DAOMulta();

	public DAO<Usuario> getDAOUsuarios(){return daoUsuarios;}
	public DAO<Livro> getDAOLivros() {
		return daoLivros;
	}
	public DAO<Editora> getDAOEditoras() {
		return daoEditoras;
	}
	
	public DAO<Exemplar> getDAOExemplares(){return daoExemplares;}

	@Override
	public DAO<Reserva> getDAOReservas() {return daoReservas;	}

	@Override
	public DAO<Emprestimo> getDAOEmprestimos(){return daoEmprestimo;}

	@Override
	public DAO<Multa> getDAOMultas(){return daoMulta;}
}
