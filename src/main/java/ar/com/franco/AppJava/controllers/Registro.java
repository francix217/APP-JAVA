package ar.com.franco.AppJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.emuns.Genero;
import ar.com.franco.AppJava.form.UserForm;
import ar.com.franco.AppJava.form.validators.UserFormValidator;
import ar.com.franco.AppJava.servicios.UserService;

@Controller
public class Registro {

    @Autowired
    private UserService servicio;

    @Autowired
    private UserFormValidator userFormValidator;

    @InitBinder("form")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userFormValidator);
    }

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("form", new UserForm());
        return "registro/registro";
    }

    @PostMapping("/registro")
    public String registrar(@Validated @ModelAttribute("form") UserForm form, BindingResult result) {


        if (result.hasErrors()) {
            return "registro/registro";
        }

        form.setRol("USER");

        Usuario user = new Usuario(
            form.getUsuario(),
            form.getContrasena(),
            Genero.valueOf(form.getGenero()),
            form.getRol()
        );

        servicio.guardarUsuario(user);

        return "redirect:/login";
    }
}