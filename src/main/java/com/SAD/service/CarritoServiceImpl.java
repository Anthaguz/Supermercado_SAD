package com.SAD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SAD.dao.CarritoDao;
import com.SAD.domain.Carrito;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoDao carritoDao;

    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(long idCliente) {
        var carrito = carritoDao.findByIdCliente(idCliente).orElse(null);
        if (carrito == null) {
            Carrito nuevo = new Carrito(idCliente); // IdCarrito = null, idCliente = 1            
            carrito = carritoDao.save(nuevo); // IdCarrito = , idCliente = 1        
        }
        return carrito;
    }
    @Override
    public void delete(Carrito carrito) {
        carritoDao.delete(carrito);
    }
}
