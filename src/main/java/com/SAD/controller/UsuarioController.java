package com.SAD.controller;

import com.SAD.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j

public class UsuarioController {

    @GetMapping("/usuario/informacion")
    public String mostrarInformacion(Model model) {

        return "/usuario/informacion";
    }

    @GetMapping("/usuario/contacto")
    public String mostrarContacto(Model model) {

        return "/usuario/contacto";
    }

}
