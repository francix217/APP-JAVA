package ar.com.franco.AppJava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Registro{

    // Mostrar página
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro"; 
    }

    // Procesar formulario
    @PostMapping("/registro")
    public String procesarRegistro() {
        
        System.out.println("Usuario registrado");

        return "redirect:/login";
    }
}