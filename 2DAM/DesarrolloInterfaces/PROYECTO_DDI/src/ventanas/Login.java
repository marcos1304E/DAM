package ventanas;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.GestionFicheros;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Login {

	public JFrame frame;
	private JTextField textUsuario;
	private JPasswordField fieldContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login ventanaLogin = new Login();
					ventanaLogin.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 438, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("INICIO SESION");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(148, 24, 200, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(50, 80, 80, 14);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblUser);

		textUsuario = new JTextField("");
		textUsuario.setBounds(50, 100, 91, 20);
		frame.getContentPane().add(textUsuario);

		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setBounds(50, 140, 80, 14);
		frame.getContentPane().add(lblPass);

		fieldContraseña = new JPasswordField();
		fieldContraseña.setBounds(50, 163, 91, 20);
		fieldContraseña.setEchoChar('*');
		frame.getContentPane().add(fieldContraseña);

		JCheckBox chckbxVerPass = new JCheckBox("Ver Contraseña");
		chckbxVerPass.setBounds(142, 162, 132, 23);
		frame.getContentPane().add(chckbxVerPass);

		chckbxVerPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxVerPass.isSelected()) {
					fieldContraseña.setEchoChar((char) 0);
				} else {
					fieldContraseña.setEchoChar('*');
				}

			}
		});

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(0, 128, 128));
		btnEntrar.setBounds(150, 240, 130, 30);
		frame.getContentPane().add(btnEntrar);

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarLogin();
			}
		});
	}

	private void validarLogin() {
		String user = textUsuario.getText();
		String pass = new String(fieldContraseña.getPassword());

		if (user.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Por favor, rellena todos los campos.");
			return;
		}

		GestionFicheros gestor = new GestionFicheros();

		modelo.Usuario usuarioLogueado = gestor.validarUsuario(user, pass);

		if (usuarioLogueado != null) {
			frame.dispose();

			MenuPrincipal menu = new MenuPrincipal(usuarioLogueado);
			menu.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}