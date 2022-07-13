package com.SAD.controller;

import com.SAD.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @GetMapping("/producto/lista")
    public String inicio(Model model) {
        var productos  = productoService.getProductos(true);
        model.addAttribute("producto",productos);
        return "/producto/lista";
    }
}
