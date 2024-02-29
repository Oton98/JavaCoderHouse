package com.example.demo.models;

import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @Setter
    private Cliente cliente;


    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Producto> productos;

    @Column
    @Setter
    @Getter
    private BigDecimal total;

    @Column
    @Setter
    @Getter
    private int fecha;
    public Long getClienteId() {
        return cliente != null ? cliente.getId() : null;
    }

}
