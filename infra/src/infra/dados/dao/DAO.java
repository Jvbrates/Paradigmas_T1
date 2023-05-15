package infra.dados.dao;

import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;

import java.util.Collection;

public interface DAO<T extends Registro> {
	public void adicionar(T t) throws IllegalArgumentException, IllegalAccessException, Exception;
	public void remover(T t) throws DadoNaoEncontrado, Exception;
	public void alterar(T e) throws DadoNaoEncontrado, IllegalArgumentException, IllegalAccessException;
	public Collection<T> buscar(T elemento) throws DadoNaoEncontrado, IllegalAccessException;
	public Collection<T> buscarTodos() throws Exception, IllegalAccessException, DadoNaoEncontrado;
}
