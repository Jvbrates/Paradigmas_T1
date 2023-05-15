package biblioteca.negocio;

import biblioteca.dados.FabricaDAO;
import biblioteca.entidades.*;
import infra.dados.armazenamento.Armazenamento;
import infra.dados.armazenamento.TipoArmazenamento;
import infra.negocios.DadoNaoEncontrado;
import infra.negocios.Registros;
import infra.console.util.*;
import java.util.Collection;
import java.sql.Date;
import java.util.Collections;

import static infra.console.util.Util.PlusDays;

public class Emprestimos extends Registros<Emprestimo> {
    public Emprestimos() {

        Armazenamento.setAtual(TipoArmazenamento.BANCO);
        FabricaDAO f = FabricaDAO.getFabricaDAO();
        setDao(f.getDAOEmprestimos());
        setRotulo("Emprestimos");
    }

    public void renovar(Emprestimo e) throws DadoNaoEncontrado, IllegalAccessException {
        Collection<Emprestimo> busca = buscar(e);
        if(busca.size() != 0){
            System.out.println("Este exemplar já possui uma reserva, operação interrompida");
            return;
        }
        Emprestimo emprestimo = buscar(e).iterator().next();
        Date devolucao = emprestimo.getData_devolucao();
        Reservas r = new Reservas();
        Reserva query = new Reserva();
        query.setId_exemplar(emprestimo.getId_exemplar());

        Collection<Reserva> busca_empr = r.buscar(query);
        if (busca_empr.size() != 0){
            System.out.println("Este exemplar já possui uma reserva, operação interrompida");
            return;
        }

        Usuarios users = new Usuarios();
        Usuario user_query = new Usuario();
        user_query.setId(emprestimo.getId_user());
        user_query = users.buscar(user_query).iterator().next();

        if(user_query.getTipo_User() == tipoUsuario.professor)
            emprestimo.setData_devolucao(
                    PlusDays(devolucao, 15)
            );
        else
            emprestimo.setData_devolucao(
                    PlusDays(devolucao, 7)
            );

        getDao().alterar(emprestimo);



    }

    @Override
    public void inserir(Emprestimo emprestimo) {
        try {
            //Pesquisa numero de multas;
            Multas multas = new Multas();
            Multa multa = new Multa();
            multa.setId_user(emprestimo.getId_user());
            int n_multas =  multas.buscar(multa).size();

            //Pesquisa o numero de emprestimo
            Emprestimo emp_query = new Emprestimo();
            int n_empr = buscar(emp_query).size();

            //Lógica

            //Verifica Reserva
            Reservas reservas = new Reservas();
            Reserva reserva = new Reserva();
            reserva.setId_exemplar(emprestimo.getId_exemplar());
            Collection<Reserva> query = reservas.buscar(reserva);

            if(query.size() != 0 && query.iterator().next().getId_user() != emprestimo.getId_user()){
                System.out.println("Livro já reservado");
                return;
            }


            if(n_multas > 0){
                if(n_empr >= 1){
                    System.out.println("Número de emprestimos para usuário com multa é 1");

                } else {
                    super.inserir(emprestimo);
                }
            } else {
                //Pesquisa tipo de usuário
                Usuarios usuarios = new Usuarios();
                Usuario usuario = new Usuario();
                usuario.setId(emprestimo.getId_user());
                tipoUsuario tUser = usuarios.buscar(usuario).iterator().next().getTipo_User();

                int maximo = tUser == tipoUsuario.professor? 5: 3;

                if(n_empr >= maximo){
                    System.out.println("Numero de imprestimos máximos excedido");

                } else super.inserir(emprestimo);
            }


        } catch (IllegalAccessException ignored){};
    }


    @Override
    public void remover(Emprestimo emprestimo) {
        try {


        super.remover(
                buscar(emprestimo).iterator().next()
        );
        } catch (IllegalAccessException ignored){};
    }

    public void buscarPorLivro(Livro livro){
        Livros livros = new Livros();
        try {
            livros.buscar(livro).forEach((livro_i) -> {
                livro_i.getExemplares().forEach((System.out::println));
            });

        } catch (IllegalAccessException ignored){};
    }
}
