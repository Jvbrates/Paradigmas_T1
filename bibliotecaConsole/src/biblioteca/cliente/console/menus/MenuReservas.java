package biblioteca.cliente.console.menus;

import biblioteca.cliente.console.formularios.exclusao.FEReserva;
import biblioteca.cliente.console.formularios.inclusao.FIReserva;
import biblioteca.cliente.console.formularios.visualizacao.FVReserva;
import biblioteca.entidades.Reserva;
import biblioteca.negocio.Reservas;
import infra.console.menus.Menu;


public class MenuReservas extends Menu {

    public MenuReservas(String titulo) throws Exception{
        super(titulo);

        adicionarOpcao("Nova Reserva");
        adicionarOpcao("Cancelar reserva");
        adicionarOpcao("Buscar");
        adicionarOpcao("Listar todas as reservas");
        adicionarOpcao("Sair");
    }
    @Override
    public void executar(int opcao) throws Exception {
        switch (opcao) {
            case 1 -> {
                Reservas e = new Reservas();
                FIReserva fempr = new FIReserva(e);
                fempr.mostrar();

            }

            case 2 -> {
                Reservas e = new Reservas();
                FEReserva fempr = new FEReserva(e);
                fempr.mostrar();
            }

            case 3-> {
                Reservas e = new Reservas();
                FVReserva fempr = new FVReserva(e);
                fempr.mostrar();
            }

            case 4 -> {
                Reservas e = new Reservas();
                e.buscarTodos();
            }
        }
    }
}
