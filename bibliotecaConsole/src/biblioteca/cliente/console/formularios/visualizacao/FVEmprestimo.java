package biblioteca.cliente.console.formularios.visualizacao;

import biblioteca.entidades.Editora;
import biblioteca.entidades.Usuario;
import biblioteca.negocio.Editoras;
import biblioteca.negocio.Usuarios;
import infra.console.formularios.FVisualizacao;
import infra.console.util.Util;
import infra.negocios.Registros;
import biblioteca.entidades.Emprestimo;

import java.util.Collection;

public class FVEmprestimo extends FVisualizacao<Emprestimo> {

    private final FVUsuario fuser = new FVUsuario(new Usuarios());

    public FVEmprestimo(Registros<Emprestimo> registros) {
        super(registros);
    }

    @Override
    protected void ler() {
        int id_exempl = Util.lerInteiro("ID exemplar: ", 0, 13000);


        System.out.println("__________________________________");
        try {
            Emprestimo busca = new Emprestimo();
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
