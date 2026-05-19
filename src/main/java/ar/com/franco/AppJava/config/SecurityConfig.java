package ar.com.franco.AppJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
		
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity htpp) throws Exception{
		
		return htpp.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).build();
		
	}
	
}
