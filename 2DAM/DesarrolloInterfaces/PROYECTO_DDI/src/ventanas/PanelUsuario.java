package ventanas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import modelo.Usuario;

public class PanelUsuario extends JPanel {

    private Usuario usuario; // Necesitamos saber quién es el usuario

    // Constructor
    public PanelUsuario(Usuario usuario) {
        this.usuario = usuario;
        initialize();
    }

    private void initialize() {
        setLayout(null);
        setBounds(0, 0, 800, 500); 
        
        JLabel textoRol = new JLabel("PANEL DE USUARIO: " + usuario.getNickname());
        textoRol.setForeground(Color.BLUE);
        textoRol.setFont(new Font("Tahoma", Font.BOLD, 14));
        textoRol.setBounds(50, 30, 300, 20);
        add(textoRol);
        
        JButton botonConfigurar = new JButton("Configurar Preferencias");
        botonConfigurar.setBounds(50, 80, 200, 40);
        add(botonConfigurar);
        
        botonConfigurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón pulsado: Abriendo preferencias...");
                try {
                    VentanaPreferencias vPref = new VentanaPreferencias(usuario);
                    vPref.frame.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //ya tenemos las preferencias que se me guarden en un txt
        
        
        
        //aqui la app lee el txt de preferencias, vea que periodicos utilizo se conecte
        // a internet y muestre los titulaares
        JButton botonVerNoticias = new JButton("Ver Noticias");
        botonVerNoticias.setBounds(50, 140, 200, 40);
        add(botonVerNoticias);
        
        botonVerNoticias.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                try {
                    JFrame ventanaPadre = (JFrame) SwingUtilities.getWindowAncestor(PanelUsuario.this);
                    
                    VentanaNoticias vNoticias = new VentanaNoticias(ventanaPadre, usuario);
                    
                    vNoticias.setVisible(true);
                    
                } catch (Exception ex) {
                    System.err.println("¡ERROR AL ABRIR LA VENTANA!");
                    ex.printStackTrace();
                }
        		
        	}
        });
              
        
    }
}