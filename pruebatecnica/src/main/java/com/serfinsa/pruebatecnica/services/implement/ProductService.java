package com.serfinsa.pruebatecnica.services.implement;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.serfinsa.pruebatecnica.domain.dto.ProductoDto;
import com.serfinsa.pruebatecnica.entity.Producto;
import com.serfinsa.pruebatecnica.entity.TipoProducto;
import com.serfinsa.pruebatecnica.entity.User;
import com.serfinsa.pruebatecnica.repository.ProductoRepository;
import com.serfinsa.pruebatecnica.services.contract.IProductService;
import com.serfinsa.pruebatecnica.services.contract.ITipoProductoService;
import com.serfinsa.pruebatecnica.services.contract.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductoRepository productoRepository;
    private final IUserService iUserService;
    private final ITipoProductoService iTipoProductoService;


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


    public Producto createProducto(ProductoDto productoDto, Authentication authentication) {
        User user = iUserService.findByEmail(authentication.getName());
        if(user == null)  return null;
        TipoProducto tipoProducto = iTipoProductoService.findById(productoDto.getIdTipoProducto());
        if(tipoProducto == null) return null; 
        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock());
        producto.setTipoProducto(tipoProducto);
        producto.setUsuarioCreacion(user);
        return this.save(producto);
    }


    public Producto updateProducto(ProductoDto productoDto, Authentication authentication, Producto producto) {
        User user = iUserService.findByEmail(authentication.getName());
        if(user == null)  return null;
        TipoProducto tipoProducto = iTipoProductoService.findById(productoDto.getIdTipoProducto());
        if(tipoProducto == null) return null; 
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock());
        producto.setTipoProducto(tipoProducto);
        producto.setUsuarioUpdate(user);
        return this.save(producto);
    }
}
