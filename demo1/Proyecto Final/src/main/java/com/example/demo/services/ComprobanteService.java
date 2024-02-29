package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.models.Comprobante;
import com.example.demo.models.Producto;
import com.example.demo.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    public List<Comprobante> getAllComprobantes(){
        return comprobanteRepository.findAll();
    }

    public Comprobante findComprobanteById(Long id){
        return comprobanteRepository.findById(id).orElse(null);
    }

    public void createComprobante(Cliente cliente, List<Producto> productos){
        Comprobante comprobante = new Comprobante();
        comprobante.setCliente(cliente);
        comprobante.setProductos(productos);
        BigDecimal total = calcularTotal(productos);
        comprobante.setTotal(total);

        comprobanteRepository.save(comprobante);

    }


    private BigDecimal calcularTotal(List<Producto> productos) {
        BigDecimal total = BigDecimal.ZERO;
        for (Producto producto : productos) {
            total = total.add(producto.getPrecio());
        }
        return total;
    }
}
