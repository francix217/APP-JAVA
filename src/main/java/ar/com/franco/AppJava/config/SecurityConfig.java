package ar.com.franco.AppJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import ar.com.franco.AppJava.api.rest.LoginAPIRestService;
import ar.com.franco.AppJava.emuns.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		
	@Bean
	public SecurityFilterChain apiFilterChain(HttpSecurity htpp) throws Exception{
		
		return	htpp.securityMatcher("/api/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(request -> request
					.requestMatchers(LoginAPIRestService.API_LOGIN_URL).permitAll()
					.anyRequest().authenticated())
			.csrf(csrf -> csrf.disable())
			.build();
	}
	
	@Bean
	public SecurityFilterChain webFilterChain(HttpSecurity htpp) throws Exception{
		
		return htpp.securityMatcher("/web/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
			.authorizeHttpRequests(auth -> auth.requestMatchers("/sec/**").hasAnyRole(Permiso.ADMIN.name(), Permiso.USER.name())
					.requestMatchers("/sec/admin/**").hasAnyRole(Permiso.ADMIN.name())
					.requestMatchers("/adm/**").hasAnyRole(Permiso.ADMIN.name())
					.requestMatchers("/registro","/singup").permitAll()
					.anyRequest().permitAll())
					.formLogin(page -> page.loginPage("/login")).build();
	}
	
}
