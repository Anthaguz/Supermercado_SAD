package com.SAD.service;

import com.SAD.dao.MarcaDao;
import com.SAD.dao.ProductoDao;
import com.SAD.domain.Marca;
import com.SAD.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;
    
    @Autowired
    private MarcaDao marcaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista=(List <Producto>)productoDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        Marca tempMarca = marcaDao.findByNombre(producto.getId_marca());
        Producto productoFinal = new Producto(tempMarca, producto.getNombre(), producto.getDescripcion(), producto.getImagen(), producto.getPrecio(), producto.getExistencias(), producto.isActivo());
        productoDao.save(productoFinal);
    }

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
}
