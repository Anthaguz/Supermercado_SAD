package com.SAD.service;

import com.SAD.domain.Carrito;
import com.SAD.domain.Producto;
import com.SAD.domain.CarritoDetalle;
import java.util.List;

public interface CarritoDetalleService {
    CarritoDetalle getCarritoDetalle(Long idCarrito, Producto producto);
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);
    public void save(CarritoDetalle carritoDetalle);
    public void delete(CarritoDetalle carritoDetalle);
    public void deleteAll(Long idCarrito);
    public void deleteByProducto(Producto producto);
}