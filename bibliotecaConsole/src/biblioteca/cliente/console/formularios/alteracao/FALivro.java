package biblioteca.cliente.console.formularios.alteracao;

import infra.console.formularios.cadastro.FAlteracao;
import infra.console.util.Util;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;
import biblioteca.cliente.console.formularios.inclusao.FILivro;
import biblioteca.entidades.Livro;

public class FALivro extends FAlteracao<Livro> {
	public FALivro(Registros<Livro> registros) {
		super(registros);
	}

	@Override
	protected void ler() {
		String isbn = Util.lerString("ISBN: ", 10, 13);
		try {
			setRegistroBusca(new Livro(isbn));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void submeter() {
		try {
			Livro e = buscar().iterator().next();
			System.out.println(e);
			FILivro fi = new FILivro(getRegistros());
			fi.setRegistro(e);
			fi.setTitulo("Alteracao de Livros");
			fi.setModo("A");
			System.out.println("Clique ENTER para manter o valor original");
			System.out.println("Digite um novo valor para trocar o valor original");
			fi.getCampoMonoValorado(FILivro.ISBN).setValor(e.getIsbn());
			fi.mostrar();
		} catch (DadoNaoEncontrado e) {
			System.out.println("Registro nao encontrado.");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
