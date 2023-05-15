package biblioteca.dados.database;

import biblioteca.entidades.Emprestimo;
import infra.dados.dao.database.DAOdatabase;

public class DAOEmprestimo extends DAOdatabase<Emprestimo> {

    public DAOEmprestimo() {
        super(Emprestimo.class);
    }


}
