package modelo;

import java.util.*;

public class ComparadorIsomorfismo {
    public static double calcularSimilitud(GrafoFlujo g1, GrafoFlujo g2) {
        if (g1.getCantidadNodos() == 0 && g2.getCantidadNodos() == 0) return 100.0;
        
        // Comparación de Tamaños Estructurales
        double difNodos = Math.abs(g1.getCantidadNodos() - g2.getCantidadNodos());
        double maxNodos = Math.max(g1.getCantidadNodos(), g2.getCantidadNodos());
        double similitudNodos = (1.0 - (difNodos / maxNodos)) * 100.0;

        // Comparación de Flujo de Operaciones (Histograma)
        Map<String, Integer> hist1 = obtenerHistogramaTipos(g1);
        Map<String, Integer> hist2 = obtenerHistogramaTipos(g2);
        
        double similitudTipos = calcularSimilitudHistogramas(hist1, hist2);

        // Retornar promedio 
        return (similitudNodos * 0.4) + (similitudTipos * 0.6);
    }

    private static Map<String, Integer> obtenerHistogramaTipos(GrafoFlujo grafo) {
        Map<String, Integer> hist = new HashMap<>();
        for (Nodo n : grafo.getListaAdyacencia().keySet()) {
            hist.put(n.getTipoInstruccion(), hist.getOrDefault(n.getTipoInstruccion(), 0) + 1);
        }
        return hist;
    }

    private static double calcularSimilitudHistogramas(Map<String, Integer> h1, Map<String, Integer> h2) {
        Set<String> todasLasClaves = new HashSet<>();
        todasLasClaves.addAll(h1.keySet());
        todasLasClaves.addAll(h2.keySet());

        double interseccion = 0;
        double union = 0;

        for (String clave : todasLasClaves) {
            int val1 = h1.getOrDefault(clave, 0);
            int val2 = h2.getOrDefault(clave, 0);
            interseccion += Math.min(val1, val2);
            union += Math.max(val1, val2);
        }

        return union == 0 ? 0.0 : (interseccion / union) * 100.0;
    }
}