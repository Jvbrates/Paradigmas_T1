package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.Emprestimo;
import biblioteca.entidades.Multa;
import biblioteca.entidades.Reserva;
import biblioteca.entidades.Usuario;
import infra.console.util.Util;
import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import infra.negocios.Registros;

import java.util.Collection;

public class Reservas extends Registros<Reserva> {
    public Reservas() {

        Armazenamento.setAtual(TipoArmazenamento.BANCO);
        FabricaDAO f = FabricaDAO.getFabricaDAO();
        setDao(f.getDAOReservas());
        setRotulo("Reservas");
    }


    //Reservar um livro
    @Override
    public void inserir(Reserva reserva) {

        /*Requisitos
        * 0. Exemplar estar em empréstimo
        * 1. Caso esteja em emprestimo não ser do próprio usuário
        * 2. Exemplar não esteja reservado
        * 3. Usuário Não possua Multas*/

        Emprestimos emprestimos = new Emprestimos();
        Emprestimo emprestimo_query = new Emprestimo();
        emprestimo_query.setId_exemplar(reserva.getId_exemplar());

        Usuarios usuarios = new Usuarios();
        Usuario usuario = new Usuario();

        Multas multas = new Multas();
        Multa multa = new Multa();

        Reserva reserva_query = new Reserva();
        reserva_query.setId_exemplar(reserva.getId_exemplar());
        try {

            //0.
            Collection<Emprestimo> collection_emprest = emprestimos.buscar(emprestimo_query);
            if(collection_emprest.size() == 0){
                System.out.println("Não há porque fazer reserva de um livro disponível");
                return;
            }


            //1.
            if(collection_emprest.iterator().next().getId_user() == reserva.getId_user()){
                System.out.println("Não há porque fazer reserva deste livro que você já tem, renove-o");
                return;
            }

            //2.
                Collection<Reserva> collection_reservaq = super.buscar(reserva_query);

                if(collection_reservaq.size() != 0) {
                    System.out.println("Você não pode reservar um exemplar que já está reservado");
                }

            //3.
            multa.setId_user(reserva.getId_user());
            Collection<Multa> collection_m = multas.buscar(multa);

            if(collection_m.size() != 0){
                System.out.println("Usuarios com multa não podem reservar livros");
                return;
            }

            //Data da reserva
            reserva.setData_retirada(
                    Util.PlusDays(emprestimo_query.getData_devolucao(), 1)
            );

            super.inserir(reserva);
        } catch (IllegalAccessException ignore){};
    }

    //Cancelar Reserva com base em exemplar
    @Override
    public void remover(Reserva reserva) {
        try {
        Reserva toremove = super.buscar(reserva).iterator().next();
        super.remover(toremove);
        } catch (IllegalAccessException ignored){};
    }

    private void verifica_and_delete(Reserva r){

        //Compilador que optimize
        long days_diff = Util.diffDays(r.getData_retirada(), Util.getCurrent_date());

        if(days_diff < 0){
            //Já tem o id
            super.remover(r);
        }
    }
    public void atualizar(){

        Collection<Reserva> reservas = buscarTodos();
        reservas.forEach(this::verifica_and_delete);
    }
}
