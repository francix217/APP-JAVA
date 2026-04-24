package ar.com.franco.AppJava.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.emuns.Genero;
import ar.com.franco.AppJava.form.UserForm;
import ar.com.franco.AppJava.servicios.UserService;

@Controller
public class RegistroController {

    @Autowired
    private UserService servicio;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("form", new UserForm());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrar(@ModelAttribute("form") UserForm form) {

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