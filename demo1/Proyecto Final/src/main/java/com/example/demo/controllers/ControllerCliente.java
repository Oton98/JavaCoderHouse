package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.ClienteService;

import java.util.List;

@RestController
public class ControllerCliente {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/getallclientes")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/getcliente/{id}")
    public Cliente findCliente(@PathVariable Long id) {
        return clienteService.findClienteById(id);
    }

    @PostMapping("/createcliente")
    public String postCliente(@RequestBody Cliente cliente) {
        clienteService.createCliente(cliente);
        return "guardado";
    }

    @DeleteMapping("/deleteCliente/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "Eliminado";
    }

    @PutMapping("/updatecliente/{id}")
    public String updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.updateCliente(id, cliente);
        return "modificado";
    }
}
