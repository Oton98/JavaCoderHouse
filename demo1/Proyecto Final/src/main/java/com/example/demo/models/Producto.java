package com.example.demo.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "comprobante_id")
    private Comprobante comprobante;

    @Column
    @Setter
    @Getter
    private String nombre;

    @Column
    @Setter
    @Getter
    private String codigo;

    @Column
    @Setter
    @Getter
    private BigDecimal precio;

    @Column(name = "esta_activo")
    @Setter
    @Getter
    private boolean estaActivo;

    @Column
    @Setter
    @Getter
    int Stock;

}
