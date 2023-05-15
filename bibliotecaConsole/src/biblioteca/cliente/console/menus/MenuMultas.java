package biblioteca.cliente.console.menus;

import biblioteca.cliente.console.formularios.exclusao.FEMulta;
import biblioteca.cliente.console.formularios.visualizacao.FVMulta;
import biblioteca.negocio.Multas;
import infra.console.menus.Menu;


public class MenuMultas extends Menu {

    public MenuMultas(String titulo) throws Exception{
        super(titulo);

        adicionarOpcao("Pagar Multa");
        adicionarOpcao("Buscar");
        adicionarOpcao("Listar todas as Multas");
        adicionarOpcao("Sair");
    }
    @Override
    public void executar(int opcao) throws Exception {
        switch (opcao) {
            case 1 -> {
                Multas e = new Multas();
                FEMulta fempr = new FEMulta(e);
                fempr.mostrar();
            }

            case 2-> {
                Multas e = new Multas();
                FVMulta fempr = new FVMulta(e);
                fempr.mostrar();
            }

            case 3 -> {
                Multas e = new Multas();
                e.buscarTodos();
            }
        }
    }
}
