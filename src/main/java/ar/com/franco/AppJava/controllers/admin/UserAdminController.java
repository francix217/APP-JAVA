package ar.com.franco.AppJava.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAdminController {

    private static final String PATH_PAGES_URL = "admin/users";
    private static final String PATH_CONTEXT_URL = "/adm/users";

    @GetMapping(PATH_CONTEXT_URL)
    public String init() {
        return PATH_PAGES_URL + "/list";
    }

    @GetMapping(PATH_CONTEXT_URL + "/edit")
    public String edit() {
        return PATH_PAGES_URL + "/form";
    }
}
