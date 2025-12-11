package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Usuario;

public class GestionFicheros {

    private final String FICHERO_USUARIOS = "usuarios.txt";
    private final String FICHERO_PREFERENCIAS = "preferencias.txt";

   
    public Usuario validarUsuario(String userIngresado, String passIngresada) {
        
        File archivo = new File(FICHERO_USUARIOS);
        if (!archivo.exists()) {
            return null;
        }

        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                
                if (datos.length >= 4) {
                    String u = datos[0];
                    String p = datos[1];
                    String email = datos[2];
                    String rol = datos[3];

                    if (u.equals(userIngresado) && p.equals(passIngresada)) {
                        boolean esAdmin = rol.equalsIgnoreCase("ADMIN");
                        return new Usuario(u, p, email, esAdmin);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
    public void guardarPreferencias(Usuario usuario, String eco, String dep, String nac, String inter, String tec, String cine) {
        
        String linea = usuario.getNickname() + ";" + eco + ";" + dep + ";" + nac + ";" + inter + ";" + tec + ";" + cine;
        
        
        ArrayList<String> todasLasLineas = new ArrayList<>();
        File archivo = new File(FICHERO_PREFERENCIAS);

        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String l;
                while ((l = br.readLine()) != null) {
                    if (!l.startsWith(usuario.getNickname() + ";")) {
                        todasLasLineas.add(l);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        todasLasLineas.add(linea);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String s : todasLasLineas) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public String[] cargarPreferencias(Usuario usuario) {
        
        File archivo = new File("preferencias.txt");
        
        if (!archivo.exists()) {
            return null; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(usuario.getNickname() + ";")) {
                    String[] partes = linea.split(";");
                    
                    String[] fuentes = new String[6];
                    
                    for(int i=0; i<6; i++) {
                        if (i+1 < partes.length) {
                            fuentes[i] = partes[i+1];
                        } else {
                            fuentes[i] = "Sin selección";
                        }
                    }
                    return fuentes;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}