package biblioteca.cliente.console.formularios.exclusao;

import infra.console.formularios.cadastro.FExclusao;
import infra.console.util.Util;
import infra.negocios.Registros;
import biblioteca.entidades.Editora;

public class FEEditora extends FExclusao<Editora> {
	public FEEditora(Registros<Editora> registros) {
		super(registros);
	}

	@Override
	public void ler() {
		String nome = Util.lerString("Nome: ", 1, 60);
		try {
			setRegistroBusca(new Editora(nome));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
