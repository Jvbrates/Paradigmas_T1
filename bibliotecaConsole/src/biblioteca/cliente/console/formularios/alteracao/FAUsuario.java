package biblioteca.cliente.console.formularios.alteracao;

import biblioteca.cliente.console.formularios.inclusao.FIUsuario;
import biblioteca.entidades.Usuario;
import infra.console.formularios.cadastro.FAlteracao;
import infra.console.util.Util;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;

public class FAUsuario extends FAlteracao<Usuario> {
    public FAUsuario(Registros<Usuario> registros) {
        super(registros);
    }

    @Override
    protected void ler() {
        int id_user = Util.lerInteiro("ID: ", 0, 9999999);
        try {
            Usuario user = new Usuario();
            user.setId(id_user);
            setRegistroBusca(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void submeter() {
        try {
            Usuario e = buscar().iterator().next();
            System.out.println(e.getNome());
            FIUsuario fi = new FIUsuario(getRegistros());
            fi.setRegistro(e);
            fi.setTitulo("Alteracao de Usuarios");
            fi.setModo("A");
            System.out.println("Clique ENTER para manter o valor original");
            System.out.println("Digite um novo valor para trocar o valor original");
            fi.getCampoInteiroMonoValorado(FIUsuario.ID).setValor((int)e.getId());
            fi.mostrar();
        } catch (DadoNaoEncontrado e) {
            System.out.println("Registro nao encontrado.");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

