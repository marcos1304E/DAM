package ventanas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.Usuario;
import modelo.Noticia;
import datos.GestionCorreo;
import datos.GestionNoticias;

public class PanelAdmin extends JPanel {

    private Usuario admin;

    // Arrays con TODAS las fuentes del sistema (6 categorías x 3 fuentes = 18 total)
    private final String[] CATEGORIAS = {
        "Economía", "Deportes", "Nacional", "Internacional", "Videojuegos", "Cine"
    };
    
    private final String[][] FUENTES = {
        {"El Economista", "Expansión", "Cinco Días"},  // Economía
        {"Marca", "As", "Mundo Deportivo"},            // Deportes
        {"El País", "El Mundo", "ABC"},                // Nacional
        {"The Guardian", "BBC News", "Le Monde"},               // Internacional
        {"3DJuegos", "Vandal", "Meristation"},         // Videojuegos
        {"Fotogramas", "Espinof", "Sensacine"}    // Cine
    };

    public PanelAdmin(Usuario admin) {
        this.admin = admin;
        initialize();
    }

    private void initialize() {
        setLayout(null);
        setBounds(0, 0, 800, 500);

        JLabel textoRol = new JLabel("PANEL DE ADMINISTRADOR");
        textoRol.setForeground(Color.RED);
        textoRol.setFont(new Font("Tahoma", Font.BOLD, 14));
        textoRol.setBounds(50, 30, 300, 20);
        add(textoRol);

        JButton botonGestionUsuarios = new JButton("Gestión Usuarios");
        botonGestionUsuarios.setBounds(50, 80, 200, 40);
        add(botonGestionUsuarios);
        botonGestionUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    VentanaGestionUsuarios ventanaGestion = new VentanaGestionUsuarios();
                    ventanaGestion.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        

        JButton botonTest = new JButton("Test Completo (18 Noticias)");
        botonTest.setBounds(50, 140, 250, 40); // Un poco más ancho
        add(botonTest);

        botonTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Al pulsar, abrimos la ventana de visualización del test
                abrirVentanaTest();
            }
        });
        
        JButton botonConfig = new JButton("Configuración Sistema");
        botonConfig.setBounds(50, 200, 250, 40); // Debajo de los otros
        add(botonConfig);
        
        botonConfig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaConfig().setVisible(true);
            }
        });
        
    }

    /**
     * Método que abre un diálogo modal para ver la descarga en tiempo real
     */
    private void abrirVentanaTest() {
        // Creamos un JDialog (ventana flotante)
        JDialog dialogoTest = new JDialog();
        dialogoTest.setTitle("Test de Sistema - Descargando 18 fuentes...");
        dialogoTest.setBounds(100, 100, 600, 500);
        dialogoTest.setLayout(null);
        dialogoTest.setLocationRelativeTo(this); // Centrado
        dialogoTest.setModal(true); // Bloquea la ventana de atrás

        // Área de texto para visualizar las noticias
        JTextArea areaLog = new JTextArea();
        areaLog.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaLog);
        scroll.setBounds(20, 20, 540, 350);
        dialogoTest.add(scroll);

        // Barra de progreso
        JProgressBar barra = new JProgressBar(0, 18);
        barra.setStringPainted(true);
        barra.setBounds(20, 380, 400, 25);
        dialogoTest.add(barra);

        // Botón enviar email (Deshabilitado al principio)
        JButton btnEnviarEmail = new JButton("Enviar Informe");
        btnEnviarEmail.setBounds(430, 380, 130, 25);
        btnEnviarEmail.setEnabled(false);
        dialogoTest.add(btnEnviarEmail);

        // --- LÓGICA DEL HILO DE DESCARGA ---
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                GestionNoticias gestor = new GestionNoticias();
                StringBuilder informeCompleto = new StringBuilder(); // Para guardar todo el texto
                int contador = 0;

                areaLog.append("INICIANDO TEST DE CONEXIÓN CON LAS 18 FUENTES\n\n");

                // Doble bucle: Recorremos categorías y sus fuentes
                for (int i = 0; i < CATEGORIAS.length; i++) {
                    String cat = CATEGORIAS[i];
                    areaLog.append("CATEGORÍA: " + cat.toUpperCase() + "\n");
                    informeCompleto.append("\nCATEGORÍA: ").append(cat).append("\n");

                    for (int j = 0; j < FUENTES[i].length; j++) {
                        String fuente = FUENTES[i][j];
                        
                        try {
                            // Descargamos
                            Noticia n = gestor.descargarTitular(fuente, cat);
                            
                            // Visualizamos
                            String linea = fuente + ": " + n.getTitular() + "\n";
                            areaLog.append(linea);
                            
                            // Guardamos para el email
                            informeCompleto.append("   ✔ ").append(fuente).append(": ").append(n.getTitular()).append("\n");

                        } catch (Exception ex) {
                            String error = "ERROR en " + fuente + ": " + ex.getMessage() + "\n";
                            areaLog.append(error);
                            informeCompleto.append("ERROR ").append(fuente).append("\n");
                        }

                        // Actualizamos barra y hacemos scroll automático
                        contador++;
                        final int progreso = contador;
                        SwingUtilities.invokeLater(() -> {
                            barra.setValue(progreso);
                            areaLog.setCaretPosition(areaLog.getDocument().getLength());
                        });

                        // Pequeña pausa para no saturar si quieres, o quitarla
                        try { Thread.sleep(100); } catch (Exception e) {}
                    }
                    areaLog.append("\n");
                }

                areaLog.append("TEST FINALIZADO");
                
                // Habilitamos el botón de email al terminar
                SwingUtilities.invokeLater(() -> {
                    btnEnviarEmail.setEnabled(true);
                    dialogoTest.setTitle("Test Finalizado");
                });
                
                // Acción del botón enviar
                btnEnviarEmail.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            GestionCorreo mailer = new GestionCorreo();
                            // Enviamos el informe acumulado
                            // Nota: Como es un informe largo, usamos el método genérico o adaptamos el asunto
                            mailer.enviarNoticia(
                                admin.getEmail(), 
                                "INFORME TÉCNICO COMPLETO", 
                                informeCompleto.toString()
                            );
                            
                            JOptionPane.showMessageDialog(dialogoTest, "Informe enviado a: " + admin.getEmail());
                            dialogoTest.dispose(); // Cerramos la ventana
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(dialogoTest, "Error al enviar: " + ex.getMessage());
                        }
                    }
                });
            }
        });

        hilo.start();
        dialogoTest.setVisible(true); // Mostramos la ventana
    }
}