package modelo;

import java.util.Objects;

public class Nodo {
    private String id;
    private String tipoInstruccion; // if, for, asignacion, fin

    public Nodo(String id, String tipoInstruccion) {
        this.id = id;
        this.tipoInstruccion = tipoInstruccion;
    }

    public String getId() { return id; }
    public String getTipoInstruccion() { return tipoInstruccion; }

    //Compara por ID único para que no se agrupen en el HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return Objects.equals(id, nodo.id); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}