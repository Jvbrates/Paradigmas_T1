package biblioteca.cliente.console.menus;

import infra.console.formularios.cadastro.FListagem;
import infra.console.menus.Menu;
import infra.console.menus.MenuCadastro;
import biblioteca.cliente.console.formularios.alteracao.FAEditora;
import biblioteca.cliente.console.formularios.alteracao.FALivro;
import biblioteca.cliente.console.formularios.exclusao.FEEditora;
import biblioteca.cliente.console.formularios.exclusao.FELivro;
import biblioteca.cliente.console.formularios.inclusao.FIEditora;
import biblioteca.cliente.console.formularios.inclusao.FILivro;
import biblioteca.cliente.console.formularios.visualizacao.FVEditora;
import biblioteca.cliente.console.formularios.visualizacao.FVLivro;
import biblioteca.entidades.Editora;
import biblioteca.entidades.Livro;
import biblioteca.negocio.Editoras;
import biblioteca.negocio.Livros;

public class MenuPrincipal extends Menu {
	public MenuPrincipal(String titulo) {
		super(titulo);
		adicionarOpcao("Cadastrar Livros");
		adicionarOpcao("Cadastrar Editoras");
		adicionarOpcao("Sair");
	}

	@Override
	public void executar(int opcao) {
		switch (opcao) {
		case 1:
			while (true) {
				Livros e = new Livros();
				MenuCadastro<Livro> m1 = new MenuCadastro<Livro>();
				m1.setTitulo("Cadastro de Livros");
				m1.adicionarForm(1, new FILivro(e));
				m1.adicionarForm(2, new FALivro(e));
				m1.adicionarForm(3, new FELivro(e));
				m1.adicionarForm(4, new FVLivro(e));
				m1.adicionarForm(5, new FListagem<Livro>(e));
				opcao = m1.mostrar();
				if (opcao == m1.getOpcaoSair())
					break;
				m1.executar(opcao);
			}
			break;
		case 2:
			while (true) {
				Editoras e = new Editoras();
				MenuCadastro<Editora> m2 = new MenuCadastro<Editora>();
				m2.setTitulo("Cadastro de Editoras");
				m2.adicionarForm(1, new FIEditora(e));
				m2.adicionarForm(2, new FAEditora(e));
				m2.adicionarForm(3, new FEEditora(e));
				m2.adicionarForm(4, new FVEditora(e));
				m2.adicionarForm(5, new FListagem<Editora>(e));
				opcao = m2.mostrar();
				if (opcao == m2.getOpcaoSair())
					break;
				m2.executar(opcao);
			}
			break;
		default:
			break;
		}
	}
}
