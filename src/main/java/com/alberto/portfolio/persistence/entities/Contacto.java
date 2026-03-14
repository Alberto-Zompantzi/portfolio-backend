package com.alberto.portfolio.persistence.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity //Indica que es una tabla
@Table(name = "contactos") //Nombre de la tabla en Postgres
@Data  //Lombok genera Getters, Setters, toString(), etc...
@NoArgsConstructor //Creo un constructor vacío
@AllArgsConstructor //Creo un constructor con todos los parámetros
public class Contacto {
    //Esta es mi representación de la tabla en la bd
    //Es como un mapa que le dice a Hibernate (el motor de persistencia)
    //cómo crear la tabla en PostgreSQL

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private Long id;

    //Cada atributo es una columna en la tabla contactos
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;
    
    private String asunto;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    private LocalDateTime fechaRegistro;

    // Este método se ejecuta automáticamente antes de guardar
    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
    }
}
