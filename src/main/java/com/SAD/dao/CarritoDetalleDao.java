package com.SAD.dao;

import org.springframework.data.repository.CrudRepository;
import com.SAD.domain.CarritoDetalle;
import com.SAD.domain.Producto;
import java.util.List;
import java.util.Optional;

public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long> {
    
    public Optional<CarritoDetalle> findByIdCarritoAndProducto(Long idCarrito, Producto producto);
    
    public List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    
    public void deleteByIdCarrito(Long idCarrito);
    
}