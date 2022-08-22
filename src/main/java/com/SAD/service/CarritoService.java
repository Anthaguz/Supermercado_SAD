package com.SAD.service;

import com.SAD.domain.Carrito;

public interface CarritoService {
    
    public Carrito getCarrito(Carrito carrito);
    
    public Carrito getCarritoCliente(long idCliente);

    public void delete(Carrito carrito);
}