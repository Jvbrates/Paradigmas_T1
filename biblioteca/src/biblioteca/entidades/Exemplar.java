package biblioteca.entidades;

import infra.entidades.Registro;

public class Exemplar implements Registro {

    public Exemplar(){
    }
    private long id;

    private long id_livro;

    public void setId_livro(long id_livro) {
        this.id_livro = id_livro;
    }

    public long getId_livro() {
        return id_livro;
    }

    @Override
    public String getRotulo() {
        return "Usuario";
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id= id;
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "id=" + id +
                ", id_livro=" + id_livro +
                '}';
    }
}

