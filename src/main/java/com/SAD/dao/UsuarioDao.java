package com.SAD.dao;

import com.SAD.domain.CarritoDetalle;
import com.SAD.domain.Cliente;
import com.SAD.domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    List<Usuario> findByIdRol(Long idRol);
    public Iterable<CarritoDetalle> findAllByCliente(Cliente cliente);
}
