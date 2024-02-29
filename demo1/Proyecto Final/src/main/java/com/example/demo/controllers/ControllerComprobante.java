package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.models.Comprobante;
import com.example.demo.models.Producto;
import com.example.demo.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerComprobante {

    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/getallcomprobantes")
    public List<Comprobante> getAllComprobantes(){
        return comprobanteService.getAllComprobantes();
    }

    @GetMapping("/getcomprobante/{id}")
    public Comprobante findComprobanteById(@PathVariable Long id){
        return comprobanteService.findComprobanteById(id);
    }

    @PostMapping("/createcomprobante")
    public String createComprobante(@RequestBody Cliente cliente, @RequestBody List<Producto> productos) {
        comprobanteService.createComprobante(cliente, productos);
        return "Comprobante creado correctamente";
    }
}
