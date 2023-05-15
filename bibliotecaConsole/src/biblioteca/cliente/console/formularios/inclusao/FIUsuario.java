package biblioteca.cliente.console.formularios.inclusao;

import biblioteca.entidades.Usuario;
import biblioteca.entidades.tipoUsuario;
import biblioteca.negocio.Livros;
import biblioteca.negocio.Usuarios;
import infra.console.formularios.cadastro.FInclusao;
import infra.console.formularios.cadastro.campos.CampoInteiroMonoValorado;
import infra.console.formularios.cadastro.campos.CampoMonoValorado;
import infra.negocios.Registros;

import java.util.Objects;

public class FIUsuario extends FInclusao<Usuario> {


    public static final String NOME = "Nome";
    public static final String USERNAME = "Nome de Usuário";
    public static final String TIPO = "Tipo (0 - aluno | 1 - professor)";

    public static final String ID = "ID usuário";
    public FIUsuario(Registros<Usuario> registros) {
        super(registros);
        setRegistro(new Usuario());
        adicionarCampo(new CampoMonoValorado(NOME, 5, 100));
        adicionarCampo(new CampoMonoValorado(USERNAME, 5, 100));
        adicionarCampo(new CampoInteiroMonoValorado(TIPO, 0, 1));
        adicionarCampo(new CampoInteiroMonoValorado(ID, 0, 999999999));
    }

    @Override
    protected void vincular() {
        if(!modoAlteracao()) {
            Usuario u = getRegistro();
            u.setNome(getValor(NOME));
            u.setUsername(getValor(USERNAME));
            u.setTipo_user(tipoUsuario.values()[getValorInteiro(TIPO)]);
        } else {
            Usuario u = getRegistro();
            u.setNome(getValor(NOME).isEmpty()?u.getNome():getValor(NOME));
            u.setUsername(getValor(USERNAME).isEmpty()?u.getUsername():getValor(USERNAME));
            u.setTipo_user(tipoUsuario.values()[getValorInteiro(TIPO)]);
        }


    }

    @Override
    public void submeter() {
        if (modoAlteracao()) {
            Usuarios livros = new Usuarios();
            try {
                livros.alterar(getRegistro());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Usuarios livros = new Usuarios();
            System.out.println("Chamando Inserir");
            livros.inserir(getRegistro());
        }
    }

    @Override
    public void ler(){
        removeCampo(ID);

        super.ler();
    }
}
