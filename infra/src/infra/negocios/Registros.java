package infra.negocios;

import infra.dados.dao.DAO;
import infra.entidades.Registro;

import java.util.Collection;

public class Registros<T extends Registro> {
	protected String rotulo;
	protected DAO<T> dao;
	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public DAO<T> getDao() {
		return dao;
	}

	public void setDao(DAO<T> dao) {
		this.dao = dao;
	}

	public void inserir(T t) {
		if (t == null)
			throw new IllegalArgumentException("Nao pode ser inserido um objeto nulo (NULL)");
		dao.adicionar(t);
	}

	public void alterar(T t) throws DadoNaoEncontrado {
		if (t == null)
			throw new IllegalArgumentException("Nao pode ser alterado um objeto nulo (NULL)");
		dao.alterar(t);
	}

	public void remover(T t) throws DadoNaoEncontrado {
		if (t == null)
			throw new IllegalArgumentException("Nao pode ser removido um objeto nulo (NULL)");
		dao.remover(t);
	}
	
	public T buscar(T t) throws DadoNaoEncontrado {
		if (t == null)
			throw new IllegalArgumentException("Nao pode ser buscado um objeto nulo (NULL)");
		return dao.buscar(t);
	}

	public Collection<T> buscarTodos() {
		return dao.buscarTodos();
	}
}
