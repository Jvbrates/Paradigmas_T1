package biblioteca.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import infra.dados.dao.database.DAOdatabase;
import infra.negocios.DadoNaoEncontrado;

class DaoEditora extends DAOdatabase<Editora>{

	public DaoEditora() {
		super(Editora.class);
	};

	
}

class DaoLivro extends DAOdatabase<Livro>{

	public DaoLivro() {
		super(Livro.class);			
		
	}
}

class teste {

	@Test
	void test() throws Exception {
		

		Editora e = new Editora();
		e.setNome("editec");
		e.setCidade("Maçambará");
		e.setPais("Brasil");
		DaoEditora de = new DaoEditora();
		//de.adicionar(e);
	    
	    
	    //e.setId(0);
	    Livro testcad = new Livro();
	    //testcad.setAutores(lautor);
	    testcad.setId(2);
	    testcad.setIsbn("12345648910");
	    testcad.setTitulo("CarpeDiem2");
	    testcad.setEditora(e);
	    testcad.setAno(2011);
	  
	    DaoLivro dli = new DaoLivro();
	    dli.alterar(testcad);
		
		//fail("Not yet implemented__");
	}

}

