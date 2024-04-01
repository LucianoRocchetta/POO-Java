package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno (String legajo, List<Materia> materiasAprobadas) {
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<Materia>(materiasAprobadas);
    }

    public Boolean comprobarAprobacion(Materia materia) {
        return materia.getCorrelativas().stream().allMatch((correlativa) ->
                materiasAprobadas.contains(correlativa) && comprobarAprobacion(correlativa)
        );
    }

    public Boolean puedeCursar(Materia materia){
        return this.comprobarAprobacion(materia);
    }

    public String getLegajo() {
        return this.legajo;
    }

    public void setLegajo (String legajo){
        this.legajo = legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return this.materiasAprobadas;
    }

    public void setMateriasAprobadas(Materia ... materiasAprobadas) {
        Collections.addAll(this.materiasAprobadas, materiasAprobadas);
    }
}
