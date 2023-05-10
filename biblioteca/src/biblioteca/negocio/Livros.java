package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Livro;
import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import infra.negocios.Registros;

public class Livros extends Registros<Livro>{
	public Livros(){
		Armazenamento.setAtual(TipoArmazenamento.BANCO);
		FabricaDAO f = FabricaDAO.getFabricaDAO();
		setDao(f.getDAOLivros());
		setRotulo("Livros");
	}
}
