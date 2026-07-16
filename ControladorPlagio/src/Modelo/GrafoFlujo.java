package modelo;

import java.util.*;

public class GrafoFlujo {
    private Map<Nodo, List<Nodo>> listaAdyacencia;

    public GrafoFlujo() {
        this.listaAdyacencia = new HashMap<>();
    }

    public void agregarNodo(Nodo nodo) {
        listaAdyacencia.putIfAbsent(nodo, new ArrayList<>());
    }

    public void agregarArista(Nodo origen, Nodo destino) {
        if (listaAdyacencia.containsKey(origen) && listaAdyacencia.containsKey(destino)) {
            listaAdyacencia.get(origen).add(destino);
        }
    }

    public Map<Nodo, List<Nodo>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public int getCantidadNodos() {
        return listaAdyacencia.size();
    }

    public int getCantidadAristas() {
        int conteo = 0;
        for (List<Nodo> adyacentes : listaAdyacencia.values()) {
            conteo += adyacentes.size();
        }
        return conteo;
    }
}