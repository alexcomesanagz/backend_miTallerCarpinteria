package com.mitaller.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncargoDTO {
    private Long id;
    private String titulo;
    private String estado;
    private String mediciones;
    private String materiales;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaEntregaEstimada;
    private Long clienteId;       // ID del cliente asociado
    private String nombreCliente; // Nombre del cliente para mostrarlo fácilmente en la app
}