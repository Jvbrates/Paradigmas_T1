package biblioteca.entidades;

import infra.entidades.Registro;

public class Autor implements Registro {
	private String nome;
	private long id;
	private long id_livro;

	public long getId_livro(){
		return id_livro;
	}

	public void setId_livro(long id_livro){
		this.id_livro = id_livro;
	}
	
	public Autor(String nome) {
		setNome(nome);
	}
	
	public Autor() {}

	@Override
	public boolean equals(java.lang.Object o) {
		if(o.getClass() != Autor.class)
			return false;

		Autor a = (Autor)o;
		return (a.getId_livro() == this.getId_livro());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRotulo() {
		return "Autor";
	}
	@Override
	public String toString() {
		return "Nome: " + getNome();
	}

	@Override
	public long getId() {
		return id;
	}
	
	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
}
