package biblioteca.cliente.console.formularios.inclusao;

import biblioteca.cliente.console.formularios.visualizacao.FVUsuario;
import biblioteca.entidades.Reserva;
import biblioteca.entidades.Usuario;
import biblioteca.entidades.tipoUsuario;
import biblioteca.negocio.Reservas;
import biblioteca.negocio.Usuarios;
import infra.console.formularios.cadastro.FInclusao;
import infra.console.formularios.cadastro.campos.CampoInteiroMonoValorado;
import infra.console.util.Util;
import infra.negocios.Registros;

public class FIReserva extends FInclusao<Reserva> {

    private final FVUsuario fuser = new FVUsuario(new Usuarios());
    public static final String ID_Exemplar = "Id do exemplar";


    public FIReserva(Registros<Reserva> registros) {
        super(registros);
        setRegistro(new Reserva());
        adicionarCampo(new CampoInteiroMonoValorado(ID_Exemplar, 0, 100000));
    }


    @Override
    protected void vincular() {
        Reserva l = getRegistro();
        l.setId_exemplar(getValorInteiro(ID_Exemplar));

        do {
            fuser.mostrar();

        }while (fuser.getResultBusca().size() == 0);

        Usuario u = fuser.getResultBusca().iterator().next();

        l.setId_user(u.getId());

        setRegistro(l);
    }

    @Override
    public void submeter() {
        if (modoAlteracao()) {
            Reservas livros = new Reservas();
            try {
                livros.alterar(getRegistro());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Reservas livros = new Reservas();
            System.out.println("Chamando Inserir");
            livros.inserir(getRegistro());
        }
    }
}
