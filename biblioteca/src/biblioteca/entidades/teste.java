package biblioteca.entidades;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import infra.dados.dao.database.DAOdatabase;
import infra.negocios.DadoNaoEncontrado;

class DaoEditora extends DAOdatabase<Editora>{

	public DaoEditora(String i) {
		super(i);
	};
	
	@Override
	public void alterar(Editora e) throws DadoNaoEncontrado {
		// TODO Auto-generated method stub
		
	}
	
	protected Collection<Editora> CollectionFromRSet(ResultSet rset) throws Exception{
		ArrayList<Editora> retorno = new ArrayList<Editora>();
		
		ResultSetMetaData rsMetaData = rset.getMetaData();
		int countColumns = rsMetaData.getColumnCount();
		ArrayList<String> MetaMap = new ArrayList<String>();
		for(int i = 1; i <= countColumns; i ++) {
			MetaMap.add(rsMetaData.getColumnName(i));
		}
		
		
		while(rset.next()) {
			System.out.println("r7");
			Editora ed = new Editora();
			Field[] fd = Editora.class.getDeclaredFields();
			
			for (Field field : fd) {
				field.setAccessible(true);
				int indice = MetaMap.indexOf(field.getName());
				System.out.println("||"+MetaMap);
				if(indice != -1) {
					field.set(ed, rset.getObject(indice+1));
					System.out.println(">>" + rset.getObject(indice+1));
				}
			}
			
			retorno.add(ed);
		}
		
		
		return retorno;
	}
	
	

}

class teste {

	@Test
	void test() throws Exception {
		
		
		Livro a = new Livro();
		a.setIsbn("12345678910");
		Autor b = new Autor("Algyuem");
		ArrayList<Autor> lautor = new ArrayList<Autor>();
		lautor.add(b);
		
		lautor.get(0).getId();
		
		a.setAutores(lautor);
		Editora e = new Editora();
		e.setNome("TesteNome");
		e.setCidade("TesteCidade");
		e.setPais("TestePais");
		
		//e.setId(33);
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
	    
	    
	    //e.setId(0);
	    Livro testcad = new Livro();
	    testcad.setAutores(lautor);
	    testcad.setIsbn("12345678910");
	    testcad.setTitulo("Argument");
	    testcad.setEditora(e);
	    testcad.setAno(2011);
	    System.out.println("ID: "+e.getId());
	    DaoEditora dl = new DaoEditora("editora");
	    //dl.adicionar(e);
	    //dl.adicionar(testcad);
	    System.out.println("ID:  _ "+e.getId());
	    
	    e.setId(2);
	    Editora ed = new Editora();
	    ed.setPais("brasil");
	    //dl.buscar(new Editora());
	    dl.buscarTodos();
	    
	    //dl.remover(e);
	    
	    System.out.println(dl.buscarTodos());
		
		//fail("Not yet implemented__");
	}

}
