package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPlagio extends JFrame {
    private JTextArea txtCodigo1;
    private JTextArea txtCodigo2;
    private JButton btnComparar;
    private JLabel lblResultado;
    private JTextArea txtDetalles;

    public VentanaPlagio() {
        setTitle("Detector de Plagio de Código Fuente por Isomorfismo de Grafos");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Superior
        JPanel pnlSuperior = new JPanel();
        pnlSuperior.setBackground(new Color(41, 128, 185));
        JLabel lblTitulo = new JLabel("Detector de Plagio Estructural");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        pnlSuperior.add(lblTitulo);
        add(pnlSuperior, BorderLayout.NORTH);

        // Panel Central: Códigos fuentes
        JPanel pnlCentral = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtCodigo1 = new JTextArea (" // Programa A\nint x = 10;\nif (x > 5) {\n    x = x + 1;\n}");
        txtCodigo1.setBorder(BorderFactory.createTitledBorder("Código Fuente A"));
        pnlCentral.add(new JScrollPane(txtCodigo1));

        txtCodigo2 = new JTextArea(" // Programa B (Renombrado)\nint valor = 10;\nif (valor > 5) {\n    valor++;\n}");
        txtCodigo2.setBorder(BorderFactory.createTitledBorder("Código Fuente B"));
        pnlCentral.add(new JScrollPane(txtCodigo2));

        add(pnlCentral, BorderLayout.CENTER);

        // Panel Inferior: Controles y Resultados
        JPanel pnlInferior = new JPanel(new BorderLayout(5, 5));
        pnlInferior.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        btnComparar = new JButton("Evaluar Isomorfismo y Estructura");
        btnComparar.setFont(new Font("Arial", Font.BOLD, 14));
        pnlInferior.add(btnComparar, BorderLayout.NORTH);

        lblResultado = new JLabel("Resultado Similitud: -- %", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setBorder(BorderFactory.createEmptyBorder(5, 5, 6, 5));
        pnlInferior.add(lblResultado, BorderLayout.CENTER);

        txtDetalles = new JTextArea(4, 20);
        txtDetalles.setEditable(false);
        txtDetalles.setBorder(BorderFactory.createTitledBorder("Métricas del Análisis"));
        pnlInferior.add(new JScrollPane(txtDetalles), BorderLayout.SOUTH);

        add(pnlInferior, BorderLayout.SOUTH);
    }

    public String getCodigo1() { return txtCodigo1.getText(); }
    public String getCodigo2() { return txtCodigo2.getText(); }
    
    public void setResultado(String texto, Color color) {
        lblResultado.setText(texto);
        lblResultado.setForeground(color);
    }

    public void setDetalles(String detalles) {
        txtDetalles.setText(detalles);
    }

    public void alHacerClicComparar(ActionListener listener) {
        btnComparar.addActionListener(listener);
    }
}