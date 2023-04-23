package biblioteca.dados.memoria;

import infra.dados.dao.memoria.DAOMemoria;
import biblioteca.entidades.Livro;

public class DAOLivros extends DAOMemoria<Livro>{
	@Override
	protected void preencher(Livro destino, Livro origem) {
		destino.setIsbn(origem.getIsbn());
		destino.setEditora(origem.getEditora());
		destino.setAutores(origem.getAutores());
		destino.setTitulo(origem.getTitulo());
	}
}
