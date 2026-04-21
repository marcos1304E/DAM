package ventanas;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Color;

public class VentanaCarga {

    public JFrame frame;
    private JProgressBar progressBar;
    
    
    private Image imagenFondo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaCarga window = new VentanaCarga();
                    window.frame.setVisible(true);
                    window.iniciarCarga();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaCarga() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setUndecorated(true); // Sin bordes
        frame.setBounds(100, 100, 610, 446);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        
        
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
            frame.setIconImage(icon);
        } catch (Exception e) {
            
        }

        
        try {
            imagenFondo = Toolkit.getDefaultToolkit().getImage(VentanaCarga.class.getResource("/Imagenes/istockphoto-2160197653-612x612.jpg"));
        } catch (Exception e) {
            System.out.println("No se encontró la imagen de fondo: " + e.getMessage());
        }

        
        JPanel panelConFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        
        panelConFondo.setLayout(null);
        frame.setContentPane(panelConFondo);

        
        progressBar = new JProgressBar();
        progressBar.setForeground(new Color(0, 128, 192)); 
        progressBar.setStringPainted(true);
        progressBar.setBounds(50, 350, 500, 25);
        
        panelConFondo.add(progressBar);
    }

    public void iniciarCarga() {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50); 
                        progressBar.setValue(i);

                        
                        if (i == 80) {
                            progressBar.setString("Verificando archivos del sistema...");
                            Thread.sleep(500); 
                            
                            if (!comprobarArchivos()) {
                                
                                JOptionPane.showMessageDialog(frame, 
                                    "ERROR CRÍTICO:\nNo se encuentran los archivos de configuración (sistema.txt o usuarios.txt).\n" +
                                    "La aplicación no puede iniciarse y se cerrará.", 
                                    "Error de Sistema", 
                                    JOptionPane.ERROR_MESSAGE);
                                
                                System.exit(0); 
                            }
                        }
                    }
                   
                    
                    frame.dispose(); 
                    abrirAplicacionPrincipal(); 
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });        hilo.start();
    }

    
    private boolean comprobarArchivos() {
        File fUsuarios = new File("usuarios.txt");
        File fSistema = new File("sistema.txt"); 
        
        return fUsuarios.exists() && fSistema.exists();
    }

    
    
    public void abrirAplicacionPrincipal() {
        try {
            MenuPrincipal ventanaPrincipal = new MenuPrincipal();
            ventanaPrincipal.setVisible(true);
            System.out.println("Se abre la ventana principal (con el login dentro)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}