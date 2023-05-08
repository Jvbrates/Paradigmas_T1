package infra.entidades;

public class Veiculo implements Registro{
	private long id;
	@Override
	public String getRotulo() {
		return "Veiculo";
	}
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

}
