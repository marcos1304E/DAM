package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import datos.GestionFicheros;
import modelo.Usuario;

// 1. AHORA ES UN JPANEL
public class Login extends JPanel {

    private JTextField textUsuario;
    private JPasswordField fieldContraseña;
    private MenuPrincipal ventanaPrincipal;

    public Login(MenuPrincipal main) {
        this.ventanaPrincipal = main;
        setLayout(null);
        setBounds(0, 0, 800, 600); 

        JLabel lblTitulo = new JLabel("INICIO SESION");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(337, 101, 200, 20);
        add(lblTitulo);

        JLabel lblUser = new JLabel("Usuario");
        lblUser.setBounds(300, 150, 80, 14);
        add(lblUser);

        textUsuario = new JTextField();
        textUsuario.setBounds(300, 170, 200, 25);
        add(textUsuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(300, 210, 80, 14);
        add(lblPass);

        fieldContraseña = new JPasswordField();
        fieldContraseña.setBounds(300, 230, 200, 25);
        add(fieldContraseña);

        JButton btnEntrar = new JButton("ENTRAR");
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setBackground(new Color(0, 128, 128));
        btnEntrar.setBounds(330, 300, 130, 30);
        add(btnEntrar);

        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });
    }

    private void validarLogin() {
        String user = textUsuario.getText();
        String pass = new String(fieldContraseña.getPassword());

        GestionFicheros gestor = new GestionFicheros();
        Usuario usuarioLogueado = gestor.validarUsuario(user, pass);

        if (usuarioLogueado != null) {
            ventanaPrincipal.cargarPanelUsuario(usuarioLogueado);
        } else {
            JOptionPane.showMessageDialog(this, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}