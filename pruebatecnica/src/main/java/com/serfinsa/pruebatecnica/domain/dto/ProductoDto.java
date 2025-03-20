package com.serfinsa.pruebatecnica.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Integer idTipoProducto;
}
