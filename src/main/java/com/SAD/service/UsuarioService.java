package com.SAD.service;

import com.SAD.domain.Usuario;
import java.util.List;
import org.springframework.security.core.Authentication;

public interface UsuarioService {
    public String getCurrentUser(Authentication authentication);
    public List<Usuario> getUsuarios();
    public void save(Usuario usuario);
}
