package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.Usuario;

public class MenuPrincipal extends JFrame {

    private Usuario usuarioLogueado;

    public MenuPrincipal(Usuario usuario) {
        this.usuarioLogueado = usuario;
        initialize();
    }

    private void initialize() {
        setTitle("Noticias DAM");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmarSalida();
            }
        });

        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        JMenu menuAyuda = new JMenu("Ayuda");
        barraMenu.add(menuAyuda);

        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, 
                    "Sistema de Gestión de Noticias DAM\nVersión 1.0\nDesarrollado por: Marcos Escamilla", 
                    "Acerca de", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuAyuda.add(itemAcercaDe);
        
        JMenu menuArchivo = new JMenu("Sesión");
        barraMenu.add(menuArchivo);
        
        JMenuItem itemCerrarSesion = new JMenuItem("Cerrar Sesión");
        itemCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.frame.setVisible(true);
            }
        });
        menuArchivo.add(itemCerrarSesion);
        
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmarSalida();
            }
        });
        menuArchivo.add(itemSalir);


        JLabel textoBienvenida = new JLabel("Bienvenido, " + usuarioLogueado.getNickname());
        textoBienvenida.setFont(new Font("Tahoma", Font.BOLD, 18));
        textoBienvenida.setBounds(270, 11, 400, 30);
        getContentPane().add(textoBienvenida);

        if (usuarioLogueado.isAdmin()) {
            PanelAdmin panelAdmin = new PanelAdmin(usuarioLogueado);
            panelAdmin.setBounds(0, 50, 800, 500); // Ajusta la posición debajo del menú
            getContentPane().add(panelAdmin);
        } else {
            PanelUsuario panelUsuario = new PanelUsuario(usuarioLogueado);
            panelUsuario.setBounds(0, 50, 800, 500);
            getContentPane().add(panelUsuario);
        }
        
        // Importante: Refrescar la ventana para que se vean los cambios
        repaint();
        revalidate();
    
    }

    

    private void confirmarSalida() {
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de que quieres salir de la aplicación?", 
            "Salir", 
            JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}