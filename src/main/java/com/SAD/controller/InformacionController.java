package com.SAD.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class InformacionController {



    @GetMapping("/informacion/informacion")
    public String inicio(Model model) {

        return "/informacion/informacion";
    }
}
