package biblioteca.negocio;

import infra.negocios.Registros;
import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Editora;

public class Editoras extends Registros<Editora> {
	public Editoras() {
		FabricaDAO f = FabricaDAO.getFabricaDAO();
		setDao(f.getDAOEditoras());
		setRotulo("Editoras");
	}
}
