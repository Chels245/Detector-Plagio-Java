package modelo;

public class AnalizadorCodigo {
    public static GrafoFlujo generarGrafoDesdeTexto(String codigo) {
        GrafoFlujo grafo = new GrafoFlujo();
        String[] lineas = codigo.split("\n");
        
        Nodo nodoAnterior = null;
        int contador = 1;

        for (String linea : lineas) {
            linea = linea.trim();
            if (linea.isEmpty() || linea.startsWith("//")) continue;

            String tipo = "ASIGNACION";
            if (linea.contains("if")) tipo = "IF";
            else if (linea.contains("for") || linea.contains("while")) tipo = "BUCLE";
            else if (linea.contains("return")) tipo = "RETORNO";

            Nodo nuevoNodo = new Nodo("N" + (contador++), tipo);
            grafo.agregarNodo(nuevoNodo);

            if (nodoAnterior != null) {
                grafo.agregarArista(nodoAnterior, nuevoNodo);
            }
            nodoAnterior = nuevoNodo;
        }
        return grafo;
    }
}