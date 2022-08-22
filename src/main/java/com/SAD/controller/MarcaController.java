package com.SAD.controller;

import com.SAD.domain.Marca;
import com.SAD.service.MarcaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping("/marca/lista")
    public String inicio(Model model) {
        var marcas = marcaService.getMarcas();
        model.addAttribute("marcas", marcas);
        return "/marca/lista";
    }

    @GetMapping("/marca/nuevo")
    public String nuevoMarca(Marca marca, Model model) {
        var marcas = marcaService.getMarcas();
        model.addAttribute("marca", marcas);
        return "/marca/modificar";
    }
}
