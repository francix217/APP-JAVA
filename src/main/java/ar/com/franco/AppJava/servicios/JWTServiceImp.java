package ar.com.franco.AppJava.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import ar.com.franco.AppJava.domain.Usuario;

@Service
public class JWTServiceImp implements JWTService {

	private final String KEY_AUTHORIZATION = "authorization";
	private final String KEY_USERNAME = "Username";
	
	@Override
	public String buildToken(Usuario usuario) {
		
		return JWT.create().withKeyId("My-App-" + usuario.getUsuario())
					.withClaim(KEY_AUTHORIZATION, obtenerPermisosUsuarios(usuario))
					.sign(Algorithm.HMAC512("my-secret-password"));
	}
	
	@Override
	public Authentication buildAuthentication(String token) {
		DecodedJWT decodedToken = JWT.decode(token);

		String Username = decodedToken.getClaim(KEY_USERNAME).asString();
		Claim claim = decodedToken.getClaim(KEY_AUTHORIZATION);

		List<String> permisos = claim.asList(String.class);

		Authentication auth = new UsernamePasswordAuthenticationToken(Username, convertirPermisos(permisos));
		
		return auth;
	}
	
	private List<String> obtenerPermisosUsuarios(Usuario usuario) {
	    List<String> permisos = new ArrayList<String>();
	    
	    for (GrantedAuthority auth : usuario.collectAuthorities()) {
	        permisos.add(auth.getAuthority());
	    }
	    
	    return permisos;
	}
	
	private List<GrantedAuthority> convertirPermisos(List<String> permisos) {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	    for (String permiso : permisos) {
	        authorities.add(new SimpleGrantedAuthority(permiso));
	    }

	    return authorities;
	}
	
}
