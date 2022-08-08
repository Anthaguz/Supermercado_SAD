/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SAD.service;

import org.springframework.security.core.Authentication;

/**
 *
 * @author antho
 */
public interface UsuarioService {
    public String getCurrentUser(Authentication authentication);
}
