package biblioteca.cliente.console.formularios.inclusao;

import biblioteca.cliente.console.formularios.visualizacao.FVUsuario;
import biblioteca.entidades.*;
import biblioteca.negocio.Usuarios;
import infra.console.formularios.cadastro.FInclusao;
import infra.console.formularios.cadastro.campos.CampoInteiroMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMultiValorado;
import infra.console.util.Util;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

import java.util.ArrayList;
import java.util.Collection;

import biblioteca.negocio.Editoras;
import biblioteca.negocio.Emprestimos;

public class FIEmprestimo extends FInclusao<Emprestimo> {

    private final FVUsuario fuser = new FVUsuario(new Usuarios());
    public static final String ID_Exemplar = "Id do exemplar";
    public static final String Id_usuario = "Id do usuário";


    public FIEmprestimo(Registros<Emprestimo> registros) {
        super(registros);
        setRegistro(new Emprestimo());
        adicionarCampo(new CampoInteiroMonoValorado(ID_Exemplar, 0, 100000));
    }


    @Override
    protected void vincular() {
        Emprestimo l = getRegistro();
        l.setId_exemplar(getValorInteiro(ID_Exemplar));

        do {
            fuser.mostrar();

        }while (fuser.getResultBusca().size() == 0);

        Usuario u = fuser.getResultBusca().iterator().next();

        l.setId_user(u.getId());


        int days = u.getTipo_User() == tipoUsuario.professor?15:7;
        l.setData_devolucao(Util.PlusDays(Util.getCurrent_date(),days));

        setRegistro(l);
    }

    @Override
    public void submeter() {
        if (modoAlteracao()) {
            Emprestimos livros = new Emprestimos();
            try {
                livros.alterar(getRegistro());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Emprestimos livros = new Emprestimos();
            System.out.println("Chamando Inserir");
            livros.inserir(getRegistro());
        }
    }
}
