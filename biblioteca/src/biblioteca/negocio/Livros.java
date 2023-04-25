package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Livro;
import infra.negocios.Registros;

public class Livros extends Registros<Livro>{
	public Livros(){
		FabricaDAO f = FabricaDAO.getFabricaDAO();
		setDao(f.getDAOLivros());
		setRotulo("Livros");
	}
}
