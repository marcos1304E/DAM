package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.util.ArrayList;

import modelo.Usuario;
import modelo.Noticia;
import datos.GestionCorreo;
import datos.GestionFicheros;
import datos.GestionNoticias;

public class MenuPrincipal extends JFrame {

    private JPanel panelContenedor; 
    private CardLayout cardLayout;  
    private JMenuBar barraMenu; 

    public static final String VISTA_LOGIN = "LOGIN";
    public static final String VISTA_SESION = "SESION";
    
    public static final Color COLOR_FONDO = new Color(244, 247, 246);
    public static final Color COLOR_BLANCO = Color.WHITE;
    public static final Color COLOR_PRIMARIO = new Color(0, 122, 204);
    public static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font FUENTE_TEXTO = new Font("Segoe UI", Font.PLAIN, 14);

    public MenuPrincipal() {
        initialize();
        iniciarReloj(); 
    }

    private void initialize() {
        setTitle("Sistema de Gestión de Noticias DAM");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
            setIconImage(icon);
        } catch (Exception e) {}

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmarSalida();
            }
        });

        crearBarraMenu();

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);
        setContentPane(panelContenedor);

        Login panelLogin = new Login(this);
        panelContenedor.add(panelLogin, VISTA_LOGIN);

        cardLayout.show(panelContenedor, VISTA_LOGIN);
    }

    private void crearBarraMenu() {
        barraMenu = new JMenuBar();
        barraMenu.setBackground(COLOR_BLANCO);
        setJMenuBar(barraMenu);

        JMenu menuAyuda = new JMenu("Ayuda");
        menuAyuda.setFont(FUENTE_TEXTO);
        barraMenu.add(menuAyuda);

        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.setFont(FUENTE_TEXTO);
        itemAcercaDe.addActionListener(e -> JOptionPane.showMessageDialog(MenuPrincipal.this, 
                "Sistema de Gestión de Noticias DAM\nVersión Final\nDesarrollado por Marcos Escamilla", "Acerca de", JOptionPane.INFORMATION_MESSAGE));
        menuAyuda.add(itemAcercaDe);
        
        JMenu menuSesion = new JMenu("Sesión");
        menuSesion.setFont(FUENTE_TEXTO);
        barraMenu.add(menuSesion);
        
        JMenuItem itemCerrar = new JMenuItem("Cerrar Sesión");
        itemCerrar.setFont(FUENTE_TEXTO);
        itemCerrar.addActionListener(e -> cerrarSesion());
        menuSesion.add(itemCerrar);
        
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.setFont(FUENTE_TEXTO);
        itemSalir.addActionListener(e -> confirmarSalida());
        menuSesion.add(itemSalir);

        barraMenu.setVisible(false);
    }

    public void cargarPanelUsuario(Usuario usuarioLogueado) {
        JPanel panelDestino;
        if (usuarioLogueado.isAdmin()) {
            panelDestino = new PanelAdmin(usuarioLogueado);
        } else {
            panelDestino = new PanelUsuario(usuarioLogueado);
        }
        panelContenedor.add(panelDestino, VISTA_SESION);
        cardLayout.show(panelContenedor, VISTA_SESION);
        barraMenu.setVisible(true);
        setLocationRelativeTo(null);
    }

    public void cerrarSesion() {
        cardLayout.show(panelContenedor, VISTA_LOGIN);
        barraMenu.setVisible(false);
        setTitle("Sistema de Gestión de Noticias DAM");
    }

    private void confirmarSalida() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Salir de la aplicación?", "Salir", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) System.exit(0);
    }

    private void iniciarReloj() {
        Thread reloj = new Thread(() -> {
            while (true) {
                try {
                    GestionFicheros gf = new GestionFicheros();
                    String[] config = gf.leerConfiguracion();
                    if (Boolean.parseBoolean(config[3])) {
                        String horaActual = LocalTime.now().toString().substring(0, 5);
                        if (horaActual.equals(config[2])) {
                            System.out.println("¡ES LA HORA (" + horaActual + ")! Iniciando envío...");
            
                            GestionNoticias gn = new GestionNoticias();
                            GestionCorreo gc = new GestionCorreo();
                            ArrayList<Usuario> us = gf.leerUsuarios();
                            String[] cats = {"Economía", "Deportes", "Nacional", "Internacional", "Videojuegos", "Cine"};
                            
                            for(Usuario u : us) {
                                String[] fuentes = gf.cargarPreferencias(u);
                                StringBuilder sb = new StringBuilder("Hola " + u.getNickname() + ", tu resumen:\n\n");
                                for(int i=0; i<6; i++) {
                                    if(!fuentes[i].equals("Sin selección")) {
                                        try {
                                            Noticia n = gn.descargarTitular(fuentes[i], cats[i]);
                                            sb.append(cats[i].toUpperCase()).append(": ").append(n.getTitular()).append("\n\n");
                                        } catch(Exception ex) {}
                                    }
                                }
                                try {
                                    gc.enviarNoticia(u.getEmail(), "BOLETÍN DIARIO", sb.toString());
                                    gf.escribirHistorico("Enviado a " + u.getNickname());
                                } catch(Exception ex) { gf.escribirHistorico("Error envío a " + u.getNickname()); }
                            }
                            Thread.sleep(61000);
                        }
                    }
                    Thread.sleep(10000);
                } catch (Exception e) {}
            }
        });
        reloj.start();
    }
}