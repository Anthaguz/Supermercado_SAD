package com.SAD.service;

import com.SAD.dao.MarcaDao;
import com.SAD.domain.Marca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarcaServiceImpl implements MarcaService{
    @Autowired
    private MarcaDao marcaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Marca> getMarcas(){
        return (List<Marca>)marcaDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Marca getMarca(Marca marca) {
        return marcaDao.findById(marca.getIdMarca()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Marca marca) {
        marcaDao.save(marca);
    }

    @Override
    public void delete(Marca marca) {
        marcaDao.delete(marca);
    }
}
