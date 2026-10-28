package com.mitaller.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "encargo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String estado = "Medición tomada";

    @Column(columnDefinition = "TEXT")
    private String mediciones;

    @Column(columnDefinition = "TEXT")
    private String materiales;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "fecha_entrega_estimada")
    private LocalDate fechaEntregaEstimada;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "encargo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FotoEncargo> fotos;
}