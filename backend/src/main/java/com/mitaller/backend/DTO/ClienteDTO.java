package com.mitaller.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private List<String> titulosEncargos; // Lista simplificada con los títulos de los trabajos del cliente
}