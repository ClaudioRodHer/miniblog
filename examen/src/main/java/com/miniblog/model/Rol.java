package com.miniblog.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tipo;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioRol> usuarioRoles;

    // Getters y Setters
}

