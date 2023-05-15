package biblioteca.cliente.console.formularios.inclusao;

import infra.console.formularios.cadastro.FInclusao;
import infra.console.formularios.cadastro.campos.CampoMonoValorado;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;
import biblioteca.entidades.Editora;
import biblioteca.negocio.Editoras;

public class FIEditora extends FInclusao<Editora> {
	public static final String NOME = "Nome";
	public static final String CIDADE = "Cidade";
	public static final String PAIS = "Pais";

	public FIEditora(Registros<Editora> registros) {
		super(registros);
		adicionarCampo(new CampoMonoValorado(NOME, 1, 50));
		adicionarCampo(new CampoMonoValorado(CIDADE, 1, 50));
		adicionarCampo(new CampoMonoValorado(PAIS, 1, 50));
		setRegistro(new Editora());
	}

	@Override
	protected void vincular() {
		Editora e = getRegistro();
		if (modoAlteracao()) {
			if (!getValor(CIDADE).isEmpty())
				e.setCidade(getValor(CIDADE));
			if (!getValor(PAIS).isEmpty())
				e.setPais(getValor(PAIS));
		} else {
			e.setNome(getValor(NOME));
			e.setCidade(getValor(CIDADE));
			e.setPais(getValor(PAIS));
		}
	}

	@Override
	public void submeter() {
		if (modoAlteracao()) {
			Editoras editoras = new Editoras();
			try {
				editoras.alterar(getRegistro());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Editoras editoras = new Editoras();
			try {
				editoras.inserir(getRegistro());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
