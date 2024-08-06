package com.example.RenewApp2.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favoritos")
@Data
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vinilo_id", nullable = false)
    private Vinilo vinilo;
}
