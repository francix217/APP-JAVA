package ar.com.franco.AppJava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.form.LoginForm;
import ar.com.franco.AppJava.form.validators.LoginFormValidator;
import ar.com.franco.AppJava.servicios.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class Login {

    public static final String LOGIN_URL = "/login";
    private static final String FORM_ATTRIBUTE = "form";
    
    @Autowired
    private UserService service;

    @Autowired
    private LoginFormValidator validator;
    
    @InitBinder(value = FORM_ATTRIBUTE)
    void initFormValidator(WebDataBinder binder) {
        binder.addValidators(this.validator);
    }
		
    @GetMapping(LOGIN_URL)
    public String login(Model model) {
        model.addAttribute(FORM_ATTRIBUTE, new LoginForm());
        return "unsecured/login";
    }

    @PostMapping("/signIn")
    public String signIn(HttpSession session,
                         @Validated @ModelAttribute(name = FORM_ATTRIBUTE) LoginForm formulario) {

        Usuario usuario = this.service.buscarPorUsuario(formulario.getUsername());

        SecurityContext contexto = SecurityContextHolder.getContext();

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        formulario.getUsername(),
                        formulario.getPassword(),
                        usuario.collectAuthorities()
                );

        contexto.setAuthentication(authentication);

        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                contexto
        );
        
        return "redirect:/home";
    }
  

    
    @PostMapping("/signIn")
    public String signIn(@Validated @ModelAttribute(name = FORM_ATTRIBUTE) LoginForm formulario, BindingResult resultado){
    		
      	Usuario usuario = this.service.buscarPorUsuario(formulario.getUsername());
		
		SecurityContext contexto = SecurityContextHolder.getContext();
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(formulario.getUsername(), null, usuario.collectAuthorities());
		contexto.setAuthentication(authentication);
    	
    	return "/home";
}
    
}
