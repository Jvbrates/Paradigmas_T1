package infra.console.formularios.cadastro;

import infra.console.util.Util;
import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

public abstract class FExclusao<T extends Registro> extends FBusca<T> {
	public FExclusao(Registros<T> registros) {
		super(registros);
		setTitulo("Exclusao de " + registros.getRotulo());
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
			if (Util.confirma(getTitulo())) {
				getRegistros().remover(t);
				System.out.println("Registro removido.");
			} else
				System.out.println("Operação cancelada - " + getTitulo());
		} catch (DadoNaoEncontrado e) {
			System.out.println("Registro nao encontrado.");
		}
	}
}
