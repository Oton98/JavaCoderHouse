package com.example.demo.models;

import java.math.BigDecimal;
import java.util.List;

public class ComprobanteDTO {

    private ClienteDTO cliente;
    private List<LineaComprobanteDTO> lineas;
    private BigDecimal total;
    private int fecha;

    public void setLineas(List<LineaComprobanteDTO> lineas) {
    }

    public void setCliente(ClienteDTO clienteDTO) {
    }

    // Constructor, getters y setters
}
