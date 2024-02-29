package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Comprobante> comprobantes;

    @Column
    @Getter
    @Setter
    private String nombre;

    @Column
    @Getter
    @Setter
    private String apellido;

    @Column
    @Getter
    @Setter
    private int dni;

    @Column
    @Getter
    @Setter
    private String correo;

    @Column(name = "esta_activo")
    @Setter
    @Getter
    private boolean estaActivo = true;

}
