package ar.com.franco.AppJava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.franco.AppJava.form.ProductoForm;


@Controller
public class Productos{

    @GetMapping("/verProductos")
    public String verProductos(Model model) {
        model.addAttribute("producto", new ProductoForm());
        return "productos/productos";
    }

    @PostMapping("/productos")
    public String guardar(ProductoForm producto) {

        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: " + producto.getPrecio());

        return "productos/productos";
    }
}
