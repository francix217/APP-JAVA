package ar.com.franco.AppJava.domain;

import ar.com.franco.AppJava.emuns.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")

public class Cliente extends Usuario{
	    
    @Enumerated(EnumType.STRING)
    @Column(name = "GENERO")
    private Genero genero;
	
	public Cliente(String usuario, String contrasena, Genero genero) {
		super(usuario, contrasena);
		this.genero = genero;
	}
	
	/*
	public boolean tieneGenero(Genero genero) {
		return this.genero != null;
	}
	
	public boolean esGenero(Genero genero) {
		return this.genero == genero;
	}
	
	private void setGenero(Genero genero) {
		if(genero == null) {
			throw new IllegalArgumentException("El usuario debe tener min un Genero " );
		}
		this.genero = genero;
	}
	*/
	
	public Genero getGenero() {
		return genero;
	}
		
}
