package ar.com.franco.helpers;

import java.util.Random;

import ar.com.franco.AppJava.domain.Usuario;

public class UsuarioHelper {
	
	public static final String VALID_USER = "Franco";
	
	public final static Usuario createValidUser() {
		return new Usuario(VALID_USER);
	}
	
	public final static String createUser() {
		Random r = new Random(System.currentTimeMillis());
		
		return "user"+r.nextInt();
	}
}
