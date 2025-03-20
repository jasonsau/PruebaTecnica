package com.serfinsa.pruebatecnica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serfinsa.pruebatecnica.services.contract.IProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
    public ResponseEntity<?> post() {

        return null;
    }
}
