package ventanas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.Usuario;
import datos.GestionFicheros;


public class VentanaPreferencias extends JDialog {

    private Usuario usuario;
    private JComboBox<String> comboEconomia;
    private JComboBox<String> comboDeportes;
    private JComboBox<String> comboNacional;
    private JComboBox<String> comboInternacional;
    private JComboBox<String> comboVideojuegos;
    private JComboBox<String> comboCine;

    public VentanaPreferencias(JFrame parent, Usuario usuario) {
        super(parent, true); 
        this.usuario = usuario;
        
        setTitle("Preferencias - " + usuario.getNickname());
        setBounds(100, 100, 500, 450);
        setLocationRelativeTo(parent);
        getContentPane().setLayout(null);
        
        
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png")));
        } catch (Exception e) {}

        initialize();
        cargarDatosActuales();
    }

    private void initialize() {
        JLabel lblTitulo = new JLabel("ELIGE TUS FUENTES FAVORITAS");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(120, 20, 300, 20);
        getContentPane().add(lblTitulo);

        
        JLabel lblEco = new JLabel("Economía:");
        lblEco.setBounds(50, 70, 100, 14);
        getContentPane().add(lblEco);

        comboEconomia = new JComboBox<>();
        comboEconomia.setModel(new DefaultComboBoxModel<>(new String[] {"El Economista", "Expansión", "Cinco Días"}));
        comboEconomia.setBounds(150, 70, 250, 20);
        getContentPane().add(comboEconomia);

        
        JLabel lblDep = new JLabel("Deportes:");
        lblDep.setBounds(50, 120, 100, 14);
        getContentPane().add(lblDep);

        comboDeportes = new JComboBox<>();
        comboDeportes.setModel(new DefaultComboBoxModel<>(new String[] {"Marca", "As", "Mundo Deportivo"}));
        comboDeportes.setBounds(150, 120, 250, 20);
        getContentPane().add(comboDeportes);
        
        
        JLabel lblNac = new JLabel("Nacional:");
        lblNac.setBounds(50, 170, 100, 14);
        getContentPane().add(lblNac);

        comboNacional = new JComboBox<>();
        comboNacional.setModel(new DefaultComboBoxModel<>(new String[] {"El País", "El Mundo", "ABC"}));
        comboNacional.setBounds(150, 170, 250, 20);
        getContentPane().add(comboNacional);
        
        
        JLabel lblInter = new JLabel("Internacional:");
        lblInter.setBounds(50, 220, 100, 14);
        getContentPane().add(lblInter);

        comboInternacional = new JComboBox<>();
        comboInternacional.setModel(new DefaultComboBoxModel<>(new String[] {"The Guardian", "BBC News", "Le Monde"}));
        comboInternacional.setBounds(150, 220, 250, 20);
        getContentPane().add(comboInternacional);
        
        
        JLabel lblJuegos = new JLabel("Videojuegos:");
        lblJuegos.setBounds(50, 270, 100, 14);
        getContentPane().add(lblJuegos);

        comboVideojuegos = new JComboBox<>();
        comboVideojuegos.setModel(new DefaultComboBoxModel<>(new String[] {"3DJuegos", "IGN España", "Meristation"}));
        comboVideojuegos.setBounds(150, 270, 250, 20);
        getContentPane().add(comboVideojuegos);
        
        
        JLabel lblCine = new JLabel("Cine:");
        lblCine.setBounds(50, 320, 100, 14);
        getContentPane().add(lblCine);

        comboCine = new JComboBox<>();
        comboCine.setModel(new DefaultComboBoxModel<>(new String[] {"Fotogramas", "Espinof", "Sensacine"}));
        comboCine.setBounds(150, 320, 250, 20);
        getContentPane().add(comboCine);

        
        JButton btnGuardar = new JButton("GUARDAR CAMBIOS");
        btnGuardar.setBounds(150, 360, 200, 30);
        getContentPane().add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPreferencias();
            }
        });
    }
    
    private void cargarDatosActuales() {
        GestionFicheros gestor = new GestionFicheros();
        String[] guardadas = gestor.cargarPreferencias(usuario);
        
        if (guardadas != null && guardadas[0] != null) {
            comboEconomia.setSelectedItem(guardadas[0]);
            comboDeportes.setSelectedItem(guardadas[1]);
            comboNacional.setSelectedItem(guardadas[2]);
            comboInternacional.setSelectedItem(guardadas[3]);
            comboVideojuegos.setSelectedItem(guardadas[4]);
            comboCine.setSelectedItem(guardadas[5]);
        }
    }
    
    private void guardarPreferencias() {
        GestionFicheros gestor = new GestionFicheros();
        gestor.guardarPreferencias(
            usuario,
            (String) comboEconomia.getSelectedItem(),
            (String) comboDeportes.getSelectedItem(),
            (String) comboNacional.getSelectedItem(),
            (String) comboInternacional.getSelectedItem(),
            (String) comboVideojuegos.getSelectedItem(),
            (String) comboCine.getSelectedItem()
        );
        
        JOptionPane.showMessageDialog(this, "Preferencias guardadas correctamente.");
        dispose(); 
    }
}