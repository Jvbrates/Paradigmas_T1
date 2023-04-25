package biblioteca.entidades;

import infra.entidades.Registro;

public class Autor implements Registro {
	private String nome;
	private int id;
	
	public Autor(String nome) {
		setNome(nome);
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
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
