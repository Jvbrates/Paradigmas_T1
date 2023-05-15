package biblioteca.entidades;

import infra.entidades.Registro;

;
public class Usuario implements Registro {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;
    private long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public int getTipo_user() {
        return tipo_user;
    }

    public tipoUsuario getTipo_User(){
        return tipoUsuario.values()[tipo_user];
    }

    public void setTipo_user(tipoUsuario tipo_user) {
        this.tipo_user = tipo_user.ordinal();
    }

    private int tipo_user;

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
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", tipo_user=" + tipoUsuario.values()[tipo_user].toString() +
                '}';
    }
}
