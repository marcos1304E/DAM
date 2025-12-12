package ventanas;

import javax.swing.*;

import datos.GestionCorreo;
import datos.GestionFicheros;
import datos.GestionNoticias;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

import modelo.Noticia;
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
        

        Thread reloj = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        GestionFicheros gf = new GestionFicheros();
                        String[] config = gf.leerConfiguracion();
                        
                        // config[2] es la HORA (ej: "08:00"), config[3] es "true" (ACTIVO)
                        if (Boolean.parseBoolean(config[3])) {
                            
                            // Obtenemos hora actual HH:mm
                            String horaActual = LocalTime.now().toString().substring(0, 5); 
                            
                            // Si coincide la hora...
                            if (horaActual.equals(config[2])) {
                                System.out.println("¡ES LA HORA (" + horaActual + ")! Iniciando envío masivo");
                                
                                // 1. Cargamos herramientas
                                GestionNoticias gestorNoticias = new GestionNoticias();
                                GestionCorreo gestorCorreo = new GestionCorreo();
                                java.util.ArrayList<Usuario> listaUsuarios = gf.leerUsuarios();
                                
                                // Categorías fijas para el bucle
                                String[] nombresCategorias = {"Economía", "Deportes", "Nacional", "Internacional", "Videojuegos", "Cine"};

                                // 2. Recorremos TODOS los usuarios
                                for (Usuario u : listaUsuarios) {
                                    System.out.println("Procesando usuario: " + u.getNickname());
                                    
                                    // Cargamos sus periódicos favoritos
                                    String[] misFuentes = gf.cargarPreferencias(u);
                                    StringBuilder resumen = new StringBuilder();
                                    resumen.append("Hola ").append(u.getNickname()).append(", aquí tienes tu resumen de hoy:\n\n");
                                    
                                    // 3. Descargamos sus 6 noticias
                                    for (int i = 0; i < 6; i++) {
                                        String fuente = misFuentes[i];
                                        String categoria = nombresCategorias[i];
                                        
                                        if (!fuente.equals("Sin selección")) {
                                            Noticia n = gestorNoticias.descargarTitular(fuente, categoria);
                                            resumen.append("--- ").append(categoria.toUpperCase()).append(" ---\n");
                                            resumen.append("Fuente: ").append(fuente).append("\n");
                                            resumen.append("Titular: ").append(n.getTitular()).append("\n\n");
                                        }
                                    }

                                    try {
                                        gestorCorreo.enviarNoticia(
                                            u.getEmail(), 
                                            "RESUMEN DIARIO", 
                                            resumen.toString()
                                        );
                                        
                                        // 5. Guardamos en el Histórico
                                        gf.escribirHistorico("Boletín enviado a " + u.getNickname() + " (" + u.getEmail() + ")");
                                        System.out.println("Enviado correctamente.");
                                        
                                    } catch (Exception ex) {
                                        System.err.println("Error enviando a " + u.getNickname() + ": " + ex.getMessage());
                                        gf.escribirHistorico("FALLO envío a " + u.getNickname());
                                    }
                                }
                                
                                System.out.println("ENVÍO FINALIZADO");
                                
                                // IMPORTANTE: Dormir 61 segundos para que no se repita en el mismo minuto
                                Thread.sleep(61000); 
                            }
                        }
                        
                        // Comprobamos cada 10 segundos
                        Thread.sleep(10000); 
                        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        reloj.start();
        
        
        
    
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