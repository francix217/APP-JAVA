package ar.com.franco.AppJava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.franco.AppJava.form.UserForm;

@Controller
public class Login {

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