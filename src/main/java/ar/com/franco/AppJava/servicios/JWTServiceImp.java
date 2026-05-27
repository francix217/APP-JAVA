package ar.com.franco.AppJava.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import ar.com.franco.AppJava.domain.Usuario;

@Service
public class JWTServiceImp implements JWTService {

	@Override
	public String buildToken(Usuario usuario) {
		
		return JWT.create().withKeyId("My-App-" + usuario.getUsuario())
					.withClaim("authorization", obtenerPermisosUsuarios(usuario))
					.sign(Algorithm.HMAC512("my-secret-password"));
	}
	
	private List<String> obtenerPermisosUsuarios(Usuario usuario) {
	    List<String> permisos = new ArrayList<String>();
	    
	    for (GrantedAuthority auth : usuario.collectAuthorities()) {
	        permisos.add(auth.getAuthority());
	    }
	    
	    return permisos;
	}
	
}
