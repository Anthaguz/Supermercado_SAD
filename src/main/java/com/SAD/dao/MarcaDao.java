
package com.SAD.dao;

import com.SAD.domain.Marca;
import org.springframework.data.repository.CrudRepository;

public interface MarcaDao extends CrudRepository<Marca, Long> {
    Marca findByNombre(String Nombre);
    
    Marca findByIdMarca(Long idMarca);
}
