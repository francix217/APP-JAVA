package ar.com.franco.AppJava.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")

public class Usuario extends Persisteble{

	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	private static final int cantMinCaracterUsuario = 5;
	private static final int cantMaxCaracterUsuario = 70;
	
	//private static final int CantCaractercontrasena = "70";;
	
	public Usuario(String usuario) {
		setUsuario(usuario);
	}
	
	public Usuario(String usuario, String contrasena) {
		this.usuario = usuario;
	    this.contrasena = contrasena;
	}
	
	public boolean tieneUsario(String usuario){
		return this.usuario.equals(usuario);
	}
	
	
	private void setUsuario(String usuario) {
		if(usuario == null || usuario.length() < cantMinCaracterUsuario || usuario.length() > cantMaxCaracterUsuario ) {
			throw new IllegalArgumentException("El usuario debe tener una cantidad MIN: " + cantMinCaracterUsuario + " de carateres y un MAX: " + cantMaxCaracterUsuario );
		}
		this.usuario = usuario;
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
}
