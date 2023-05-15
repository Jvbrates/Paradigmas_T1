package biblioteca.cliente.console.formularios.exclusao;

import biblioteca.entidades.Usuario;
import infra.console.formularios.cadastro.FExclusao;
import infra.console.util.Util;
import infra.negocios.Registros;

public class FEUsuario extends FExclusao<Usuario> {
	public FEUsuario(Registros<Usuario> registros) {
		super(registros);
	}

	@Override
	public void ler() throws Exception{
		int id_user = Util.lerInteiro("Id user: ", 0, 99999);
		Usuario user = new Usuario();
		user.setId((long)id_user);
		setRegistroBusca(user);
	}
}
