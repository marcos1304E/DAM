package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.Usuario;
import modelo.Noticia;
import datos.GestionCorreo;
import datos.GestionNoticias;

public class PanelAdmin extends JPanel {

    private Usuario admin;
    
    private final String[] CATEGORIAS = {
        "Economía", "Deportes", "Nacional", "Internacional", "Videojuegos", "Cine"
    };
    
    private final String[][] FUENTES = {
        {"El Economista", "Expansión", "Cinco Días"},
        {"Marca", "As", "Mundo Deportivo"},
        {"El País", "El Mundo", "ABC"},
        {"The Guardian", "BBC News", "Le Monde"}, 
        {"3DJuegos", "IGN España", "Meristation"},
        {"Fotogramas", "Espinof", "Sensacine"}    
    };

    private final Color COLOR_BOTONES = new Color(52, 73, 94); 

    public PanelAdmin(Usuario admin) {
        this.admin = admin;
        setLayout(null);
        setBackground(MenuPrincipal.COLOR_FONDO);
        setBounds(0, 0, 800, 600);
        initialize();
    }

    private void initialize() {
        JLabel textoRol = new JLabel("PANEL DE ADMINISTRACIÓN");
        textoRol.setHorizontalAlignment(SwingConstants.CENTER);
        textoRol.setForeground(new Color(192, 57, 43));
        textoRol.setFont(MenuPrincipal.FUENTE_TITULO);
        textoRol.setBounds(0, 40, 800, 30);
        add(textoRol);
        
        JLabel lblUser = new JLabel("Sesión iniciada como: " + admin.getNickname(), SwingConstants.CENTER);
        lblUser.setFont(MenuPrincipal.FUENTE_TEXTO);
        lblUser.setForeground(Color.GRAY);
        lblUser.setBounds(0, 75, 800, 20);
        add(lblUser);

        
        int x = 250;
        int width = 300;
        int height = 55; 
        int gap = 25;    
        int startY = 140;

        JButton btnUsuarios = new JButton("GESTIÓN DE USUARIOS");
        btnUsuarios.setBounds(x, startY, width, height);
        estilizarBoton(btnUsuarios); 
        add(btnUsuarios);

        JButton btnTest = new JButton("TEST DE SISTEMA (18 FUENTES)");
        btnTest.setBounds(x, startY + height + gap, width, height);
        estilizarBoton(btnTest); 
        add(btnTest);

        JButton btnConfig = new JButton("CONFIGURACIÓN TÉCNICA");
        btnConfig.setBounds(x, startY + (height + gap) * 2, width, height);
        estilizarBoton(btnConfig); 
        add(btnConfig);


        btnUsuarios.addActionListener(e -> {
            JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
            new VentanaGestionUsuarios(parent).setVisible(true);
        });

        btnTest.addActionListener(e -> {
            JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
            abrirVentanaTest(parent);
        });

        btnConfig.addActionListener(e -> {
            JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
            new VentanaConfig(parent).setVisible(true);
        });
    }

    private void estilizarBoton(JButton btn) {
        btn.setBackground(COLOR_BOTONES);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    
    private void abrirVentanaTest(JFrame parent) {
        JDialog dialogoTest = new JDialog(parent, "Diagnóstico del Sistema", true);
        dialogoTest.setBounds(100, 100, 650, 550);
        dialogoTest.setLayout(null);
        dialogoTest.setLocationRelativeTo(parent);
        dialogoTest.getContentPane().setBackground(Color.WHITE);
        
        try {
            dialogoTest.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png")));
        } catch (Exception e) {}

        JLabel lblTituloTest = new JLabel("TEST DE CONECTIVIDAD Y SCRAPING");
        lblTituloTest.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTituloTest.setBounds(20, 15, 400, 20);
        dialogoTest.add(lblTituloTest);

        JTextArea areaLog = new JTextArea();
        areaLog.setEditable(false);
        areaLog.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaLog.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JScrollPane scroll = new JScrollPane(areaLog);
        scroll.setBounds(20, 50, 590, 380);
        scroll.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        dialogoTest.add(scroll);

        JProgressBar barra = new JProgressBar(0, 18);
        barra.setStringPainted(true);
        barra.setForeground(new Color(46, 204, 113)); 
        barra.setBounds(20, 450, 400, 30);
        dialogoTest.add(barra);

        JButton btnEnviarEmail = new JButton("ENVIAR INFORME");
        btnEnviarEmail.setBounds(440, 450, 170, 30);
        btnEnviarEmail.setBackground(new Color(230, 126, 34));
        btnEnviarEmail.setForeground(Color.WHITE);
        btnEnviarEmail.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEnviarEmail.setEnabled(false);
        dialogoTest.add(btnEnviarEmail);


        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                GestionNoticias gestor = new GestionNoticias();
                StringBuilder informeCompleto = new StringBuilder(); 
                int contador = 0;

                areaLog.append("INICIANDO TEST DE CONEXIÓN\n");
                areaLog.append("Hora de inicio: " + java.time.LocalTime.now() + "\n\n");

                for (int i = 0; i < CATEGORIAS.length; i++) {
                    String cat = CATEGORIAS[i];
                    areaLog.append("CATEGORÍA: " + cat.toUpperCase() + "\n");
                    informeCompleto.append("\nCATEGORÍA: ").append(cat).append("\n");

                    for (int j = 0; j < FUENTES[i].length; j++) {
                        String fuente = FUENTES[i][j];
                        try {
                            Noticia n = gestor.descargarTitular(fuente, cat);
                            areaLog.append(fuente + ": " + n.getTitular().substring(0, Math.min(n.getTitular().length(), 50)) + "...\n");
                            informeCompleto.append(" ").append(fuente).append(": ").append(n.getTitular()).append("\n");
                        } catch (Exception ex) {
                            areaLog.append(" ERROR en " + fuente + ": " + ex.getMessage() + "\n");
                            informeCompleto.append("ERROR ").append(fuente).append("\n");
                        }

                        contador++;
                        final int progreso = contador;
                        SwingUtilities.invokeLater(() -> {
                            barra.setValue(progreso);
                            areaLog.setCaretPosition(areaLog.getDocument().getLength());
                        });
                    }
                    areaLog.append("\n");
                }

                areaLog.append("TEST FINALIZADO CORRECTAMENTE");
                SwingUtilities.invokeLater(() -> {
                    btnEnviarEmail.setEnabled(true);
                    dialogoTest.setTitle("Diagnóstico Finalizado - Listo para enviar");
                });
                

                btnEnviarEmail.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            GestionCorreo mailer = new GestionCorreo();
                            mailer.enviarNoticia(admin.getEmail(), "INFORME TÉCNICO DE SISTEMA", informeCompleto.toString());
                            JOptionPane.showMessageDialog(dialogoTest, "Informe enviado correctamente a: " + admin.getEmail());
                            dialogoTest.dispose();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(dialogoTest, "Error enviando email: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });
        hilo.start();
        dialogoTest.setVisible(true);
    }
}