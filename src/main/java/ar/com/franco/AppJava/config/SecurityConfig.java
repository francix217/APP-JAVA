package ar.com.franco.AppJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import ar.com.franco.AppJava.emuns.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity htpp) throws Exception{
		
		htpp.formLogin(page -> page.loginPage("/login"));
		
		return htpp.authorizeHttpRequests(auth -> auth.requestMatchers("/sec/**").hasAnyRole(Permiso.ADMIN.name(), Permiso.USER.name())
														.requestMatchers("/sec/admin/**").hasAnyRole(Permiso.ADMIN.name())
														.requestMatchers("/adm/**").hasAnyRole(Permiso.ADMIN.name())
														.requestMatchers("/registro","/singup").permitAll()
														.anyRequest().permitAll()).build();
		
	}
	
}
