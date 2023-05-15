package biblioteca.dados.database;

import biblioteca.entidades.Usuario;
import infra.dados.dao.database.DAOdatabase;

public class DAOUsuario extends DAOdatabase<Usuario> {
    public DAOUsuario() {
        super(Usuario.class);
    }
}
