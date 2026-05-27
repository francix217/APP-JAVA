package ar.com.franco.AppJava.servicios;

import org.springframework.security.core.Authentication;

import ar.com.franco.AppJava.domain.Usuario;

public interface JWTService {
	
	public String PREFIX_TOKEN = "Bearer ";
	
	public String buildToken(Usuario usuario);
	
	public boolean isValidToken(String token);
	
	Authentication buildAuthentication(String token);
	
}
