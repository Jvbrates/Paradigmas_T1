package biblioteca.dados.database;

import biblioteca.entidades.Exemplar;
import infra.dados.dao.database.DAOdatabase;
import infra.dados.dao.memoria.DAOMemoria;

public class DAOExemplar extends DAOdatabase<Exemplar> {

    public DAOExemplar() {
        super(Exemplar.class);
    }


}
