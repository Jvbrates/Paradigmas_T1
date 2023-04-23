package infra.console.formularios;

import infra.console.formularios.cadastro.FBusca;
import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

public abstract class FVisualizacao<T extends Registro> extends FBusca<T> {

	public FVisualizacao(Registros<T> registros) {
		super(registros);
		setTitulo("Visualizacao de " + getRegistros().getRotulo());
	}

	@Override
	public void mostrar() {
		super.mostrar();
		ler();
		submeter();
	}

	protected void submeter() {
		try {
			T t = buscar();
			System.out.println(t);
		} catch (DadoNaoEncontrado e) {
			System.out.println("Registro nao encontrado.");
		}
	}
	protected abstract void ler();
}
