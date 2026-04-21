package ventanas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import datos.GestionFicheros;

public class VentanaConfig extends JDialog {

    private JTextField txtEmail;
    private JTextField txtPass;
    private JTextField txtHora; 
    private JCheckBox chkActivarEnvio;

    private final String HORA_DEL_DESARROLLADOR = "08:00"; 

    public VentanaConfig(JFrame parent) {
        super(parent, true); 
        setTitle("Configuración del Sistema");
        setBounds(100, 100, 500, 400);
        setLocationRelativeTo(parent);
        getContentPane().setLayout(null);
        
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.png")));
        } catch (Exception e) {}

        GestionFicheros gestor = new GestionFicheros();
        String[] config = gestor.leerConfiguracion();

        JLabel lblTitulo = new JLabel("CONFIGURACIÓN DE ENVÍO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(130, 20, 300, 20);
        getContentPane().add(lblTitulo);

        JLabel lblEmail = new JLabel("Email de Salida (Gmail):");
        lblEmail.setBounds(50, 70, 200, 14);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField(config[0]);
        txtEmail.setBounds(50, 90, 300, 20);
        getContentPane().add(txtEmail);

        JLabel lblPass = new JLabel("Contraseña de Aplicación:");
        lblPass.setBounds(50, 130, 200, 14);
        getContentPane().add(lblPass);

        txtPass = new JTextField(config[1]);
        txtPass.setBounds(50, 150, 300, 20);
        getContentPane().add(txtPass);

        JLabel lblHora = new JLabel("Hora de Envío (Fijada por Sistema):");
        lblHora.setBounds(50, 190, 250, 14);
        getContentPane().add(lblHora);

        txtHora = new JTextField(HORA_DEL_DESARROLLADOR); 
        txtHora.setBounds(50, 210, 100, 20);
        txtHora.setEditable(false); 
        txtHora.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(txtHora);

        chkActivarEnvio = new JCheckBox("ACTIVAR ENVÍO AUTOMÁTICO DIARIO");
        chkActivarEnvio.setBounds(50, 250, 300, 23);
        chkActivarEnvio.setSelected(Boolean.parseBoolean(config[3]));
        getContentPane().add(chkActivarEnvio);

        JButton btnGuardar = new JButton("GUARDAR CONFIGURACIÓN");
        btnGuardar.setBackground(Color.ORANGE);
        btnGuardar.setBounds(100, 300, 250, 40);
        getContentPane().add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestor.guardarConfiguracion(
                    txtEmail.getText(),
                    txtPass.getText(),
                    HORA_DEL_DESARROLLADOR, 
                    chkActivarEnvio.isSelected()
                );
                JOptionPane.showMessageDialog(null, "Configuración guardada en sistema.txt");
                dispose();
            }
        });
    }
}