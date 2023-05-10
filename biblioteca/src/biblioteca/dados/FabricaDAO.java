package biblioteca.dados;

import biblioteca.dados.database.FabricaDAOdatabase;
import biblioteca.dados.memoria.FabricaDAOMemoria;
import biblioteca.entidades.Editora;
import biblioteca.entidades.Livro;
import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import infra.dados.dao.DAO;


public abstract class FabricaDAO {
	public static FabricaDAO getFabricaDAO() {		
		if (TipoArmazenamento.MEMORIA.equals(Armazenamento.getAtual()))
			return new FabricaDAOMemoria();
		else if (TipoArmazenamento.BANCO.equals(Armazenamento.getAtual()))
			return new FabricaDAOdatabase();
		else
			throw new IllegalArgumentException("Tipo de acesso a dados nao permitido");
	}

	public abstract DAO<Livro> getDAOLivros();
	public abstract DAO<Editora> getDAOEditoras();
}
