package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
public class LineaComprobante {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Setter
        @Getter
        private Long id;

        @ManyToOne
        @JoinColumn(name = "producto_id")
        @Setter
        private Producto producto;

        @ManyToOne
        @JoinColumn(name = "comprobante_id")
        @Setter
        private Comprobante comprobante;

        @Column
        @Setter
        @Getter
        private int cantidad;

}
