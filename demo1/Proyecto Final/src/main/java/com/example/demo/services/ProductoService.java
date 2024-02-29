package com.example.demo.services;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    public List<Producto> getAllProducts(){
        return productoRepository.findAll();
    }
    public Producto findProductoById(Long id){
        return productoRepository.findById(id).orElse(null);
    }
    public void createProducto(Producto producto){
        productoRepository.save(producto);
    }
    public void deleteProducto(Long id){
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setEstaActivo(false);
            productoRepository.save(producto);
        }
    }
    public void updateProducto(Long id, Producto producto){
        Producto updateProducto = productoRepository.findById(id).orElse(null);
        if (updateProducto != null){
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setCodigo(producto.getCodigo());
            updateProducto.setPrecio(producto.getPrecio());
            updateProducto.setStock(producto.getStock());
            productoRepository.save(updateProducto);
        }
    }

}
