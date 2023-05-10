package biblioteca.dados.memoria;

import biblioteca.entidades.Autor;
import infra.dados.dao.memoria.DAOMemoria;

public class DAOAutor extends DAOMemoria<Autor> {


	@Override
	protected void preencher(Autor destino, Autor origem) {
		destino.setId( origem.getId());
		destino.setNome(origem.getNome());
		
	}

}
