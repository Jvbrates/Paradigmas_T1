package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Exemplar;
import biblioteca.entidades.Livro;
import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import infra.negocios.Registros;

public class Exemplares extends Registros<Exemplar>{
    public Exemplares(){
        Armazenamento.setAtual(TipoArmazenamento.BANCO);
        FabricaDAO f = FabricaDAO.getFabricaDAO();
        setDao(f.getDAOExemplares());
        setRotulo("Exemplares");
    }
}
