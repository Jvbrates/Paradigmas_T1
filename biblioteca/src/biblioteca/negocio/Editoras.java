package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Editora;
import infra.negocios.Registros;

public class Editoras extends Registros<Editora> {
	public Editoras() {
		FabricaDAO f = FabricaDAO.getFabricaDAO();
		setDao(f.getDAOEditoras());
		setRotulo("Editoras");
	}
}
