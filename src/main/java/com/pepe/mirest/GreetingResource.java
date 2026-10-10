package com.pepe.mirest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;
import java.util.List;

import com.pepe.mirest.Models.Estudiante;

@Path("/api/v1/estudiante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    // 1. Obtener TODOS los estudiantes desde MySQL
    @GET
    public Response ObtenerEstudiantes() {
        List<Estudiante> estudiantes = Estudiante.listAll();
        return Response.ok(estudiantes).build();
    }

    // 2. Obtener UN estudiante por su ID desde MySQL
    @GET
    @Path("/buscar")
    public Response ObtenerEstudiantePorId(@QueryParam("id") Long id) {
        Estudiante estudiante = Estudiante.findById(id);
        if (estudiante == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Estudiante no encontrado").build();
        }
        return Response.ok(estudiante).build();
    }

    // 3. Crear UN estudiante nuevo en MySQL
    @POST
    @Transactional
    public Response CrearEstudiante(Estudiante nuevoEstudiante) {
        nuevoEstudiante.persist();
        return Response.status(Response.Status.CREATED).entity(nuevoEstudiante).build();
    }
}
