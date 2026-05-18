package ar.com.franco.AppJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.franco.AppJava.form.UserForm;
import ar.com.franco.AppJava.form.validators.LoginFormValidator;
import ar.com.franco.AppJava.servicios.UserService;

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
		
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("form", new UserForm());
        return "login/login";
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute("form") UserForm form) {

        if (form.getUsuario() == null || form.getUsuario().isEmpty()) {
            return "login/login";
        }

        if (form.getContrasena() == null || form.getContrasena().isEmpty()) {
            return "login/login";
        }

        return "home";
    }
}