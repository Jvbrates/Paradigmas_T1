package infra.console.formularios.cadastro;

import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

public abstract class FBusca<T extends Registro> extends FCadastro<T> {
	public FBusca(Registros<T> registros) {
		super(registros);
	}

	private String campoBusca;
	private T registroBusca;

	public T getRegistroBusca() {
		return registroBusca;
	}

	public void setRegistroBusca(T registro) {
		this.registroBusca = registro;
	}

	public String getCampoBusca() {
		return campoBusca;
	}

	public void setCampoBusca(String campoBusca) {
		this.campoBusca = campoBusca;
	}

	protected T buscar() throws DadoNaoEncontrado {
		Registros<T> registros = getRegistros();
		T r = registros.buscar(getRegistroBusca());
		return r;
	}

	protected abstract void ler();

	protected abstract void submeter();
}
