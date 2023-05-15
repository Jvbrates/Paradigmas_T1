package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Emprestimo;
import biblioteca.entidades.Multa;
import infra.console.util.Util;
import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import infra.negocios.Registros;

import java.util.Collection;

import static java.lang.Math.abs;

public class Multas extends Registros<Multa> {
    Emprestimos emprestimos = new Emprestimos();

    public Multas() {

        Armazenamento.setAtual(TipoArmazenamento.BANCO);
        FabricaDAO f = FabricaDAO.getFabricaDAO();
        setDao(f.getDAOMultas());
        setRotulo("Multas");
    }

    private void  create(Emprestimo emprestimo){
        long days_diff = Util.diffDays(emprestimo.getData_devolucao(), Util.getCurrent_date());
        if(days_diff < 0){
            Multa m = new Multa();
            m.setId_user(emprestimo.getId_user());
            m.setId_emprestimo(emprestimo.getId());

            inserir(m);
        }
    }

    public void UpdateValue( Multa multa){
        //Não nulo
        if(multa.getId_emprestimo() != 0){
            Emprestimo e = new Emprestimo();
            e.setId(multa.getId_emprestimo());
            try {
                e = emprestimos.buscar(e).iterator().next();
                long days_diff = Util.diffDays(e.getData_devolucao(), Util.getCurrent_date());
                multa.setValor(abs((int)days_diff));

                alterar(multa);

            } catch (IllegalAccessException ignored) {}
        }

    }

    public void Update(){

        //Cria Multas
        Collection<Emprestimo> emprestimos_collection =  emprestimos.buscarTodos();
        emprestimos_collection.forEach(this::create);

        // Atualiza valores
        buscarTodos().forEach(this::UpdateValue);
    }
}
