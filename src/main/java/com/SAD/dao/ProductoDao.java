package com.SAD.dao;

import com.SAD.domain.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
    
}