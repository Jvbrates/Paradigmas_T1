package biblioteca.dados.database;

import biblioteca.entidades.Autor;
import biblioteca.entidades.Exemplar;
import biblioteca.entidades.Livro;
import infra.dados.dao.database.DAOdatabase;
import infra.negocios.DadoNaoEncontrado;

import java.util.Collection;
//import biblioteca.dados.memoria.DAOAutor;
import biblioteca.dados.database.DAOAutor;
class DAOLivro extends DAOdatabase<Livro>{

	private final DAOAutor daoAutor;
	private final DAOExemplar daoExemplar;
	public DAOLivro() {
		super(Livro.class);			
		daoAutor = new DAOAutor();
		daoExemplar = new DAOExemplar();
	}
	
	@Override
	public void adicionar(Livro t) throws IllegalArgumentException, IllegalAccessException, Exception {
		super.adicionar(t);

		t.getAutores().forEach(
				(i) -> {
					i.setId_livro(t.getId());
					try {
						daoAutor.adicionar(i);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				} 
				);

	}

	public Collection<Autor> BuscaAutores(Livro t) throws NullPointerException, DadoNaoEncontrado, IllegalAccessException {
		Autor busca = new Autor();
		busca.setId_livro(t.getId());
		return daoAutor.buscar(busca);

	}

	public Collection<Exemplar> BuscaExemplares(Livro t) throws NullPointerException, DadoNaoEncontrado, IllegalAccessException {
		Exemplar busca = new Exemplar();
		busca.setId_livro(t.getId());
		return daoExemplar.buscar(busca);

	}

	@Override

	public Collection<Livro> buscar(Livro t) {
		try {
		
			Collection<Livro> query = super.buscar(t);
			
			query.forEach(
					(livro) -> {
						try {
							Collection<Autor> a = BuscaAutores(livro);
							a.forEach(System.out::println);
							a.forEach(livro::adicionarAutor);
							
							Collection<Exemplar> e = BuscaExemplares(livro);
							e.forEach(livro::adicionarExemplar);
						} catch (NullPointerException | DadoNaoEncontrado e) {
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

	@Override
	public Collection<Livro> buscarTodos() {
		try {
			return buscar(null);

		} catch (Exception e){
			e.printStackTrace();
		};
		return null;

	}

	@Override
	public void alterar(Livro e) throws DadoNaoEncontrado, IllegalArgumentException, IllegalAccessException{
		super.alterar(e);

		if(e.getAutores() != null) {
			//Excluindo autores
			try {
				BuscaAutores(e).forEach(autor -> {
					try {
						daoAutor.remover(autor);

					} catch (Exception ex){
						ex.printStackTrace();

					}

				});
			}catch (DadoNaoEncontrado ex){
				System.out.println("Nao tem autores esta bosta");
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
			//Adicionando novos

			e.getAutores().forEach((autor -> {
				System.out.println(autor);
				autor.setId_livro(e.getId());
				try {
					daoAutor.adicionar(autor);
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}));
		}

	}
}




















