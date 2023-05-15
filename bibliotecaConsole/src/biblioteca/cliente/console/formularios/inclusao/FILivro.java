package biblioteca.cliente.console.formularios.inclusao;

import infra.console.formularios.cadastro.FInclusao;
import infra.console.formularios.cadastro.campos.CampoInteiroMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMultiValorado;
import infra.console.util.Util;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

import java.util.ArrayList;
import java.util.Collection;

import biblioteca.entidades.Autor;
import biblioteca.entidades.Editora;
import biblioteca.entidades.Livro;
import biblioteca.negocio.Editoras;
import biblioteca.negocio.Livros;

public class FILivro extends FInclusao<Livro> {
	public static final String TITULO = "Titulo";
	public static final String ISBN = "ISBN";
	public static final String EDITORA = "Editora";
	public static final String EDICAO = "EDICAO";
	public static final String ANO = "ANO";
	public static final String AUTOR = "Autores";



	public FILivro(Registros<Livro> registros) {
		super(registros);
		setRegistro(new Livro());
		adicionarCampo(new CampoMonoValorado(ISBN, 10, 13));
		adicionarCampo(new CampoMonoValorado(TITULO, 1, 60));
		adicionarCampo(new CampoMultiValorado(AUTOR, 1, 60, 5));
		adicionarCampo(new CampoMonoValorado(EDITORA, 1, 60));
		adicionarCampo(new CampoInteiroMonoValorado(ANO, 0, 5000));
		adicionarCampo(new CampoInteiroMonoValorado(EDICAO, 0, 5000));
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
				Collection<Editora> c_ed = editoras.buscar(new Editora(getValor(EDITORA)));
				Editora e = c_ed.iterator().next();
				System.out.println(e);
				getRegistro().setEditora(e);

				if (c_ed.size() == 0)
					System.out.println("Editora não encontrada");
				break;

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} while (true);
	}

	@Override
	protected void vincular() {
		Livro l = getRegistro();
		l.setAno(getValorInteiro("ANO"));
		l.setEdicao(getValorInteiro("EDICAO"));
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Livros livros = new Livros();
			System.out.println("Chamando Inserir");
			livros.inserir(getRegistro());
		}
	}
}
