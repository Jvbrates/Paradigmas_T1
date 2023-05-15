package biblioteca.cliente.console.formularios.exclusao;

import biblioteca.entidades.Reserva;
import biblioteca.entidades.Reserva;
import infra.console.formularios.cadastro.FExclusao;
import infra.console.util.Util;
import infra.negocios.Registros;

public class FEReserva extends FExclusao<Reserva> {
    public FEReserva(Registros<Reserva> registros) {
        super(registros);
    }

    @Override
    public void ler() throws Exception{
        int id = Util.lerInteiro("ID Reserva: ", 0, 1000003);
        Reserva e = new Reserva();
        e.setId(id);
        setRegistroBusca(e);
    }
}
