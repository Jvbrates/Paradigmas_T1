package biblioteca.entidades;

import java.util.ArrayList;

import infra.entidades.Registro;

public class Livro implements Registro {
	private ArrayList<Autor> autores = new ArrayList<Autor>();
	private int id;
	private String isbn;
	private String titulo;
	private int ano;
	private Editora editora;	
	
	public Livro(String isbn) {
		setIsbn(isbn);
	}

	public Livro() {

	}

	public void adicionarAutor(Autor a) {
		autores.add(a);
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public Editora getEditora() {
		return editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getRotulo() {
		return "Livro";
	}

	public String getTitulo() {
		return titulo;
	}
	
	public int getAno() {
		return ano;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public void setIsbn(String isbn) {
		if (isbn != null)
			if (isbn.length() < 10 || isbn.length() > 13)
				throw new IllegalArgumentException("ISBN Inv�lido");
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("ISBN: ");
		s.append(getIsbn());
		s.append("\nTitulo: ");
		s.append(getTitulo());
		s.append(getEditora() == null ? "\nEditora: N�o informada" : "\n" + getEditora());
		s.append("\nAutores: ");
		for (Autor a : getAutores())
			s.append("\n\t" + a);
		return s.toString();
	}
	@Override
	public boolean equals(Object obj) {
		Livro l = (Livro) obj;
		return l.getIsbn().equals(getIsbn());
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
