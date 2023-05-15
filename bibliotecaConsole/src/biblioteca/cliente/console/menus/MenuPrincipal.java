package biblioteca.cliente.console.menus;
import biblioteca.entidades.Exemplar;
import biblioteca.entidades.Usuario;
import biblioteca.negocio.Exemplares;
import biblioteca.negocio.Usuarios;

import infra.console.menus.Menu;
import infra.console.menus.MenuCadastro;

import infra.console.formularios.cadastro.FListagem;
import biblioteca.cliente.console.formularios.alteracao.*;
import biblioteca.cliente.console.formularios.exclusao.*;
import biblioteca.cliente.console.formularios.inclusao.*;
import biblioteca.cliente.console.formularios.visualizacao.*;

import biblioteca.entidades.Editora;
import biblioteca.entidades.Livro;
import biblioteca.negocio.Editoras;
import biblioteca.negocio.Livros;

public class MenuPrincipal extends Menu {
	public MenuPrincipal(String titulo) throws Exception{
		super(titulo);
		adicionarOpcao("Menu Livros");
		adicionarOpcao("Menu Editoras");
		adicionarOpcao("Menu Usuarios");
		adicionarOpcao("Menu Exemplares");
		adicionarOpcao("Menu Emprestimos");
		adicionarOpcao("Menu Reservas");
		adicionarOpcao("Menu Multas");
		adicionarOpcao("Sair");
	}

	@Override
	public void executar(int opcao) throws Exception{
		switch (opcao) {
		case 1:
			while (true) {
				Livros e = new Livros();
				Exemplares ex = new Exemplares();
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
		case 3:
			while (true) {
				Usuarios e = new Usuarios();
				MenuCadastro<Usuario> m3 = new MenuCadastro<>();
				m3.setTitulo("Cadastro de Usuários");
				m3.adicionarForm(1, new FIUsuario(e));
				m3.adicionarForm(2, new FAUsuario(e));
				m3.adicionarForm(3, new FEUsuario(e));
				m3.adicionarForm(4, new FVUsuario(e));
				m3.adicionarForm(5, new FListagem<>(e));
				opcao = m3.mostrar();
				if (opcao == m3.getOpcaoSair())
					break;
				m3.executar(opcao);
			}
			break;
		case 4:
			while (true) {
				Exemplares e = new Exemplares();
				MenuCadastro<Exemplar> m3 = new MenuCadastro<>();
				m3.setTitulo("Cadastro de exemplares");
				m3.adicionarForm(1, new FIExemplar(e));
				//m3.adicionarForm(2, new FAUsuario(e));
				//m3.adicionarForm(3, new FEUsuario(e));
				//m3.adicionarForm(4, new FVUsuario(e));
				//m3.adicionarForm(5, new FListagem<Usuario>(e));
				opcao = m3.mostrar();
				if (opcao == m3.getOpcaoSair())
					break;
				m3.executar(opcao);
			}
			break;
			case 5: {
				MenuEmprestimos mepr = new MenuEmprestimos("Menu Emprestimos");

				opcao = mepr.mostrar();
				if (opcao == mepr.getOpcaoSair())
					break;
				mepr.executar(opcao);
			}
			break;
		default:
			break;
		}
	}
}
