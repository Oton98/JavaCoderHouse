package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setEstaActivo(false);
            clienteRepository.save(cliente);
        }
    }

    public void updateCliente(Long id, Cliente cliente) {
        Cliente updateCliente = clienteRepository.findById(id).orElse(null);
        if (updateCliente != null) {
            updateCliente.setNombre(cliente.getNombre());
            updateCliente.setApellido(cliente.getApellido());
            updateCliente.setDni(cliente.getDni());
            updateCliente.setCorreo(cliente.getCorreo());
            clienteRepository.save(updateCliente);
        }
    }
}
