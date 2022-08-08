/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SAD.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioServiceImpl {
    public String getCurrentUser(Authentication authentication){
        if (authentication == null) 
            return null;
        Object principal=authentication.getPrincipal();
        String usuario="";
        if (principal instanceof UserDetails){
            usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        }else {
            String username = principal.toString();
        }
        return usuario;
    }
}
