package com.example.demo.controllers;

import com.example.demo.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.ProductoService;

import java.util.List;
@RestController
public class ControllerProducto {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/getallproductos")
    public List<Producto> getAllProductos(){
        return productoService.getAllProducts();
    }

    @GetMapping("/getproducto/{id}")
    public Producto findProducto(@PathVariable Long id){
        return productoService.findProductoById(id);
    }

    @PostMapping("/createproducto")
    public String postProducto(@RequestBody Producto producto){
        productoService.createProducto(producto);
        return "guardado";
    }

    @PutMapping("/updateproducto/{id}")
    public String updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        productoService.updateProducto(id, producto);
        return "modificado";
    }
}
