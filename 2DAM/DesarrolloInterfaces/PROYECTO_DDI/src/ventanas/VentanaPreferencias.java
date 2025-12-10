package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelo.Usuario;

public class VentanaPreferencias {

    public JFrame frame; 
    private Usuario usuario; 

    private JComboBox<String> comboEconomia;
    private JComboBox<String> comboDeportes;
    private JComboBox<String> comboNacional;
    private JComboBox<String> comboInternacional;
    private JComboBox<String> comboTecnologia; 
    private JComboBox<String> comboCine;       


    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Usuario userPrueba = new Usuario("Test", "1234", "test@email.com", false);
                    VentanaPreferencias window = new VentanaPreferencias(userPrueba);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor
     */
    public VentanaPreferencias(Usuario usuario) {
        this.usuario = usuario;
        initialize();
    }

    /**
     * Inicializar contenidos
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null); 
        frame.setTitle("Configuración de Noticias - " + usuario.getNickname());


        JLabel lblTitulo = new JLabel("SELECCIONA TUS FUENTES");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(130, 20, 300, 20);
        frame.getContentPane().add(lblTitulo);


        JLabel lblEconomia = new JLabel("Economía:");
        lblEconomia.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEconomia.setBounds(40, 70, 100, 20);
        frame.getContentPane().add(lblEconomia);

        comboEconomia = new JComboBox<>();
        comboEconomia.setModel(new DefaultComboBoxModel<>(new String[] {"El Economista", "Expansión", "Cinco Días"}));
        comboEconomia.setBounds(150, 70, 250, 20);
        frame.getContentPane().add(comboEconomia);

        JLabel lblDeportes = new JLabel("Deportes:");
        lblDeportes.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDeportes.setBounds(40, 120, 100, 20);
        frame.getContentPane().add(lblDeportes);

        comboDeportes = new JComboBox<>();
        comboDeportes.setModel(new DefaultComboBoxModel<>(new String[] {"Marca", "As", "Mundo Deportivo"}));
        comboDeportes.setBounds(150, 120, 250, 20);
        frame.getContentPane().add(comboDeportes);


        JLabel lblNacional = new JLabel("Nacional:");
        lblNacional.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNacional.setBounds(40, 170, 100, 20);
        frame.getContentPane().add(lblNacional);

        comboNacional = new JComboBox<>();
        comboNacional.setModel(new DefaultComboBoxModel<>(new String[] {"El País", "El Mundo", "ABC"}));
        comboNacional.setBounds(150, 170, 250, 20);
        frame.getContentPane().add(comboNacional);


        JLabel lblInternacional = new JLabel("Internacional:");
        lblInternacional.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblInternacional.setBounds(40, 220, 100, 20);
        frame.getContentPane().add(lblInternacional);

        comboInternacional = new JComboBox<>();
        comboInternacional.setModel(new DefaultComboBoxModel<>(new String[] {"CNN", "BBC News", "Le Monde"}));
        comboInternacional.setBounds(150, 220, 250, 20);
        frame.getContentPane().add(comboInternacional);


        JLabel lblTecnologia = new JLabel("Videojuegos:");
        lblTecnologia.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTecnologia.setBounds(40, 270, 100, 20);
        frame.getContentPane().add(lblTecnologia);

        comboTecnologia = new JComboBox<>();
        comboTecnologia.setModel(new DefaultComboBoxModel<>(new String[] {"3DJuegos", "Vandal", "Meristation"}));
        comboTecnologia.setBounds(150, 270, 250, 20);
        frame.getContentPane().add(comboTecnologia);


        JLabel lblCine = new JLabel("Cine y Series:");
        lblCine.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCine.setBounds(40, 320, 100, 20);
        frame.getContentPane().add(lblCine);

        comboCine = new JComboBox<>();
        comboCine.setModel(new DefaultComboBoxModel<>(new String[] {"Fotogramas", "FilmAffinity", "Sensacine"}));
        comboCine.setBounds(150, 320, 250, 20);
        frame.getContentPane().add(comboCine);

        // --- BOTÓN GUARDAR ---
        JButton botonGuardar = new JButton("GUARDAR PREFERENCIAS");
        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setBackground(new Color(0, 128, 0));
        botonGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
        botonGuardar.setBounds(100, 400, 300, 40);
        frame.getContentPane().add(botonGuardar);
    }
    
    private void guardarDatos() {
    	//todo lo que el user ha elegido
    	String eco = (String) comboEconomia.getSelectedItem();
        String dep = (String) comboDeportes.getSelectedItem();
        String nac = (String) comboNacional.getSelectedItem();
        String inter = (String) comboInternacional.getSelectedItem();
        String tec = (String) comboTecnologia.getSelectedItem();
        String cine = (String) comboCine.getSelectedItem();

        //lo guardamos en el txt
        datos.GestionFicheros gestor = new datos.GestionFicheros();
        gestor.guardarPreferencias(usuario, eco, dep, nac, inter, tec, cine);
        
        JOptionPane.showMessageDialog(frame, "Preferencias guardadas correctamente.");
        frame.dispose();
    }
}