package biblioteca.entidades;

import infra.entidades.Registro;
import infra.negocios.Registros;

import java.sql.Date;

public class Reserva implements Registro {


    private long id;

    public long getId_exemplar() {
        return id_exemplar;
    }

    public void setId_exemplar(long id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    private long id_exemplar;

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    private long id_user;

    public Date getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }

    private Date data_retirada;

    @Override
    public String getRotulo() {
        return "Reserva";
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long id) {

    }
}
