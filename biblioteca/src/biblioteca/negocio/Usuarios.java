package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Usuario;
import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import infra.negocios.Registros;

public class Usuarios extends Registros<Usuario> {

    public Usuarios(){
        Armazenamento.setAtual(TipoArmazenamento.BANCO);
        FabricaDAO f = FabricaDAO.getFabricaDAO();
        setDao(f.getDAOUsuarios());
        setRotulo("Usuário");

    }
}
