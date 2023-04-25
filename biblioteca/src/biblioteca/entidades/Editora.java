package biblioteca.entidades;

import infra.entidades.Registro;


public class Editora implements Registro{
	private String nome;
	private String cidade;
	private String pais;
	private int id;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Editora() {
	}


	public Editora(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean equals(Object obj) {
		Editora e = (Editora) obj;
		return getNome().equals(e.getNome());
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Editora: ");
		s.append(getNome());
		s.append("\nCidade: ");
		s.append(getCidade());
		s.append("\nPais: ");
		s.append(getPais());
		return s.toString();
	}

	public String getRotulo() {
		return "Editora";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


}
