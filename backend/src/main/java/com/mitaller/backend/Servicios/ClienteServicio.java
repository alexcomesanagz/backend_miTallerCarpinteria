package com.mitaller.backend.Servicios;

import com.mitaller.backend.DTO.ClienteDTO;
import com.mitaller.backend.Entidades.Cliente;
import com.mitaller.backend.Repositorios.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServicio {

    private final ClienteRepositorio clienteRepositorio;

    public List<ClienteDTO> listarClientes() {
        return clienteRepositorio.findAll().stream()
                .map(this::mapearADto)
                .collect(Collectors.toList());
    }

    public ClienteDTO guardarCliente(Cliente cliente) {
        Cliente clienteGuardado = clienteRepositorio.save(cliente);
        return mapearADto(clienteGuardado);
    }

    public Optional<ClienteDTO> obtenerClientePorId(Long id) {
        return clienteRepositorio.findById(id)
                .map(this::mapearADto);
    }

    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }

    // Método auxiliar privado para transformar Entidad -> DTO
    private ClienteDTO mapearADto(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setTelefono(cliente.getTelefono());

        if (cliente.getEncargos() != null) {
            dto.setTitulosEncargos(
                    cliente.getEncargos().stream()
                            .map(e -> e.getTitulo())
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }
}