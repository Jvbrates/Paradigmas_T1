package biblioteca.cliente.console.formularios.exclusao;

import biblioteca.entidades.Multa;
import biblioteca.entidades.Multa;
import infra.console.formularios.cadastro.FExclusao;
import infra.console.util.Util;
import infra.negocios.Registros;

public class FEMulta extends FExclusao<Multa> {
    public FEMulta(Registros<Multa> registros) {
        super(registros);
    }

    @Override
    public void ler() throws Exception{
        int id = Util.lerInteiro("ID Multa: ", 0, 1000003);
        Multa e = new Multa();
        e.setId(id);
        setRegistroBusca(e);
    }
}
