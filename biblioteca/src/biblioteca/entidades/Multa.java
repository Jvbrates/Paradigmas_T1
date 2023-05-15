package biblioteca.entidades;

import infra.entidades.Registro;
import infra.negocios.Registros;

import java.sql.Date;

public class Multa implements Registro {


    private long id;

    private long id_user;

    private long id_emprestimo;

    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String getRotulo() {
        return "Multa";
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(long id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
}
