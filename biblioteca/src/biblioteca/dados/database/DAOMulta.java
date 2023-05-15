package biblioteca.dados.database;

import biblioteca.entidades.Multa;
import infra.dados.dao.database.DAOdatabase;

public class DAOMulta extends DAOdatabase<Multa> {

    public DAOMulta() {
        super(Multa.class);
    }


}
