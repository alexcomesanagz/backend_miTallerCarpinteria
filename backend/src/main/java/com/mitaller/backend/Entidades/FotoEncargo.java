package com.mitaller.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foto_encargo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FotoEncargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruta_imagen", nullable = false)
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "encargo_id", nullable = false)
    private Encargo encargo;
}