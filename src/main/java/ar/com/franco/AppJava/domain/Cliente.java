package ar.com.franco.AppJava.domain;

import ar.com.franco.AppJava.emuns.Genero;

public class Cliente extends Usuario{
	
	private Genero genero;
	
	public Cliente(String usuario, String contrasena, Genero genero) {
		super(usuario, contrasena);
		this.setGenero(genero);
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
