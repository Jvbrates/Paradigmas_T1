package biblioteca.cliente.console.formularios.visualizacao;

import biblioteca.entidades.Editora;
import biblioteca.negocio.Editoras;
import infra.console.formularios.FVisualizacao;
import infra.console.util.Util;
import infra.negocios.Registros;
import biblioteca.entidades.Livro;

import java.util.Collection;

public class FVLivro extends FVisualizacao<Livro> {

	public FVLivro(Registros<Livro> registros) {
		super(registros);
	}

	@Override
	protected void ler() {
		String isbn = Util.lerStringOpt("ISBN: ", 10, 13);
		String titulo = Util.lerStringOpt("Titulo: ", 0, 200);
		int id_editora = Util.lerInteiro("Id Editora (0 para vazio): ", 0, 10);
		System.out.println("__________________________________");
		try {
			Livro busca = new Livro();
			busca.setIsbn(isbn);
			busca.setTitulo(titulo);
			if(id_editora != 0){
				Editora e = new Editora();
				e.setId(id_editora);
				busca.setEditora(e);
			}
			setRegistroBusca(busca);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
