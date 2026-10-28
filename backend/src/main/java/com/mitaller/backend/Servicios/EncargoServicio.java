package com.mitaller.backend.Servicios;

import com.mitaller.backend.DTO.EncargoDTO;
import com.mitaller.backend.Entidades.Encargo;
import com.mitaller.backend.Repositorios.EncargoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EncargoServicio {

    private final EncargoRepositorio encargoRepositorio;

    public List<EncargoDTO> obtenerTodosLosEncargos() {
        return encargoRepositorio.findAll().stream()
                .map(this::mapearADto)
                .collect(Collectors.toList());
    }

    public EncargoDTO guardarEncargo(Encargo encargo) {
        Encargo encargoGuardado = encargoRepositorio.save(encargo);
        return mapearADto(encargoGuardado);
    }

    public Optional<EncargoDTO> obtenerEncargoPorId(Long id) {
        return encargoRepositorio.findById(id)
                .map(this::mapearADto);
    }

    public void eliminarEncargo(Long id) {
        encargoRepositorio.deleteById(id);
    }

    // Método auxiliar privado para transformar Entidad -> DTO
    private EncargoDTO mapearADto(Encargo encargo) {
        EncargoDTO dto = new EncargoDTO();
        dto.setId(encargo.getId());
        dto.setTitulo(encargo.getTitulo());
        dto.setEstado(encargo.getEstado());
        dto.setMediciones(encargo.getMediciones());
        dto.setMateriales(encargo.getMateriales());
        dto.setFechaCreacion(encargo.getFechaCreacion());
        dto.setFechaEntregaEstimada(encargo.getFechaEntregaEstimada());

        if (encargo.getCliente() != null) {
            dto.setClienteId(encargo.getCliente().getId());
            dto.setNombreCliente(encargo.getCliente().getNombre());
        }
        return dto;
    }
}