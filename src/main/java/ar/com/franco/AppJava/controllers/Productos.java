package ar.com.franco.AppJava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.franco.AppJava.form.ProductoForm;


@Controller
public class Productos {
	
	@GetMapping("/productos")
	public String productos(Model model) {
	    model.addAttribute("form", new ProductoForm());
	    return "productos/productos";
	}
    
    @PostMapping
    public String guardar(ProductoForm form) {
        System.out.println(form.getNombre());
        System.out.println(form.getPrecio());
        return "redirect:/productos";
    }
    
    
}
