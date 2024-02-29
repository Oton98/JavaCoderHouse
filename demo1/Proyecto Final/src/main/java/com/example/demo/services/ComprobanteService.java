package com.example.demo.services;

import com.example.demo.models.*;
import com.example.demo.repository.ComprobanteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Comprobante> getAllComprobantes(){
        return comprobanteRepository.findAll();
    }

    public Comprobante findComprobanteById(Long id){
        return comprobanteRepository.findById(id).orElse(null);
    }

    public String createComprobante(Cliente cliente, List<Producto> productos) {
        Comprobante comprobante = new Comprobante();
        comprobante.setCliente(cliente);
        comprobante.setProductos(productos);
        BigDecimal total = calcularTotal(productos);
        comprobante.setTotal(total);

        comprobanteRepository.save(comprobante);

        // Crear el JSON
        try {
            return objectMapper.writeValueAsString(imprimirComprobante(comprobante));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error al generar el JSON";
        }
    }

    private BigDecimal calcularTotal(List<Producto> productos) {
        BigDecimal total = BigDecimal.ZERO;
        for (Producto producto : productos) {
            total = total.add(producto.getPrecio());
        }
        return total;
    }

    private ComprobanteDTO imprimirComprobante(Comprobante comprobante) {
        ComprobanteDTO comprobanteDTO = new ComprobanteDTO();
        comprobanteDTO.setCliente(new ClienteDTO(comprobante.getClienteId()));

        List<LineaComprobanteDTO> lineas = new ArrayList<>();
        for (Producto producto : comprobante.getProductos()) {
            LineaComprobanteDTO linea = new LineaComprobanteDTO();
            linea.setCantidad(1);
            linea.setProducto(new ProductoDTO(producto.getId()));
            lineas.add(linea);
        }
        comprobanteDTO.setLineas(lineas);

        return comprobanteDTO;
    }
}
