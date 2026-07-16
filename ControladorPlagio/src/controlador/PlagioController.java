package controlador;

import modelo.AnalizadorCodigo;
import modelo.ComparadorIsomorfismo;
import modelo.GrafoFlujo;
import vista.VentanaPlagio;
import java.awt.Color;

public class PlagioController {
    private VentanaPlagio vista;

    public PlagioController(VentanaPlagio vista) {
        this.vista = vista;
        this.vista.alHacerClicComparar(e -> procesarComparacion());
    }

    private void procesarComparacion() {
        String cod1 = vista.getCodigo1();
        String cod2 = vista.getCodigo2();

        // Convertir código fuente a Grafos de Flujo de Control (CFG)
        GrafoFlujo g1 = AnalizadorCodigo.generarGrafoDesdeTexto(cod1);
        GrafoFlujo g2 = AnalizadorCodigo.generarGrafoDesdeTexto(cod2);

        // Ejecutar algoritmos de análisis estructural (Isomorfismo)
        double porcentajeSimilitud = ComparadorIsomorfismo.calcularSimilitud(g1, g2);

        // Formatear y enviar resultados a la vista
        Color colorAlerta = porcentajeSimilitud > 70.0 ? new Color(192, 57, 43) : new Color(39, 174, 96);
        String veredicto = porcentajeSimilitud > 70.0 ? "¡ALTA PROBABILIDAD DE PLAGIO ESTRUCTURAL!" : "Código Estructuralmente Distinto";
        
        vista.setResultado(String.format("Similitud: %.2f%%  --->   %s", porcentajeSimilitud, veredicto), colorAlerta);
        
        String detalles = String.format(
            "Programa A --> Nodos: %d,     Aristas: %d\n" +
            "Programa B --> Nodos: %d,     Aristas: %d\n",
            g1.getCantidadNodos(), g1.getCantidadAristas(),
            g2.getCantidadNodos(), g2.getCantidadAristas()
        );
        vista.setDetalles(detalles);
    }
}