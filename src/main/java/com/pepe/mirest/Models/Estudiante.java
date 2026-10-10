package com.pepe.mirest.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;
    public String apellido;
    public String password;
    public Integer telefono;

    // Panache no requiere getters/setters explícitos para los atributos públicos,
    // pero si tu docente pide validación en el teléfono, la puedes incluir así:
    public void setTelefono(Integer telefono) {
        if (telefono != null && telefono < 0) {
            throw new IllegalArgumentException("El número de teléfono no puede ser negativo");
        }
        this.telefono = telefono;
    }
}