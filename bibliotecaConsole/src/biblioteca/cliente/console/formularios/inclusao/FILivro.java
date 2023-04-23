package biblioteca.cliente.console.formularios.inclusao;

import infra.console.formularios.cadastro.FInclusao;
import infra.console.formularios.cadastro.campos.CampoMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMultiValorado;
import infra.console.util.Util;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

import java.util.ArrayList;

import biblioteca.entidades.Autor;
import biblioteca.entidades.Editora;
import biblioteca.entidades.Livro;
import biblioteca.negocio.Editoras;
import biblioteca.negocio.Livros;

public class FILivro extends FInclusao<Livro> {
	public static final String TITULO = "Titulo";
	public static final String ISBN = "ISBN";
	public static final String EDITORA = "Editora";
	public static final String AUTOR = "Autores";

	public FILivro(Registros<Livro> registros) {
		super(registros);
		setRegistro(new Livro());
		adicionarCampo(new CampoMonoValorado(ISBN, 10, 13));
		adicionarCampo(new CampoMonoValorado(TITULO, 1, 60));
		adicionarCampo(new CampoMultiValorado(AUTOR, 1, 60, 5));
		adicionarCampo(new CampoMonoValorado(EDITORA, 1, 60));
	}

	@Override
	protected void ler() {
		super.ler();
		boolean ok = true;
		do {
			if (!ok)
				getCampoMonoValorado(EDITORA).setValor(Util.lerString(EDITORA + ": ", 1, 60));
			Editoras editoras = new Editoras();
			try {
				Editora e = editoras.buscar(new Editora(getValor(EDITORA)));
				System.out.println(e);
				getRegistro().setEditora(e);
				break;
			} catch (DadoNaoEncontrado e) {
				if (Util.confirma("Deseja incluir esta nova editora?")) {
					FIEditora f = new FIEditora(new Editoras());
					f.getCampoMonoValorado(FIEditora.NOME).setValor(getValor(EDITORA));
					f.mostrar();
					getRegistro().setEditora(f.getRegistro());
					break;
				} else
					ok = false;
			}
		} while (true);
	}

	@Override
	protected void vincular() {
		Livro l = getRegistro();
		if (modoAlteracao()) {
			if (!getValor(TITULO).isEmpty())
				l.setTitulo(getValor(TITULO));
			int i = 0;
			ArrayList<Autor> temp = new ArrayList<Autor>();
			for (String nome : getValores(AUTOR)) {
				if (!nome.isEmpty())
					temp.add(new Autor(nome));
				else {
					try {
						temp.add(l.getAutores().get(i));
					} catch (IndexOutOfBoundsException e) {
						
					}
				}
				i++;
			}
			l.getAutores().clear();
			l.getAutores().addAll(temp);
		} else {
			l.setIsbn(getValor(ISBN));
			l.setTitulo(getValor(TITULO));
			ArrayList<String> nomes = getValores(AUTOR);
			for (String nome : nomes) {
				l.adicionarAutor(new Autor(nome));
			}
		}
	}

	@Override
	public void submeter() {
		if (modoAlteracao()) {
			Livros livros = new Livros();
			try {
				livros.alterar(getRegistro());
			} catch (DadoNaoEncontrado e) {
				System.out.println("Editora nao encontrada");
			}
		} else {
			Livros livros = new Livros();
			livros.inserir(getRegistro());
		}
	}
}
