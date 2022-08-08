package com.SAD.service;

import com.SAD.CarritoDeCompras.CartItemRepository;
import com.SAD.domain.ItemCarrito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SAD.domain.Usuario;

@Service
public class CarritoService {
    @Autowired
    private CartItemRepository cartRepo;
    
    public List<ItemCarrito> listarItemsCarrito (Usuario usuario){
        return cartRepo.findById(usuario);
    }
}
