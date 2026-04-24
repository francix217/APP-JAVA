package ar.com.franco.AppJava.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.franco.AppJava.form.UserForm;

@Controller
public class UserAdminController {

    private static final String FORM_ATTRIBUTE = "form";
    private static final String PATH_PAGES_URL = "admin/users";
    private static final String PATH_CONTEXT_URL = "/adm/users";

    @GetMapping(PATH_CONTEXT_URL)
    public String init() {
        return PATH_PAGES_URL + "/list";
    }

    @GetMapping(PATH_CONTEXT_URL + "/edit")
    public String edit(Model model) {
        model.addAttribute(FORM_ATTRIBUTE, new UserForm());
        return PATH_PAGES_URL + "/form";
    }
}