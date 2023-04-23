package biblioteca.cliente.console.formularios.visualizacao;

import infra.console.formularios.FVisualizacao;
import infra.console.util.Util;
import infra.negocios.Registros;
import biblioteca.entidades.Livro;

public class FVLivro extends FVisualizacao<Livro> {

	public FVLivro(Registros<Livro> registros) {
		super(registros);
	}

	@Override
	protected void ler() {
		String isbn = Util.lerString("ISBN: ", 10, 13);
		setRegistroBusca(new Livro(isbn));
	}
}
