package ventanas;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Color;

public class VentanaCarga {

    public JFrame frame;
    private JProgressBar progressBar;
    
    // Variable para guardar la imagen en memoria
    private Image imagenFondo;

    /*
     * Launch the application.
     */
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

    /**
     * Create the application.
     */
    public VentanaCarga() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setBounds(100, 100, 610, 446);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        
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
        progressBar.setForeground(new Color(50, 205, 50));
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
                        Thread.sleep(20);
                        progressBar.setValue(i);

                        if (i == 80) {
                            if (!comprobarArchivos()) {
                                System.exit(0);
                            }
                        }
                    }
                    
                    frame.dispose();
                    iniciarLogin();
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        hilo.start();
    }

    private boolean comprobarArchivos() {
        return true;
    }

    public void iniciarLogin() {
        Login ventanaLogin = new Login();
        ventanaLogin.frame.setVisible(true); 
        System.out.println("se abre el login");
    }
}