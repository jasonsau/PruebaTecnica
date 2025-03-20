package com.serfinsa.pruebatecnica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serfinsa.pruebatecnica.services.contract.ITipoProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipoProducto")
public class TipoProductoController extends Controller {

    private final ITipoProductoService iTipoProductoService;

    @GetMapping(name = "")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(iTipoProductoService.findAll());
    }
}
