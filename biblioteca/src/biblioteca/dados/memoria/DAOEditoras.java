package biblioteca.dados.memoria;

import infra.dados.dao.memoria.DAOMemoria;
import biblioteca.entidades.Editora;

public class DAOEditoras extends DAOMemoria<Editora>{
	protected void preencher(Editora destino, Editora origem) {
		destino.setNome(origem.getNome());
		destino.setCidade(origem.getCidade());
		destino.setPais(origem.getPais());
	}
}
