import vista.VentanaMenu;
import vista.VentanaPlagio;
import controlador.PlagioController;

public class Main {
    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Pantalla del Menú Principal
            VentanaMenu ventanaMenu = new VentanaMenu();
            
            // Ingresar al analizador
            ventanaMenu.alHacerClicIniciar(e -> {
                ventanaMenu.dispose(); // Cierra y libera la memoria del menú
                
                // Abre el detector de plagio
                VentanaPlagio vistaPlagio = new VentanaPlagio();
                new PlagioController(vistaPlagio);
                vistaPlagio.setVisible(true);
            });
            
            // Botón de salir
            ventanaMenu.alHacerClicSalir(e -> System.exit(0));
            
            // Hacer visible el menú al arrancar
            ventanaMenu.setVisible(true);
        });
    }
}