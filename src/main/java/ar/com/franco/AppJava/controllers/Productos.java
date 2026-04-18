package ar.com.franco.AppJava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Productos {
	
    @GetMapping("/productos")
    public String productos() {
        return "productos/productos";
    }
}
