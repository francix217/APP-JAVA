package ar.com.franco.AppJava.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {
	
	@JsonProperty(value = "name")
    private String usuario;
	@JsonProperty(value = "status")
    private String rol;
    
    
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
    
    
}
