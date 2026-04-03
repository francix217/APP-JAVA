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
    @Column(name = "genero")
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
