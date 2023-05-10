package biblioteca.entidades;

import infra.entidades.Registro;

public class Autor implements Registro {
	private String nome;
	private long id;
	
	public Autor(String nome) {
		setNome(nome);
	}
	
	public Autor() {}

	public boolean equals(Autor a) {
		return (a.getId() == this.getId());
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
		
	}
}
