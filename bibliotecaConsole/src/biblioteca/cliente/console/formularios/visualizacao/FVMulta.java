package biblioteca.cliente.console.formularios.visualizacao;

import biblioteca.entidades.Multa;
import biblioteca.entidades.Usuario;
import biblioteca.negocio.Usuarios;
import infra.console.formularios.FVisualizacao;
import infra.console.util.Util;
import infra.negocios.Registros;

public class FVMulta extends FVisualizacao<Multa> {

    private final FVUsuario fuser = new FVUsuario(new Usuarios());

    public FVMulta(Registros<Multa> registros) {
        super(registros);
    }

    @Override
    protected void ler() {


        System.out.println("__________________________________");
        try {
            Multa busca = new Multa();

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
