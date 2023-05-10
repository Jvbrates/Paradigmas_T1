package infra.console.formularios.cadastro;

import java.util.Collection;

import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

public abstract class FBusca<T extends Registro> extends FCadastro<T> {
	public FBusca(Registros<T> registros) {
		super(registros);
	}

	private String campoBusca;
	private T registroBusca;

	public T getRegistroBusca() throws Exception{
		return registroBusca;
	}

	public void setRegistroBusca(T registro) throws Exception {
		this.registroBusca = registro;
	}

	public String getCampoBusca() throws Exception {
		return campoBusca;
	}

	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}

	protected Collection<T> buscar() throws DadoNaoEncontrado, Exception {
		Registros<T> registros = getRegistros();
		Collection<T> r = registros.buscar(getRegistroBusca());
		return r;
	}

	protected abstract void ler() throws Exception;

	protected abstract void submeter() throws Exception;
}
