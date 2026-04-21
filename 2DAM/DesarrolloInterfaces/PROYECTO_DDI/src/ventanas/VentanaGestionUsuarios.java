package ventanas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.Font;
import modelo.Usuario;
import datos.GestionFicheros;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;



public class VentanaGestionUsuarios extends JDialog {

    private JTextField txtNick;
    private JTextField txtPass;
    private JTextField txtEmail;
    
    private DefaultListModel<String> modeloLista;
    private JList<String> listaVisual;
    private ArrayList<Usuario> listaUsuarios; 
    
    private final String[] INTOCABLES = {"admin", "usuario1", "usuario2", "usuario3"};

    public VentanaGestionUsuarios(JFrame parent) {
        super(parent, true);
        setTitle("Gestión de Usuarios (Admin)");
        setBounds(100, 100, 600, 450);
        setLocationRelativeTo(parent);
        getContentPane().setLayout(null);
        getContentPane().setBackground(MenuPrincipal.COLOR_FONDO);
        
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png")));
        } catch (Exception e) {}

        cargarUsuarios();

        JLabel lblTitulo = new JLabel("CONTROL DE USUARIOS");
        lblTitulo.setFont(MenuPrincipal.FUENTE_TITULO);
        lblTitulo.setForeground(MenuPrincipal.COLOR_PRIMARIO);
        lblTitulo.setBounds(20, 20, 300, 25);
        getContentPane().add(lblTitulo);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 250, 300);
        getContentPane().add(scrollPane);
        
        modeloLista = new DefaultListModel<>();
        for (Usuario u : listaUsuarios) {
            modeloLista.addElement(u.getNickname() + " (" + u.getEmail() + ")");
        }
        
        listaVisual = new JList<>(modeloLista);
        scrollPane.setViewportView(listaVisual);
        
        JButton btnBorrar = new JButton("BORRAR SELECCIONADO");
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setBackground(new Color(192, 57, 43));
        btnBorrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnBorrar.setBounds(20, 370, 250, 30);
        getContentPane().add(btnBorrar);
        
        
        JLabel lblNuevo = new JLabel("NUEVO USUARIO:");
        lblNuevo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNuevo.setBounds(300, 60, 200, 20);
        getContentPane().add(lblNuevo);
        
        JLabel lblNick = new JLabel("Nickname:");
        lblNick.setBounds(300, 90, 100, 14);
        getContentPane().add(lblNick);
        
        txtNick = new JTextField();
        txtNick.setBounds(300, 110, 250, 25);
        getContentPane().add(txtNick);
        
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(300, 150, 100, 14);
        getContentPane().add(lblPass);
        
        txtPass = new JTextField();
        txtPass.setBounds(300, 170, 250, 25);
        getContentPane().add(txtPass);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(300, 210, 100, 14);
        getContentPane().add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(300, 230, 250, 25);
        getContentPane().add(txtEmail);
        
        JButton btnCrear = new JButton("CREAR USUARIO");
        btnCrear.setForeground(Color.WHITE);
        btnCrear.setBackground(new Color(46, 204, 113));
        btnCrear.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCrear.setBounds(300, 280, 250, 40);
        getContentPane().add(btnCrear);
        
        JLabel lblInfo = new JLabel("Límite: Máx 10 usuarios.");
        lblInfo.setForeground(Color.GRAY);
        lblInfo.setBounds(300, 330, 200, 20);
        getContentPane().add(lblInfo);
        

        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = listaVisual.getSelectedIndex();
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "Selecciona un usuario de la lista.");
                    return;
                }
                
                Usuario seleccionado = listaUsuarios.get(index);
                String nick = seleccionado.getNickname();
                
                for (String protegido : INTOCABLES) {
                    if (nick.equalsIgnoreCase(protegido)) {
                        JOptionPane.showMessageDialog(null, "¡ERROR! El usuario '" + nick + "' es fundamental y no se puede borrar.");
                        return;
                    }
                }
                
                int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrar a " + nick + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    listaUsuarios.remove(index);
                    modeloLista.remove(index);
                    guardarCambios();
                }
            }
        });
        

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaUsuarios.size() >= 10) {
                    JOptionPane.showMessageDialog(null, "¡LÍMITE ALCANZADO! No caben más de 10 usuarios.");
                    return;
                }
                
                String nick = txtNick.getText();
                String pass = txtPass.getText();
                String mail = txtEmail.getText();
                
                
                if (nick.contains(";") || pass.contains(";") || mail.contains(";")) {
                    JOptionPane.showMessageDialog(null, 
                        "ERROR DE FORMATO:\nNo puedes usar el carácter ';' (punto y coma).\nEs un carácter reservado del sistema.", 
                        "Carácter Prohibido", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                

                if (nick.trim().isEmpty() || pass.trim().isEmpty() || mail.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.");
                    return;
                }
                

                for (Usuario u : listaUsuarios) {
                    if (u.getNickname().equalsIgnoreCase(nick)) {
                        JOptionPane.showMessageDialog(null, "El usuario '" + nick + "' ya existe.");
                        return;
                    }
                }
                

                Usuario nuevo = new Usuario(nick, pass, mail, false);
                listaUsuarios.add(nuevo);
                modeloLista.addElement(nuevo.getNickname() + " (" + nuevo.getEmail() + ")");
                
                txtNick.setText("");
                txtPass.setText("");
                txtEmail.setText("");
                guardarCambios();
                JOptionPane.showMessageDialog(null, "Usuario creado correctamente.");
            }
        });
    }

    private void cargarUsuarios() {
        GestionFicheros gestor = new GestionFicheros();
        listaUsuarios = gestor.leerUsuarios(); 
        if (listaUsuarios == null) listaUsuarios = new ArrayList<>();
    }
    
    private void guardarCambios() {
        GestionFicheros gestor = new GestionFicheros();
        gestor.guardarUsuarios(listaUsuarios);
    }
}