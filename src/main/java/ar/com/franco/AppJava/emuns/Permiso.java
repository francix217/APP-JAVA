package ar.com.franco.AppJava.emuns;

public enum Permiso {
	ADMIN,
	USER;
	
	public String securityName() {
	    return "ROLE_" + name();
	}
}
