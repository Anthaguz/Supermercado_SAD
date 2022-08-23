package com.SAD.controller;

import com.SAD.domain.Producto;
import com.SAD.service.CarritoDetalleService;
import com.SAD.service.InventarioReportService;
import com.SAD.service.MarcaService;
import com.SAD.service.ProductoService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ProductoController {

    @Autowired
    private InventarioReportService facturaReportService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private CarritoDetalleService carritoDetalleService;

    @GetMapping("/producto/lista")
    public String inicio(Model model) {
        var productos = productoService.getProductos(false);
        var marcas = marcaService.getMarcas();
        model.addAttribute("marca", marcas);
        model.addAttribute("productos", productos);
        return "/producto/lista";
    }

    @GetMapping("/producto/busqueda")
    public String busqueda(String busqueda, Model model) {
        var productos = productoService.getProductos(true);
        List<Producto> resultado = new ArrayList<Producto>();
        for (Producto item : productos) {
            if (item.getNombre().contains(busqueda)) {
                resultado.add(item);
            }
        }
        model.addAttribute("productos", resultado);
        return "/producto/lista";
    }

    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto, Model model) {
        var marcas = marcaService.getMarcas();
        model.addAttribute("marca", marcas);
        return "/producto/modificar";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {
        producto.setMarca(marcaService.getMarcaById(Long.parseLong(producto.getId_marca())));
        productoService.save(producto);
        return "redirect:/producto/lista";
    }

    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";
    }

    @Transactional
    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto) {
        carritoDetalleService.deleteByProducto(producto);
        productoService.delete(producto);
        return "redirect:/producto/lista";
    }

    @GetMapping(value = "/producto/Inventario", produces = MediaType.APPLICATION_PDF_VALUE)
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
