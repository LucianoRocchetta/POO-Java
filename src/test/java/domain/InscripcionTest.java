package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class InscripcionTest {

    Materia fisica1, am1, fisica2, ingles1, ingles2;
    Inscripcion inscripcion;

    @BeforeEach
    public void setUp() {
        //Materias base
        fisica1 = new Materia("Fisica1", new ArrayList<>());
        am1 = new Materia("Analisis Matematico 1", new ArrayList<>());
        ingles1 = new Materia("Ingles1", new ArrayList<>());

        // Materias con correlativas
        fisica2 = new Materia("Fisica2", Arrays.asList(fisica1, am1));
        ingles2 = new Materia("Ingles2", Arrays.asList(ingles1));
    }

    @Test
    public void InscripcionAprobadaTest() {
        Alumno alumnoAprobado = new Alumno("2040050", Arrays.asList(fisica1, am1, ingles1));
        Inscripcion inscripcion = new Inscripcion(alumnoAprobado, Arrays.asList(fisica2, ingles2));

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void InscripcionRechazadaTest() {
        Alumno alumnoRechazado = new Alumno("1530074", Arrays.asList(fisica1, am1));
        Inscripcion inscripcion = new Inscripcion(alumnoRechazado, Arrays.asList(ingles2));

        Assertions.assertFalse(inscripcion.aprobada());
    }
}
