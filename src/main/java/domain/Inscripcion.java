package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasAInscribir;

    public Inscripcion (Alumno alumno, List<Materia> materiasAInscribir) {
        this.alumno = alumno;
        this.materiasAInscribir = new ArrayList<Materia>(materiasAInscribir);
    }

    // Main method
    public Boolean aprobada() {
        return materiasAInscribir.stream().allMatch(materia -> alumno.puedeCursar(materia));
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno (Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMateriasAInscribir() {
        return this.materiasAInscribir;
    }

    public void setMateriasAInscribir(Materia ... materiasAInscribir) {
        Collections.addAll(this.materiasAInscribir, materiasAInscribir);
    }
}
