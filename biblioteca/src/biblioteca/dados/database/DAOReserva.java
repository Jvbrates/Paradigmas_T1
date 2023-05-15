package biblioteca.dados.database;

import biblioteca.entidades.Reserva;
import infra.dados.dao.database.DAOdatabase;

public class DAOReserva extends DAOdatabase<Reserva> {

    public DAOReserva() {
        super(Reserva.class);
    }


}
