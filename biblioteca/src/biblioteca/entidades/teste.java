package biblioteca.entidades;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import infra.dados.dao.database.DAOdatabase;
import infra.negocios.DadoNaoEncontrado;

class DaoLivro extends DAOdatabase<Livro>{

	
	static String tableName = "livro";
	
	@Override
	public void remover(Livro t) throws DadoNaoEncontrado {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Livro e) throws DadoNaoEncontrado {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Livro> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Map<String, String> createMapAdd(Livro elemento) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class teste {

	@Test
	void test() throws IllegalArgumentException, IllegalAccessException {
		
		Livro a = new Livro();
		a.setIsbn("12345678910");
		Autor b = new Autor("Algyuem");
		ArrayList<Autor> lautor = new ArrayList<Autor>();
		lautor.add(b);
		
		lautor.get(0).getId();
		
		a.setAutores(lautor);
		Editora e = new Editora();
		e.setNome("AAA");
		e.setId(33);
		a.setEditora(e);
		
	    Map<String, Object> studentMap = new HashMap<String,Object>();
	    
		/*
		 * Field[] allFields = a.getClass().getDeclaredFields(); for (Field field :
		 * allFields) { field.setAccessible(true); Object value = field.get(a);
		 * System.out.println(field.getType()); if(field.getName() == "editora") {
		 * //Editora ed = (Registro) value; // System.out.println("AAAAA:"+ed.getId());
		 * 
		 * } studentMap.put(field.getName(), value); }
		 */
	    
	    
	    e.setId(2);
	    Livro testcad = new Livro();
	    testcad.setAutores(lautor);
	    testcad.setIsbn("12345678910");
	    testcad.setTitulo("Argument");
	    testcad.setEditora(e);
	    testcad.setAno(2011);
	    
	    DaoLivro dl = new DaoLivro();
	    dl.adicionar(testcad);
	    
		
		fail("Not yet implemented");
	}

}
