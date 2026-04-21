package ar.com.franco.AppJava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Registro{

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro/registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro() {

        System.out.println("Usuario registrado");

        return "redirect:/login";
    }
}