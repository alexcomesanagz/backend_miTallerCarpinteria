package com.mitaller.backend.Controladores;

import com.mitaller.backend.DTO.EncargoDTO;
import com.mitaller.backend.Entidades.Encargo;
import com.mitaller.backend.Servicios.EncargoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encargos")
@RequiredArgsConstructor
public class EncargoControlador {

    private final EncargoServicio encargoServicio;

    @GetMapping
    public List<EncargoDTO> listarEncargos() {
        return encargoServicio.obtenerTodosLosEncargos();
    }

    @PostMapping
    public EncargoDTO crearEncargo(@RequestBody Encargo encargo) {
        return encargoServicio.guardarEncargo(encargo);
    }

    @DeleteMapping("/{id}")
    public void eliminarEncargo(@PathVariable Long id) {
        encargoServicio.eliminarEncargo(id);
    }
}