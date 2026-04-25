package ar.com.franco.AppJava.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ar.com.franco.AppJava.domain.Usuario;
import ar.com.franco.AppJava.emuns.Genero;
import ar.com.franco.AppJava.form.UserForm;
import ar.com.franco.AppJava.servicios.UserService;

@Controller
public class UserAdminController {

    private static final String FORM_ATTRIBUTE = "form";
    private static final String PATH_PAGES_URL = "admin/users";
    private static final String PATH_CONTEXT_URL = "/adm/users";
    
    @Autowired
    private UserService servicio;

    @GetMapping(PATH_CONTEXT_URL)
    public String init(Model model) {

        model.addAttribute("usuarios", servicio.listarUsuarios()); 

        return PATH_PAGES_URL + "/list";
    }
    
    @GetMapping(PATH_CONTEXT_URL + "/edit")
    public String edit(Model model) {
        model.addAttribute(FORM_ATTRIBUTE, new UserForm());
        return PATH_PAGES_URL + "/form";
    }
    
    @PostMapping(PATH_CONTEXT_URL + "/save")
    public String save(@ModelAttribute("form") UserForm formulario) {

        formulario.setRol("USER");

        Usuario user = new Usuario(
            formulario.getUsuario(),
            formulario.getContrasena(),
            Genero.valueOf(formulario.getGenero()),
            formulario.getRol()
        );

        servicio.guardarUsuario(user);

        return "redirect:/adm/users";
    }
    
}