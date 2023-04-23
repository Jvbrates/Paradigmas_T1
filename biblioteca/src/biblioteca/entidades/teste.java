package biblioteca.entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.Test;

class teste {

	@Test
	void test() throws IllegalArgumentException, IllegalAccessException {
		
		Livro a = new Livro();
		a.setIsbn("12345678910");
		Autor b = new Autor("Algyuem");
		ArrayList<Autor> lautor = new ArrayList<Autor>();
		lautor.add(b);
		
		a.setAutores(lautor);
		Editora e = new Editora();
		e.setNome("AAA");
		a.setEditora(e);
		
	    Map<String, Object> studentMap = new HashMap<String,Object>();
	    
	    Field[] allFields = a.getClass().getDeclaredFields();
	    for (Field field : allFields) {
	        field.setAccessible(true);
	        Object value = field.get(a);
	        System.out.println(field.getType());
	        
	        studentMap.put(field.getName(), value);
	    } 
	    
	    System.out.println(studentMap);
		
		fail("Not yet implemented");
	}

}
