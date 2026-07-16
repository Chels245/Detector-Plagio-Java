package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame {
    private JButton btnIniciar;
    private JButton btnSalir;

    public VentanaMenu() {
        setTitle("Sistema de Control de Plagio");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Superior: Titulo del Proyecto
        JPanel pnlHeader = new JPanel(new GridLayout(1, 1));
        pnlHeader.setBackground(new Color(41, 128, 185));
        
        JLabel lblNombre = new JLabel("<html><center>Detector de Plagio de Código Fuente<br>mediante Isomorfismo de Grafos</center></html>", SwingConstants.CENTER);
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
        
        pnlHeader.add(lblNombre);
        pnlHeader.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(pnlHeader, BorderLayout.NORTH);

        // Panel Central
        JPanel pnlCentral = new JPanel(new GridBagLayout());
        JLabel lblBienvenida = new JLabel("BIENVENIDO!", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Consolas", Font.BOLD, 50));
        lblBienvenida.setForeground(new Color(44, 62, 80));
        pnlCentral.add(lblBienvenida);
        add(pnlCentral, BorderLayout.CENTER);

        // Panel Inferior: Botones de Acción
        JPanel pnlInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        
        btnIniciar = new JButton("Ingresar al Analizador");
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 14));
        btnIniciar.setPreferredSize(new Dimension(180, 35));
        
        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 14));
        btnSalir.setPreferredSize(new Dimension(100, 35));

        pnlInferior.add(btnIniciar);
        pnlInferior.add(btnSalir);
        add(pnlInferior, BorderLayout.SOUTH);
    }

    public void alHacerClicIniciar(ActionListener listener) {
        btnIniciar.addActionListener(listener);
    }

    public void alHacerClicSalir(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }
}