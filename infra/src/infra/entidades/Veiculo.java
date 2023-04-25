package infra.entidades;

public class Veiculo implements Registro{
	private int id;
	@Override
	public String getRotulo() {
		return "Veiculo";
	}
	
	@Override
	public int getId() {
		return id;
	}

}
