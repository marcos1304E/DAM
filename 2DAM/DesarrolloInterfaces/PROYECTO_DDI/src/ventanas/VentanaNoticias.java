package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import modelo.Noticia;
import datos.GestionNoticias;
import datos.GestionFicheros;

public class VentanaNoticias extends JDialog {

    private Usuario usuario;
    private JTextArea areaTextoNoticias; 

    public VentanaNoticias(JFrame ventanaPadre, Usuario usuario) {
        super(ventanaPadre, true); 
        this.usuario = usuario;
        initialize();
        cargarNoticias(); 
    }

    private void initialize() {
        setTitle("Noticias de Portada - Tiempo Real");
        setBounds(100, 100, 700, 600); 
        setLocationRelativeTo(null);   
        getContentPane().setLayout(new BorderLayout()); 

        // TÍTULO
        JLabel etiquetaTitulo = new JLabel("TUS NOTICIAS DE PORTADA");
        etiquetaTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10)); 
        getContentPane().add(etiquetaTitulo, BorderLayout.NORTH);

        // ÁREA DE TEXTO
        areaTextoNoticias = new JTextArea();
        areaTextoNoticias.setEditable(false); 
        areaTextoNoticias.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        areaTextoNoticias.setMargin(new Insets(10, 10, 10, 10));
        
        JScrollPane barraDesplazamiento = new JScrollPane(areaTextoNoticias);
        getContentPane().add(barraDesplazamiento, BorderLayout.CENTER);
        
        // BOTÓN CERRAR
        JPanel panelBoton = new JPanel();
        JButton botonCerrar = new JButton("Cerrar Pantalla");
        botonCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
        panelBoton.add(botonCerrar);
        getContentPane().add(panelBoton, BorderLayout.SOUTH);
    }

    private void cargarNoticias() {
        areaTextoNoticias.setText("Conectando con los periódicos\n\n");
        
        Thread hiloDescarga = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GestionFicheros gestion = new GestionFicheros();
                    String[] misFuentes = gestion.cargarPreferencias(usuario);
                    
                    if (misFuentes == null) {
                        areaTextoNoticias.setText("No tienes configuración guardada");
                        return;
                    }

                    areaTextoNoticias.setText(""); 
                    
                    GestionNoticias gestorInternet = new GestionNoticias();
                    String[] nombresCategorias = {"Economía", "Deportes", "Nacional", "Internacional", "Videojuegos", "Cine"};

                    boolean algunaNoticia = false;
                    
                    for (int i = 0; i < misFuentes.length; i++) {
                        String fuente = misFuentes[i];
                        String categoria = nombresCategorias[i];
                        
                        if (fuente != null && !fuente.equals("Sin selección")) {
                            algunaNoticia = true;
                            
                            Noticia noticia = gestorInternet.descargarTitular(fuente, categoria);
                            
                            String textoMostrar =
                                                  " CATEGORÍA: " + categoria.toUpperCase() + "\n" +
                                                  " FUENTE:    " + fuente + "\n" +
                                                  " HORA:      " + noticia.getHora() + "\n" +
                                                  " TITULAR:   " + noticia.getTitular() + "\n"
                                                  ;
                            
                            areaTextoNoticias.append(textoMostrar);
                            Thread.sleep(300); 
                        }
                    }
                    
                    if (!algunaNoticia) {
                        areaTextoNoticias.append("\nNo has seleccionado ninguna fuente en tus preferencias.");
                    }
                    
                    areaTextoNoticias.setCaretPosition(0);

                } catch (Exception e) {
                    areaTextoNoticias.append("\n\nError inesperado: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        hiloDescarga.start();
    }
}