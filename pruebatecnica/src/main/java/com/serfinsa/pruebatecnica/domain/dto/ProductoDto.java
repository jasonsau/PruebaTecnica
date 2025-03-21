package com.serfinsa.pruebatecnica.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    @NotBlank(message = "El nombre del producto es requerido")
    @NotEmpty(message = "El nombre del producto no puede estar vacío")
    @Size(max = 50, message = "El nombre del producto no puede tener más de 50 caracteres")
    private String nombre;
    @NotBlank(message = "La descripción del producto es requerida")
    @Size(max = 250, message = "La descripción del producto no puede tener más de 250 caracteres")
    @NotEmpty(message = "La descripción del producto no puede estar vacía")
    private String descripcion;
    @NotNull(message = "El precio del producto es requerido")
    private Double precio;
    @NotNull(message = "El stock del producto es requerido")
    private Integer stock;
    @NotNull(message = "El idTipoProducto del producto es requerido")
    private Integer idTipoProducto;
}
