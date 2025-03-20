package com.serfinsa.pruebatecnica.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import com.serfinsa.pruebatecnica.repository.TipoProductoRepository;
import com.serfinsa.pruebatecnica.services.contract.ITipoProductoService;
import com.serfinsa.pruebatecnica.entity.TipoProducto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoProductoService implements ITipoProductoService{

    
    private final TipoProductoRepository tipoProductoRepository;


    @Override
    public TipoProducto save(TipoProducto entity) {
        return tipoProductoRepository.save(entity);
    }

    @Override
    public TipoProducto update(TipoProducto entity) {
        return this.save(entity);
    }

    @Override
    public void delete(TipoProducto entity) {
        tipoProductoRepository.delete(entity);
    }

    @Override
    public TipoProducto findById(int id) {
        return tipoProductoRepository.findById(id).orElse(null);
    }

    @Override
    public List<TipoProducto> findAll() {
        return tipoProductoRepository.findAll();
    }

}
