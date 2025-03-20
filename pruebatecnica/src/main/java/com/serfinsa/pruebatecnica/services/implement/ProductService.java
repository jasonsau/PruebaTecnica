package com.serfinsa.pruebatecnica.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.serfinsa.pruebatecnica.entity.Producto;
import com.serfinsa.pruebatecnica.repository.ProductoRepository;
import com.serfinsa.pruebatecnica.services.contract.IProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductoRepository productoRepository;

    @Override
    public Producto save(Producto entity) {

        return productoRepository.save(entity);
    }

    @Override
    public Producto update(Producto entity) {
        return productoRepository.save(entity);
    }

    @Override
    public void delete(Producto entity) {
        productoRepository.delete(entity);
    }

    @Override
    public Producto findById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

}
