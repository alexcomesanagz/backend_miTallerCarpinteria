package com.mitaller.backend.Controladores;

import com.mitaller.backend.DTO.ClienteDTO;
import com.mitaller.backend.Entidades.Cliente;
import com.mitaller.backend.Servicios.ClienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteServicio.listarClientes();
    }

    @PostMapping
    public ClienteDTO crearCliente(@RequestBody Cliente cliente) {
        return clienteServicio.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminarCliente(id);
    }
}