package biblioteca.cliente.console.menus;

import biblioteca.cliente.console.formularios.exclusao.FEEmprestimo;
import biblioteca.cliente.console.formularios.inclusao.FIEmprestimo;
import biblioteca.cliente.console.formularios.inclusao.FIExemplar;
import biblioteca.cliente.console.formularios.visualizacao.FVEmprestimo;
import biblioteca.cliente.console.formularios.visualizacao.FVLivro;
import biblioteca.entidades.Emprestimo;
import biblioteca.entidades.Usuario;
import biblioteca.negocio.Emprestimos;
import biblioteca.negocio.Livros;
import infra.console.menus.Menu;
import infra.console.util.Util;

public class MenuEmprestimos extends Menu {

    public MenuEmprestimos(String titulo) throws Exception{
        super(titulo);

        adicionarOpcao("Novo Emprestimo");
        adicionarOpcao("Devolver Emprestimo");
        adicionarOpcao("Buscar (Usuario e código exemplar)");
        adicionarOpcao("Buscar por livro");
        adicionarOpcao("Renovar emprestimo");
        adicionarOpcao("Listar todos os emprestimos");
        adicionarOpcao("Sair");
    }
    @Override
    public void executar(int opcao) throws Exception {
        switch (opcao) {
            case 1 -> {
                Emprestimos e = new Emprestimos();
                FIEmprestimo fempr = new FIEmprestimo(e);
                fempr.mostrar();

            }

            case 2 -> {
                Emprestimos e = new Emprestimos();
                FEEmprestimo fempr = new FEEmprestimo(e);
                fempr.mostrar();
            }

            case 3-> {
                Emprestimos e = new Emprestimos();
                FVEmprestimo fempr = new FVEmprestimo(e);
                fempr.mostrar();
            }

            case 4-> {
                Emprestimos e = new Emprestimos();
                FVLivro l = new FVLivro(new Livros());
                l.mostrar();
                l.getResultBusca().forEach(e::buscarPorLivro);

            }

            case 5-> {
                Emprestimos e = new Emprestimos();
                int id = Util.lerInteiro("ID emprestimo", 0, 1000);
                Emprestimo emp = new Emprestimo();
                emp.setId(id);

                e.renovar(emp);
            }

            case 6 -> {
                Emprestimos e = new Emprestimos();
                e.buscarTodos();
            }
        }
    }
}
