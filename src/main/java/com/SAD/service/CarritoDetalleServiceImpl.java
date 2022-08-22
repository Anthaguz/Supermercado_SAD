package com.SAD.service;

import com.SAD.dao.CarritoDetalleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SAD.domain.CarritoDetalle;
import com.SAD.domain.Producto;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoDetalleServiceImpl implements CarritoDetalleService {

    @Autowired
    CarritoDetalleDao carritoDetalleDao;

    @Override
    public CarritoDetalle getCarritoDetalle(Long idCarrito, Producto producto) {
        return carritoDetalleDao.findByIdCarritoAndProducto(idCarrito, producto).orElse(null);
    }

    @Override
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito) {
        return (List<CarritoDetalle>) carritoDetalleDao.findByIdCarrito(idCarrito);
    }

    @Override
    public void save(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.save(carritoDetalle);
    }

    @Override
    public void delete(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.delete(carritoDetalle);
    }

    @Override
    public void deleteAll(Long idCarrito) {
        carritoDetalleDao.deleteByIdCarrito(idCarrito);
    }
    @Override
    public void deleteByProducto(Producto producto){
        List<CarritoDetalle> detalles =new ArrayList<CarritoDetalle>();
        detalles=(List<CarritoDetalle>) carritoDetalleDao.findAll();
        for (CarritoDetalle item:detalles){
            carritoDetalleDao.deleteByIdCarrito(item.getIdCarrito());
        }
    }
}
