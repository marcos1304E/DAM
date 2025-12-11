package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class VentanaCarga {

	private JFrame frame;
	private JProgressBar progressBar;

	/*
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					VentanaCarga window = new VentanaCarga();
					window.frame.setVisible(true);
					window.iniciarCarga();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */

	public VentanaCarga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		//frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DAM\\eclipse-workspace\\WindowsBuilder\\src\\png-transparent-computer-icons-setting-icon-cdr-svg-setting-icon.png"));
		
		frame.setBounds(100, 100, 610, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setStringPainted(true);
		progressBar.setBounds(50, 350, 500, 25);
		frame.getContentPane().add(progressBar);

		frame.getContentPane().add(buscarImagen());
		
		
		//JLabel lblFondo = new JLabel("");/// NOTICIAS/src/Imagenes/descargaNoti.jpg
		//lblFondo.setBackground(new Color(255, 255, 255));
		//lblFondo.setIcon(new ImageIcon(VentanaCarga.class.getResource("PROYECTO_DDI/Imagenes/descargaNoti.jpg")));	
		//lblFondo.setBounds(0, 0, 594, 407);
		//frame.getContentPane().add(lblFondo);
		
		JPanel panelConFondo = new JPanel() {
			protected void paintComponent() {
				
			}
		};

	}
	
	private Component buscarImagen() {
		BufferedImage fondo = null;
		//cargar imagen
		try {
			
		fondo = ImageIO.read(new File("PROYECTO_DDI/Imagenes/descargaNoti.jpg"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//asignar la imagen a un jpanel
		final Image foto = fondo;
		JPanel panelConFondo = new JPanel() {
			
			private static final long SerialVersionUID = 1L;
			@Override
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				g.drawImage(foto,0,0,getWidth(), getHeight(),null);
			}
			
		};
		
		return panelConFondo;
	}
 
	public void iniciarCarga() {

		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i <= 100; i++) {
						Thread.sleep(40);
						progressBar.setValue(i);

						if (i == 80) {
							if (!comprobarArchivos()) {
								System.exit(0);
							}

						}

					}
					
					frame.dispose();
					iniciarLogin();
					

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		});

		hilo.start();

	}

	private boolean comprobarArchivos() {

		return true;
	}

	public void iniciarLogin() {

		Login ventanaLogin = new Login();
		ventanaLogin.frame.setVisible(true);
		System.out.println("se abre el login");

	}
}