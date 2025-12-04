package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.io.File;
import javax.swing.JFrame;



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

		
		frame.setBounds(100, 100, 611, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setStringPainted(true);
		progressBar.setBounds(50, 350, 500, 25);
		frame.getContentPane().add(progressBar);

		JLabel lblFondo = new JLabel("");

		

	}

	public void iniciarCarga() {

		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 100; i++) {
						Thread.sleep(50);
						progressBar.setValue(i);
						
						if (i == 80) {

						}

					}

					frame.dispose();
					//login
					

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		});

	}

}
