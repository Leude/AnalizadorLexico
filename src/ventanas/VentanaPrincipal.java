package ventanas;

import classes.AnalizadorLexico;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private boolean archivo_cargado = false;
    private JPanel principal;
    private JButton iniciarButton;
    private JLabel labelEstado;
    private JButton cargarArchivoButton;
    private JLabel labelcarga;

    public VentanaPrincipal() {
        super("Analizador");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(principal);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        iniciarButton.addActionListener(e -> {
            if (archivo_cargado) {
                if (AnalizadorLexico.analizadorLexico()) {
                    labelEstado.setText("Estado: Archivo analizado");
                    if (AnalizadorLexico.crearArchivoTokens()) {
                        labelEstado.setText("Estado: Archivo creado");
                        if (AnalizadorLexico.escribirArchivoTokens()) {
                            labelEstado.setText("Estado: Archivo guardado");
                        } else {
                            labelEstado.setText("Estado: Archivo no guardado");
                        }
                    } else {
                        labelEstado.setText("Estado: Archivo no creado");
                    }
                } else {
                    labelEstado.setText("Estado: Archivo no se pudo analizar");
                }
            }
        });
        cargarArchivoButton.addActionListener(e -> {
            if (!archivo_cargado) {
                AnalizadorLexico.cargarArchivo();
                archivo_cargado = true;
                labelcarga.setText("Estado: Archivo cargado");
            }
        });
    }
}
