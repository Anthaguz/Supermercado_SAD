package com.SAD.service;

import com.SAD.dao.ClienteDao;
import com.SAD.dao.UsuarioDao;
import com.SAD.domain.Cliente;
import com.SAD.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private ClienteDao clienteDao;
                
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
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(){
        var lista=(List <Usuario>)usuarioDao.findAll();
        List<Usuario> listaFinal=new ArrayList<>();
        for (Usuario user : lista){
            if(user.cliente instanceof Cliente){
                listaFinal.add(user);
            }
        }
        return listaFinal;
    }
    
    @Override
    public void save(Usuario usuario){
        Long rol = Long.valueOf(3);
        usuario.idRol=rol;
        Cliente tempuser=new Cliente(usuario.nombre,usuario.apellido,usuario.correo,usuario.direccion,usuario.telefono);
        clienteDao.save(tempuser);
        usuario.cliente=clienteDao.findByCorreo(usuario.correo);
        usuarioDao.save(usuario);
    }
}
