package ar.com.franco.AppJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.franco.AppJava.domain.Producto;
import ar.com.franco.AppJava.repositorios.ProducRepository;

@Controller
@RequestMapping("/compra")
public class Compra {

    @Autowired
    private ProducRepository productoRepository;
    
    @GetMapping("/{id}")
    public String compra(@PathVariable(name = "id") Long id,
                         Model model) {

        Producto producto =
                productoRepository.findById(id).get();

        model.addAttribute("producto", producto);

        return "compra/compra";
    }
    
    @PostMapping("/confirmar")
    public String confirmar(@RequestParam(name = "idProducto") Long idProducto,
                            @RequestParam(name = "cantidad") int cantidad) {

        Producto producto =
                productoRepository.findById(idProducto).get();

        if (cantidad > producto.getStock()) {
            return "redirect:/compra/" + idProducto;
        }

        if (cantidad <= 0) {
            return "redirect:/compra/" + idProducto;
        }

        producto.setStock(
                producto.getStock() - cantidad
        );

        productoRepository.save(producto);

        return "redirect:/verProductos";
    }
}
