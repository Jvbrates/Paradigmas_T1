package biblioteca.entidades;

import java.util.ArrayList;

import biblioteca.dados.database.DAOEditora;
import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;

public class Livro implements Registro {
	private ArrayList<Autor> autores = new ArrayList<Autor>();

	private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

	private long id;
	private String isbn;
	private String titulo;
	private int edicao;
	private int ano;
	private long editora;
	public Livro(String isbn) {
		setIsbn(isbn);
	}

	public Livro() {

	}

	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}

	public void adicionarExemplar(Exemplar e){
		exemplares.add(e);
	}
	public void adicionarAutor(Autor a) {
		autores.add(a);
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public long getEditora() {
		return editora;
	}

    public Editora viewEditora(){
    	DAOEditora tmp = new DAOEditora();
    	Editora ed = new Editora();
    	ed.setId(editora);
    	try {
			return tmp.buscar(ed).iterator().next();
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadoNaoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
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
		this.editora = editora.getId();
	}

	public void setEditora(long editora) {
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
		s.append(getEditora() == 0 ? "\nEditora: N�o informada" : "\n-----\n" + viewEditora()+"\n-------");
		s.append("\nAutores: ");
		for (Autor a : getAutores())
			s.append("\n\t").append(a);
		s.append("\n--------------\n");
		s.append("Exemplares\n");
		for(Exemplar e : this.exemplares){
			s.append(e).append("\n");
		}
		return s.toString();
	}
	@Override
	public boolean equals(Object obj) {
		Livro l = (Livro) obj;
		return l.getIsbn().equals(getIsbn());
	}
	
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
}
