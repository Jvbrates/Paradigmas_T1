package biblioteca.negocio;

import infra.negocios.Registros;
import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Livro;

public class Livros extends Registros<Livro>{
	public Livros(){
		FabricaDAO f = FabricaDAO.getFabricaDAO();
		setDao(f.getDAOLivros());
		setRotulo("Livros");
	}
}
