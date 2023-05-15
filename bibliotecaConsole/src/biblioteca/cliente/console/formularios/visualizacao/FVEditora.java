package biblioteca.cliente.console.formularios.visualizacao;

import infra.console.formularios.FVisualizacao;
import infra.console.util.Util;
import infra.negocios.Registros;
import biblioteca.entidades.Editora;

public class FVEditora extends FVisualizacao<Editora> {

	public FVEditora(Registros<Editora> registros) {
		super(registros);
	}

	@Override
	protected void ler(){
		String nome = Util.lerString("Nome: ", 1, 60);
		try {
			setRegistroBusca(new Editora(nome));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
