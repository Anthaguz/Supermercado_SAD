package com.SAD.controller;

import com.SAD.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ProductoService productoService;
    @GetMapping("/")
    public String inicio(Model model) {
        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        return "index";

    }
}
