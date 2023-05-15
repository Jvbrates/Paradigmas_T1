package biblioteca.cliente.console.formularios.inclusao;

import biblioteca.entidades.Autor;
import biblioteca.entidades.Editora;
import biblioteca.entidades.Exemplar;
import biblioteca.entidades.Livro;
import biblioteca.negocio.Editoras;
import biblioteca.negocio.Exemplares;
import biblioteca.negocio.Livros;
import infra.console.formularios.cadastro.FInclusao;
import infra.console.formularios.cadastro.campos.CampoInteiroMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMultiValorado;
import infra.console.util.Util;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

import java.util.ArrayList;
import java.util.Collection;

public class FIExemplar extends FInclusao<Exemplar> {
	public static final String ISBN = "ISBN do Livro";


	public FIExemplar(Registros<Exemplar> registros) {
		super(registros);
		setRegistro(new Exemplar());
		adicionarCampo(new CampoMonoValorado(ISBN, 10, 13));
	}

	@Override
	protected void vincular() {

	}

	@Override
	protected void ler() {
		super.ler();
		boolean ok = true;
		do {
			if (!ok)
				getCampoMonoValorado(ISBN).setValor(Util.lerString(ISBN + ": ", 10, 13));
			Livros livros = new Livros();
			try {
				Livro query = new Livro();
				query.setIsbn(getValor(ISBN));
				Collection<Livro> c_ed = livros.buscar(query);
				if (c_ed.size() == 0) {
					System.out.println("Editora desconhecida");
					break;
				}
				Livro e = c_ed.iterator().next();
				System.out.println(e);
				getRegistro().setId_livro(e.getId());
				break;

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} while (true);
	}

	@Override
	public void submeter() {
		new Exemplares().inserir(getRegistro());
	}

}