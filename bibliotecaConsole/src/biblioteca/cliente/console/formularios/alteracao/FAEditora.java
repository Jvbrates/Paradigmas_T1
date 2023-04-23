package biblioteca.cliente.console.formularios.alteracao;

import infra.console.formularios.cadastro.FAlteracao;
import infra.console.util.Util;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;
import biblioteca.cliente.console.formularios.inclusao.FIEditora;
import biblioteca.entidades.Editora;

public class FAEditora extends FAlteracao<Editora> {
	public FAEditora(Registros<Editora> registros) {
		super(registros);
	}

	@Override
	protected void ler() {
		String nome = Util.lerString("Nome: ", 1, 60);
		setRegistroBusca(new Editora(nome));
	}

	@Override
	protected void submeter() {
		try {
			Editora e = buscar();
			System.out.println(e);
			FIEditora fi = new FIEditora(getRegistros());
			fi.setRegistro(e);
			fi.setTitulo("Alteracao de Editora");
			fi.setModo("A");
			System.out.println("Clique ENTER para manter o valor original");
			System.out.println("Digite um novo valor para trocar o valor original");
			fi.getCampoMonoValorado(FIEditora.NOME).setValor(e.getNome());
			fi.mostrar();
		} catch (DadoNaoEncontrado e) {
			System.out.println("Registro nao encontrado.");
		}
	}
}
