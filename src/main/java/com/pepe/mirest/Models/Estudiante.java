package com.pepe.mirest.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Estudiante extends PanacheEntity {
    
    public String nombre;
    public String apellido;
    public String password;
    public int nota;

    // Constructor vacío (obligatorio para JPA/Hibernate)
    public Estudiante() {}

    // Constructor con parámetros (el que usas en el GreetingResource)
    public Estudiante(long id, String nombre, String apellido, String password, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.nota = nota;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getPassword() { return password; }
    public int getNota() { return nota; }
}