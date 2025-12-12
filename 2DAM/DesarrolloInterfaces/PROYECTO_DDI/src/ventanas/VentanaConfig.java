package ventanas;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import datos.GestionFicheros;

public class VentanaConfig extends JDialog {

    private JTextField txtEmail;
    private JTextField txtPass;
    private JTextField txtHora; 
    private JCheckBox chkActivarEnvio;

    private final String HORA_EMAIL = "08:00"; 

    public VentanaConfig() {
        setTitle("Configuración del Sistema");
        setBounds(100, 100, 500, 400);
        setModal(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Cargamos los datos que ya existan en el fichero
        GestionFicheros gestor = new GestionFicheros();
        String[] config = gestor.leerConfiguracion();
        // config[0]=Email, [1]=Pass, [2]=Hora, [3]=Activo

        JLabel lblTitulo = new JLabel("CONFIGURACIÓN DE ENVÍO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(130, 20, 300, 20);
        getContentPane().add(lblTitulo);

        // --- EMAIL DE SALIDA ---
        JLabel lblEmail = new JLabel("Email de Salida (Gmail):");
        lblEmail.setBounds(50, 70, 200, 14);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField(config[0]); // Carga lo que hubiera guardado
        txtEmail.setBounds(50, 90, 300, 20);
        getContentPane().add(txtEmail);

        // --- CONTRASEÑA APP ---
        JLabel lblPass = new JLabel("Contraseña de Aplicación:");
        lblPass.setBounds(50, 130, 200, 14);
        getContentPane().add(lblPass);

        txtPass = new JTextField(config[1]);
        txtPass.setBounds(50, 150, 300, 20);
        getContentPane().add(txtPass);

        // --- HORA DE ENVÍO (BLOQUEADA) ---
        JLabel lblHora = new JLabel("Hora de Envío:");
        lblHora.setBounds(50, 190, 250, 14);
        getContentPane().add(lblHora);

        txtHora = new JTextField(HORA_EMAIL); 
        txtHora.setBounds(50, 210, 100, 20);
        txtHora.setEditable(false); // <--- ESTO IMPIDE QUE EL ADMIN LA CAMBIE
        txtHora.setBackground(Color.LIGHT_GRAY); // Color gris para indicar que está bloqueada
        getContentPane().add(txtHora);

        // --- ACTIVAR ENVÍO ---
        chkActivarEnvio = new JCheckBox("ACTIVAR ENVÍO AUTOMÁTICO DIARIO");
        chkActivarEnvio.setBounds(50, 250, 300, 23);
        // Cargamos si estaba activo o no del fichero
        chkActivarEnvio.setSelected(Boolean.parseBoolean(config[3]));
        getContentPane().add(chkActivarEnvio);

        // --- BOTÓN GUARDAR ---
        JButton btnGuardar = new JButton("GUARDAR CONFIGURACIÓN");
        btnGuardar.setBackground(Color.ORANGE);
        btnGuardar.setBounds(100, 300, 250, 40);
        getContentPane().add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Al guardar, usamos la HORA_DEL_DESARROLLADOR, asegurándonos de que
                // en el fichero txt siempre se escriba tu hora, no otra.
                gestor.guardarConfiguracion(
                    txtEmail.getText(),
                    txtPass.getText(),
                    HORA_EMAIL, 
                    chkActivarEnvio.isSelected()
                );
                
                JOptionPane.showMessageDialog(null, "Configuración guardada correctamente.");
                dispose();
            }
        });
    }
}