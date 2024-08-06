package com.example.RenewApp2.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vinilos")
@Data
public class Vinilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String artista;
    private String genero;
    private int año;
    private double precio;


}
