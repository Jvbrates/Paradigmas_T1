package biblioteca.dados.database;

import biblioteca.entidades.Autor;
import infra.dados.dao.database.DAOdatabase;
import infra.dados.dao.memoria.DAOMemoria;

public class DAOAutor extends DAOdatabase<Autor> {

    public DAOAutor() {
        super(Autor.class);
    }


}
