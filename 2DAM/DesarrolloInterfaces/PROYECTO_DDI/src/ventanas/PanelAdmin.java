package ventanas;

import javax.swing.JPanel;
import datos.GestionCorreo;
import datos.GestionNoticias;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import modelo.Noticia;
import modelo.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAdmin extends JPanel {

    private Usuario admin;

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

        JButton botonTest = new JButton("Test Noticias / Email");
        botonTest.setBounds(50, 140, 200, 40);
        add(botonTest);

        botonTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Definimos el hilo
                Thread hiloTest = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Iniciando test");

                            GestionNoticias gestorNoticias = new GestionNoticias();
                            Noticia noticiaPrueba = gestorNoticias.descargarTitular("Marca", "Deportes");

                            if (noticiaPrueba.getTitular().contains("Error")) {
                                JOptionPane.showMessageDialog(null, "Fallo en Jsoup: No se pudo descargar la noticia.");
                                return;
                            }

                            GestionCorreo gestorCorreo = new GestionCorreo();
                            String mensaje = "El sistema funciona\n" +
                                             "Noticia descargada: " + noticiaPrueba.getTitular();

                            gestorCorreo.enviarCorreo(admin.getEmail(), "TEST SISTEMA DAM", mensaje);

                            JOptionPane.showMessageDialog(null, "EMAIL ENVIADO\nNoticia descargada y correo enviado a: " + admin.getEmail());

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error en el test: " + ex.getMessage());
                        }
                    }
                });

                hiloTest.start();
            }
        });
    }
}