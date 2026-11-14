package com.pepe.mirest;

import java.util.ArrayList;
import java.util.List;

// --- LIBRERÍAS DE LOGS ---
import org.jboss.logging.Logger;

// --- MODELO ---
import com.pepe.mirest.Models.Estudiante;

// --- LIBRERÍAS DE JAKARTA REST (¡Estas son las que te faltan!) ---
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/estudiante")
public class GreetingResource {

    private static final Logger logger = Logger.getLogger(GreetingResource.class);
    private List<Estudiante> estudiantes = new ArrayList<>();

    public GreetingResource() {
        estudiantes.add(new Estudiante(1, "Pepe", "Perales", "password123", 100));
        estudiantes.add(new Estudiante(2, "Maria", "Gomez", "password456", 98));
        estudiantes.add(new Estudiante(3, "Pedro", "López", "password789", 45));
        estudiantes.add(new Estudiante(4, "Ana", "Martínez", "password321", 70));
        estudiantes.add(new Estudiante(5, "Luis", "Rodríguez", "password654", 85));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ObtenerEstudiantes() {
        logger.info(">>> Solicitando lista completa de estudiantes");
        return Response.ok(estudiantes).build();
    }

    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ObtenerEstudiantes(@QueryParam("id") String id) {
        
        // 1. Mostrar el valor de id
        logger.info(">>> Valor de ID recibido: " + id);

        Estudiante estudianteBuscado = null;

        // 2. Indicar que inicia bucle
        logger.debug(">>> Iniciando el bucle de busqueda...");

        for (Estudiante estudiante : estudiantes) {
            // 3. Mostrar el valor de 'estudiante'
            logger.debug(">>> Evaluando estudiante: " + estudiante.getNombre() + " (ID: " + estudiante.id + ")");

            if (String.valueOf(estudiante.id).equals(id)) {
                // 4. Indicar que se encontró al estudiante
                logger.info(">>> ¡Se encontro al estudiante!: " + estudiante.getNombre());
                estudianteBuscado = estudiante;
                break;
            }
        }

        // 5. Indicar que acabó el bucle
        logger.debug(">>> Acabo el bucle de busqueda.");

        if (estudianteBuscado == null) {
            logger.warn(">>> No se encontro ningun estudiante con ID: " + id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(estudianteBuscado).build();
    }
}