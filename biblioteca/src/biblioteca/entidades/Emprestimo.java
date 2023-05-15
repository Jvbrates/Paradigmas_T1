package biblioteca.entidades;

import infra.entidades.Registro;
import java.sql.Date;

public class Emprestimo implements Registro {

    public long getId_exemplar() {
        return id_exemplar;
    }

    public void setId_exemplar(long id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    private long id;

    private long id_exemplar;

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    private Date data_devolucao;

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    private long id_user;


    @Override
    public String getRotulo() {
        return "Emprestimo";
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id= id;
    }

}

