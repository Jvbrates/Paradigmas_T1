package biblioteca.cliente.console.formularios.visualizacao;

import biblioteca.entidades.Reserva;
import biblioteca.entidades.Usuario;
import biblioteca.negocio.Usuarios;
import infra.console.formularios.FVisualizacao;
import infra.console.util.Util;
import infra.negocios.Registros;

public class FVReserva extends FVisualizacao<Reserva> {

    private final FVUsuario fuser = new FVUsuario(new Usuarios());

    public FVReserva(Registros<Reserva> registros) {
        super(registros);
    }

    @Override
    protected void ler() {
        int id_exempl = Util.lerInteiro("ID exemplar: ", 0, 13000);


        System.out.println("__________________________________");
        try {
            Reserva busca = new Reserva();
            busca.setId_exemplar(id_exempl);

            do {
                fuser.mostrar();

            }while (fuser.getResultBusca().size() == 0);

            Usuario u = fuser.getResultBusca().iterator().next();

            busca.setId_user(u.getId());

            setRegistroBusca(busca);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
