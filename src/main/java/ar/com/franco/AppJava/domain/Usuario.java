package ar.com.franco.AppJava.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Persisteble{

	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "contrasena")
	private String contrasena;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private Genero genero;

    @Column(name = "rol")
    private String rol;
	
	private static final int cantMinCaracterUsuario = 5;
	private static final int cantMaxCaracterUsuario = 70;
	
	//private static final int cantMinCaracterContrasena = 5;
	//private static final int cantMaxCaracterContrasena = 70;
	
	public Usuario() {
	}
	
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
