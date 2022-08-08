package com.SAD.CarritoDeCompras;

import com.SAD.domain.ItemCarrito;
import com.SAD.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<ItemCarrito, Integer>{
    
    public List<ItemCarrito> findById(Usuario user);
    
}
