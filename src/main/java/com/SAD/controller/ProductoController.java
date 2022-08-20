package com.SAD.controller;

import com.SAD.domain.Producto;
import com.SAD.service.FacturaReportService;
import com.SAD.service.MarcaService;
import com.SAD.service.ProductoService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ProductoController {

    @Autowired
    private FacturaReportService facturaReportService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/producto/lista")
    public String inicio(Model model) {
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        return "/producto/lista";
    }

    /*@GetMapping("/producto/busqueda")
    public String busqueda(Model model) {
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        return "/producto/lista";
    }*/
    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto, Model model) {
        var marcas = marcaService.getMarcas();
        return "/producto/modificar";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {
        productoService.save(producto);
        return "redirect:/producto/lista";
    }

    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";
    }

    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/lista";
    }

    @GetMapping(value = "/producto/Factura", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(facturaReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
