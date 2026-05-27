package ar.com.franco.AppJava.servicios;

import ar.com.franco.AppJava.domain.Usuario;

public interface JWTService {

	public String buildToken(Usuario usuario);
	
}
