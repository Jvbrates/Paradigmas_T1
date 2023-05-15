package biblioteca.cliente.console.formularios.visualizacao;

import biblioteca.entidades.Editora;
import biblioteca.entidades.Usuario;
import infra.console.formularios.FVisualizacao;
import infra.console.util.Util;
import infra.negocios.Registros;

public class FVUsuario extends FVisualizacao<Usuario> {

	public FVUsuario(Registros<Usuario> registros) {
		super(registros);
	}

	@Override
	protected void ler() {
		String nome = Util.lerStringOpt("NOME", 0, 100);
		String username = Util.lerStringOpt("Username: ", 0, 200);
		System.out.println("__________________________________");
		try {
			Usuario busca = new Usuario();
			busca.setNome(nome);
			busca.setUsername(username);

			setRegistroBusca(busca);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
