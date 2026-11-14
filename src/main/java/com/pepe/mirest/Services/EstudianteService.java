package com.pepe.mirest.Services;

import java.util.List;
import com.pepe.mirest.Models.Estudiante;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstudianteService {

    public List<Estudiante> obtenerEstudiantes() {
        List<Estudiante> estudiantes = List.of(
            new Estudiante(1, "Pepe", "Perales", "1234", 85),
            new Estudiante(2, "María", "Gómez", "1234", 90),
            new Estudiante(3, "Pedro", "López", "1234", 78)
        );
        return estudiantes;
    }
}