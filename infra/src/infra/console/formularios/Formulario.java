package infra.console.formularios;

/**
 * A classe Formulario representa um formulario 
 * @author Piveta
 *
 */
public abstract class Formulario {
	protected String titulo;

	public String getTitulo() {
		if (titulo == null)
			return "(Sem título no formulario)";
		else
			return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void mostrar() {
		System.out.println("----------------------------");
		System.out.println(getTitulo());
		System.out.println("----------------------------");
	}
}
