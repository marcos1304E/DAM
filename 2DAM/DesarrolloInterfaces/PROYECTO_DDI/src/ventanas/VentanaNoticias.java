package ventanas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import modelo.Usuario;
import modelo.Noticia;
import datos.GestionNoticias;
import datos.GestionFicheros;

public class VentanaNoticias extends JDialog {

    private JPanel contentPane;
    private Usuario usuario;
    private JTextArea areaNoticias;
    private GestionFicheros gestorFicheros;

    public VentanaNoticias(JFrame parent, Usuario usuario) {
        super(parent, true); // Modal
        this.usuario = usuario;
        this.gestorFicheros = new GestionFicheros();
        
        setTitle("Noticias - " + usuario.getNickname());
        setBounds(100, 100, 800, 600);
        setLocationRelativeTo(parent);
        
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png")));
        } catch (Exception e) {}
        
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        initialize();
        cargarNoticias();
    }

    private void initialize() {
        JLabel lblTitulo = new JLabel("TUS NOTICIAS DE HOY");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(0, 102, 204));
        lblTitulo.setBounds(50, 20, 300, 30);
        contentPane.add(lblTitulo);

        areaNoticias = new JTextArea();
        areaNoticias.setEditable(false);
        areaNoticias.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaNoticias.setLineWrap(true);
        areaNoticias.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(areaNoticias);
        scrollPane.setBounds(50, 60, 680, 400);
        contentPane.add(scrollPane);

        JButton btnRefrescar = new JButton("Recargar");
        btnRefrescar.setBounds(50, 480, 150, 30);
        contentPane.add(btnRefrescar);
        btnRefrescar.addActionListener(e -> cargarNoticias());

        JButton btnHistorial = new JButton("Ver Mi Historial");
        btnHistorial.setBackground(Color.ORANGE);
        btnHistorial.setBounds(220, 480, 150, 30);
        contentPane.add(btnHistorial);
        btnHistorial.addActionListener(e -> mostrarHistorial());

        JButton btnSalir = new JButton("Volver");
        btnSalir.setBounds(580, 480, 150, 30);
        contentPane.add(btnSalir);
        btnSalir.addActionListener(e -> dispose());
    }

    private void cargarNoticias() {
        areaNoticias.setText("Cargando tus noticias personalizadas...\nPor favor, espera unos segundos.");
        
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GestionNoticias gestorNoticias = new GestionNoticias();
                    String[] fuentes = gestorFicheros.cargarPreferencias(usuario);
                    String[] categorias = {"Economía", "Deportes", "Nacional", "Internacional", "Videojuegos", "Cine"};
                    
                    StringBuilder textoPantalla = new StringBuilder();
                    gestorFicheros.escribirHistorico("Usuario " + usuario.getNickname() + " accedió al panel de noticias.");

                    for (int i = 0; i < 6; i++) {
                        String fuente = fuentes[i];
                        if (!fuente.equals("Sin selección")) {
                            Noticia n = gestorNoticias.descargarTitular(fuente, categorias[i]);
                            
                            textoPantalla.append("Fuente: ").append(fuente).append("\n");
                            textoPantalla.append("Titular: ").append(n.getTitular()).append("\n\n");
                            
                            gestorFicheros.escribirHistorico("Usuario " + usuario.getNickname() + " vio en " + fuente + ": " + n.getTitular());
                        }
                    }
                    areaNoticias.setText(textoPantalla.toString());
                } catch (Exception e) {
                    areaNoticias.setText("Error al cargar: " + e.getMessage());
                }
            }
        });
        hilo.start();
    }

    private void mostrarHistorial() {
        JDialog dialogo = new JDialog(this, "Historial de Lectura: " + usuario.getNickname(), true);
        dialogo.setBounds(150, 150, 600, 400);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(null);
        
        try {
            dialogo.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.png")));
        } catch (Exception e) {}

        JTextArea areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaHistorial);
        scroll.setBounds(20, 20, 540, 300);
        dialogo.add(scroll);

        ArrayList<String> lista = gestorFicheros.leerHistoricoUsuario(usuario);
        
        if (lista.isEmpty()) {
            areaHistorial.setText("No hay registros.");
        } else {
            for (String linea : lista) {
                areaHistorial.append(linea + "\n");
            }
        }
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(220, 330, 150, 30);
        btnCerrar.addActionListener(e -> dialogo.dispose());
        dialogo.add(btnCerrar);

        dialogo.setVisible(true);
    }
}