package ventanas;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import modelo.Usuario;
import datos.GestionFicheros; // Asumo que tienes esto para guardar en TXT

public class VentanaGestionUsuarios extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNick;
    private JTextField txtPass;
    private JTextField txtEmail;
    
    // Modelo para la lista visual
    private DefaultListModel<String> modeloLista;
    private JList<String> listaVisual;
    
    // Lista real de objetos Usuario en memoria
    private ArrayList<Usuario> listaUsuarios; 
    
    // --- REGLA: USUARIOS INTOCABLES ---
    // Pon aquí los nicks EXACTOS de los que NO se pueden borrar
    private final String[] INTOCABLES = {"admin", "usuario1", "usuario2", "usuario3"};

    /**
     * Constructor
     */
    public VentanaGestionUsuarios() {
        setTitle("Gestión de Usuarios (Admin)");
        setBounds(100, 100, 600, 450);
        setModal(true); // Bloquea la ventana de atrás hasta que cierres esta
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Cargar usuarios del fichero al iniciar
        cargarUsuarios();

        // --- INTERFAZ ---
        JLabel lblTitulo = new JLabel("CONTROL DE USUARIOS");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(20, 20, 300, 20);
        getContentPane().add(lblTitulo);
        
        // --- PARTE IZQUIERDA: LISTA DE USUARIOS ---
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 250, 300);
        getContentPane().add(scrollPane);
        
        modeloLista = new DefaultListModel<>();
        // Llenamos el modelo visual con los nombres de la lista real
        for (Usuario u : listaUsuarios) {
            modeloLista.addElement(u.getNickname() + " (" + u.getEmail() + ")");
        }
        
        listaVisual = new JList<>(modeloLista);
        scrollPane.setViewportView(listaVisual);
        
        // Botón Borrar debajo de la lista
        JButton btnBorrar = new JButton("Borrar Seleccionado");
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setBackground(Color.RED);
        btnBorrar.setBounds(20, 370, 250, 30);
        getContentPane().add(btnBorrar);
        
        // --- PARTE DERECHA: CREAR NUEVO ---
        JLabel lblNuevo = new JLabel("NUEVO USUARIO:");
        lblNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNuevo.setBounds(300, 60, 200, 20);
        getContentPane().add(lblNuevo);
        
        JLabel lblNick = new JLabel("Nickname:");
        lblNick.setBounds(300, 90, 100, 14);
        getContentPane().add(lblNick);
        
        txtNick = new JTextField();
        txtNick.setBounds(300, 110, 250, 20);
        getContentPane().add(txtNick);
        
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(300, 140, 100, 14);
        getContentPane().add(lblPass);
        
        txtPass = new JTextField();
        txtPass.setBounds(300, 160, 250, 20);
        getContentPane().add(txtPass);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(300, 190, 100, 14);
        getContentPane().add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(300, 210, 250, 20);
        getContentPane().add(txtEmail);
        
        JButton btnCrear = new JButton("Crear Usuario");
        btnCrear.setForeground(Color.BLACK);
        btnCrear.setBackground(Color.CYAN);
        btnCrear.setBounds(300, 250, 250, 30);
        getContentPane().add(btnCrear);
        
        // Etiquetas de info
        JLabel lblInfo = new JLabel("Límite: Máx 10 usuarios.");
        lblInfo.setForeground(Color.GRAY);
        lblInfo.setBounds(300, 300, 200, 20);
        getContentPane().add(lblInfo);
        
        // --- LÓGICA DE LOS BOTONES ---
        
        // 1. LÓGICA DE BORRAR
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = listaVisual.getSelectedIndex();
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "Selecciona un usuario de la lista.");
                    return;
                }
                
                Usuario seleccionado = listaUsuarios.get(index);
                String nick = seleccionado.getNickname();
                
                // REGLA: NO BORRAR A LOS INTOCABLES
                for (String protegido : INTOCABLES) {
                    if (nick.equalsIgnoreCase(protegido)) {
                        JOptionPane.showMessageDialog(null, "¡ERROR! No puedes borrar al usuario protegido: " + nick);
                        return;
                    }
                }
                
                // Confirmación
                int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrar a " + nick + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    listaUsuarios.remove(index); // Borrar de la lista real
                    modeloLista.remove(index);   // Borrar de la pantalla
                    guardarCambios();            // Guardar en fichero
                }
            }
        });
        
        // 2. LÓGICA DE CREAR
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // REGLA: MÁXIMO 10
                if (listaUsuarios.size() >= 10) {
                    JOptionPane.showMessageDialog(null, "¡LÍMITE ALCANZADO! Ya hay 10 usuarios. Borra uno antes de crear otro.");
                    return;
                }
                
                String nick = txtNick.getText();
                String pass = txtPass.getText();
                String mail = txtEmail.getText();
                
                if (nick.isEmpty() || pass.isEmpty() || mail.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
                    return;
                }
                
                // Comprobar que no exista ya el nick
                for (Usuario u : listaUsuarios) {
                    if (u.getNickname().equalsIgnoreCase(nick)) {
                        JOptionPane.showMessageDialog(null, "El usuario " + nick + " ya existe.");
                        return;
                    }
                }
                
                // Crear y añadir (Por defecto NO son admin)
                Usuario nuevo = new Usuario(nick, pass, mail, false);
                listaUsuarios.add(nuevo);
                modeloLista.addElement(nuevo.getNickname() + " (" + nuevo.getEmail() + ")");
                
                // Limpiar campos y guardar
                txtNick.setText("");
                txtPass.setText("");
                txtEmail.setText("");
                guardarCambios();
                
                JOptionPane.showMessageDialog(null, "Usuario creado con éxito.");
            }
        });
    }

    // --- MÉTODOS DE FICHEROS ---
    
    private void cargarUsuarios() {
        GestionFicheros gestor = new GestionFicheros();
        // Asumimos que tienes un método que devuelve ArrayList<Usuario>
        // Si no lo tienes, deberás crearlo en GestionFicheros
        listaUsuarios = gestor.leerUsuarios(); 
        
        // Si falla o está vacío, iniciamos lista nueva para que no de error
        if (listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
        }
    }
    
    private void guardarCambios() {
        GestionFicheros gestor = new GestionFicheros();
        // Asumimos que tienes un método para guardar el ArrayList completo
        gestor.guardarUsuarios(listaUsuarios);
    }
}