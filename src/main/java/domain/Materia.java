package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia (String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>(correlativas);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return this.correlativas;
    }

    public void setCorrelativas(Materia ... correlativas) {
        Collections.addAll(this.correlativas, correlativas);
    }
}
