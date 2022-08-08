package com.SAD.controller;

import com.SAD.service.CarritoService;
import com.SAD.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarritoController {
    @Autowired
    private CarritoService carrito;
    
    
    @GetMapping("/carrito/items")
    public String mostrarCarrito(Model model,@AuthenticationPrincipal Authentication authentication){
        Object principal=authentication.getPrincipal();
        String usuario="";
        if (principal instanceof UserDetails){
            usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        }else {
            String username = principal.toString();
        }
        model.addAttribute(usuario, usuario);
        return "/carrito/items";
    }
}
