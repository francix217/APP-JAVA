package ar.com.franco.AppJava.domain;

public class Cliente extends Usuario{
	
	private String genero;
	
	public Cliente(String usuario, String contraseña, String genero) {
		super(usuario, contraseña);
		this.setGenero(genero);
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
