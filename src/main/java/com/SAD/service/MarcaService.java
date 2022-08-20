package com.SAD.service;

import com.SAD.domain.Marca;
import java.util.List;

public interface MarcaService {
    public List<Marca> getMarcas();

    public Marca getMarca(Marca cliente);

    public void save(Marca cliente);

    public void delete(Marca cliente);
}
