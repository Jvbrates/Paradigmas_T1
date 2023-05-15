package biblioteca.cliente.console.formularios.exclusao;

import infra.console.formularios.cadastro.FExclusao;
import infra.console.util.Util;
import infra.negocios.Registros;
import biblioteca.entidades.Livro;

public class FELivro extends FExclusao<Livro> {
	public FELivro(Registros<Livro> registros) {
		super(registros);
	}

	@Override
	public void ler() throws Exception{
		String isbn = Util.lerString("ISBN: ", 10, 13);
		setRegistroBusca(new Livro(isbn));
	}
}
