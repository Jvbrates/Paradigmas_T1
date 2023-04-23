package biblioteca.cliente.console;

import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import biblioteca.cliente.console.menus.MenuPrincipal;

public class BibliotecaConsole {
	public static void main(String[] args) {
		Armazenamento.setAtual(TipoArmazenamento.MEMORIA);
		MenuPrincipal m = new MenuPrincipal("Menu Principal");
		do {
			int opcao = m.mostrar();
			if (opcao == m.getOpcaoSair())
				break;
			m.executar(opcao);
		} while (true);
	}
}
