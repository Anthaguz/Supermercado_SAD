package com.SAD.service;

import com.SAD.domain.Producto;
import java.util.List;

public interface ProductoService  {

    public List<Producto> getProductos(boolean activo);

    public Producto getProducto(Producto categoria);

    public void save(Producto categoria);

    public void delete(Producto categoria);
}