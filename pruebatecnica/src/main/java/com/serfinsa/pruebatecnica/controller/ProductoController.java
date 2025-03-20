package com.serfinsa.pruebatecnica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serfinsa.pruebatecnica.domain.dto.ProductoDto;
import com.serfinsa.pruebatecnica.entity.Producto;
import com.serfinsa.pruebatecnica.services.contract.IProductService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController extends Controller{

    private final IProductService productService;


    @GetMapping(path = "")
    public ResponseEntity<?> get() {
        try {
            return ResponseEntity.ok(productService.findAll());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                message.error("No se ha podido realizar la busqueda", "400")
            );
        }
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> post(@RequestBody ProductoDto productoDto, Authentication authentication) {
        try {
            return ResponseEntity.ok(productService.createProducto(productoDto, authentication));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                message.error("No se ha podido realizar la creacion", "400")
            );
        }
    }

    @PutMapping(path = "/{producto}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<?> put(
        @PathParam("producto") Producto producto,
        @RequestBody ProductoDto productoDto, Authentication authentication
        ) {
            try {
                return ResponseEntity.ok(productService.updateProducto(productoDto, authentication, producto));

            } catch(Exception e) {
                return ResponseEntity.badRequest().body(
                    message.error("No se ha podido realizar la actualizacion", "400")
                );
            }
    }

    @DeleteMapping(path = "/{producto}")
    public ResponseEntity<?> delete(@PathParam("producto") Producto producto) {
        try {
            productService.delete(producto);
            return ResponseEntity.ok(
                message.ok("Se ha eliminado el producto")
            );
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(
                message.error("No se ha podido realizar la eliminacion", "400")
            );
        }

    }

    @GetMapping(path = "/{producto}")
    public ResponseEntity<?> getById(@PathParam("producto") Producto producto) {
        return ResponseEntity.ok(producto);
    }
}
