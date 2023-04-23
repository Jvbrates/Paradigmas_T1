package infra.dados.dao;

import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;

import java.util.Collection;

public interface DAO<T extends Registro> {
	public void adicionar(T t);
	public void remover(T t) throws DadoNaoEncontrado;
	public void alterar(T e) throws DadoNaoEncontrado;
	public T buscar(T elemento) throws DadoNaoEncontrado;
	public Collection<T> buscarTodos();
}
