package ar.com.franco.AppJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        // Buscar usuario
        Usuario usuario = this.service.buscarPorUsuario(formulario.getUsername());

        // Obtener contexto de seguridad
        SecurityContext contexto = SecurityContextHolder.getContext();

        // Crear autenticación
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        formulario.getUsername(),
                        formulario.getPassword(),
                        usuario.collectAuthorities()
                );

        // Guardar autenticación
        contexto.setAuthentication(authentication);

        // Guardar en sesión
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                contexto
        );

        // Redirigir al home
        return "redirect:/home";
    }
}
