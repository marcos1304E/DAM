package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelo.Usuario;
import datos.GestionFicheros;

public class PanelUsuario extends JPanel {

    private Usuario usuario;
    private final Color COLOR_BOTONES = new Color(52, 73, 94); 

    public PanelUsuario(Usuario usuario) {
        this.usuario = usuario;
        setLayout(null);
        setBackground(MenuPrincipal.COLOR_FONDO);
        setBounds(0, 0, 800, 600);
        initialize();
    }

    private void initialize() {
        JLabel textoBienvenida = new JLabel("PANEL DE USUARIO");
        textoBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        textoBienvenida.setForeground(MenuPrincipal.COLOR_PRIMARIO); 
        textoBienvenida.setFont(MenuPrincipal.FUENTE_TITULO);
        textoBienvenida.setBounds(0, 40, 800, 30);
        add(textoBienvenida);

        JLabel lblUser = new JLabel("¡Hola de nuevo, " + usuario.getNickname() + "!", SwingConstants.CENTER);
        lblUser.setFont(MenuPrincipal.FUENTE_TEXTO);
        lblUser.setForeground(Color.GRAY);
        lblUser.setBounds(0, 75, 800, 20);
        add(lblUser);
        
        JLabel lblInfo = new JLabel("Gestiona tus fuentes y lee tu resumen diario", SwingConstants.CENTER);
        lblInfo.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblInfo.setForeground(Color.LIGHT_GRAY);
        lblInfo.setBounds(0, 95, 800, 20);
        add(lblInfo);

        int x = 250; 
        int width = 300;
        int height = 60; 
        int gap = 30;    
        int startY = 160; 


        JButton botonPreferencias = new JButton("CONFIGURAR MIS PREFERENCIAS");
        botonPreferencias.setBounds(x, startY, width, height);
        estilizarBoton(botonPreferencias);
        add(botonPreferencias);


        JButton botonVerNoticias = new JButton("LEER MIS NOTICIAS");
        botonVerNoticias.setBounds(x, startY + height + gap, width, height);
        estilizarBoton(botonVerNoticias);
        add(botonVerNoticias);



        botonPreferencias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GestionFicheros gestor = new GestionFicheros();
                if (gestor.tienePreferencias(usuario)) {
                    JOptionPane.showMessageDialog(PanelUsuario.this, 
                        "¡AVISO!\nYa has configurado tus preferencias anteriormente.\nSolo se permite una configuración por usuario.", 
                        "Acceso Denegado", 
                        JOptionPane.WARNING_MESSAGE);
                } else {
                    JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(PanelUsuario.this);
                    new VentanaPreferencias(parent, usuario).setVisible(true);
                }
            }
        });

        botonVerNoticias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(PanelUsuario.this);
                new VentanaNoticias(parent, usuario).setVisible(true);
            }
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
}