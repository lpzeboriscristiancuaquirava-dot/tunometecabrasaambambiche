package com.pepe.mirest.Controllers;

import com.pepe.mirest.Services.EstudianteService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/estudiantes")
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteController {

    @Inject
    EstudianteService estudianteService;

    @GET
    public Response obtenerEstudiantes() {
        return Response.ok(estudianteService.obtenerEstudiantes()).build();
    }
}