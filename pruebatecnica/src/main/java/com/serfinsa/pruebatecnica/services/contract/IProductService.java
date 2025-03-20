package com.serfinsa.pruebatecnica.services.contract;

import org.springframework.security.core.Authentication;

import com.serfinsa.pruebatecnica.domain.dto.ProductoDto;
import com.serfinsa.pruebatecnica.entity.Producto;

public interface IProductService extends CommonOperation<Producto>{

    Producto createProducto(ProductoDto productoDto, Authentication authentication);
    Producto updateProducto(ProductoDto productoDto, Authentication authentication, Producto producto);

}
