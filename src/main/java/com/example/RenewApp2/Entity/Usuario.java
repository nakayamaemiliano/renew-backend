package com.example.RenewApp2.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String email;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        admin, usuario
    }

}
