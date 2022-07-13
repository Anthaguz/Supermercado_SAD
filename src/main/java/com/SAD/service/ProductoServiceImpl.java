package com.SAD.service;

import com.SAD.dao.ProductoDao;
import com.SAD.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista=(List <Producto>)categoriaDao.findAll();
        
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto categoria) {
        return categoriaDao.findById(categoria.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Producto categoria) {
        categoriaDao.delete(categoria);
    }
    
}
