package biblioteca.dados.database;

import biblioteca.entidades.Autor;
import biblioteca.entidades.Livro;
import infra.dados.dao.database.DAOdatabase;
import infra.negocios.DadoNaoEncontrado;

import java.util.Collection;
import biblioteca.dados.memoria.DAOAutor;

class DAOLivro extends DAOdatabase<Livro>{

	public DAOLivro() {
		super(Livro.class);			
		
	}
	
	@Override
	public void adicionar(Livro t) throws IllegalArgumentException, IllegalAccessException, Exception {
		super.adicionar(t);

		
		
		t.getAutores().forEach(
				(i) -> {
					i.setId(t.getId());
					new DAOAutor().adicionar(i);
				} 
				);
		

			
		
		System.out.println("Deveria adicionar Autores");
	}

	@Override
	public Collection<Livro> buscar(Livro t) {
		try {
		
			Collection<Livro> query = super.buscar(t);
			
			query.forEach(
					(livro) -> {
						Autor busca = new Autor();
						busca.setId(livro.getId());
						try {
							new DAOAutor().buscar(busca).forEach((autor) -> {
								System.out.println("Adicionando autor");
								livro.adicionarAutor(autor);

							});
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DadoNaoEncontrado e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				
			);
			
			return query;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}




















