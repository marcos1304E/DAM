package datos;

import java.io.*;
import java.util.ArrayList;
import modelo.Usuario;

public class GestionFicheros {

    private final String FICHERO_USUARIOS = "usuarios.txt";
    private final String FICHERO_SISTEMA = "sistema.txt";
    private final String FICHERO_HISTORICO = "historico.txt";

    
    

    public void guardarConfiguracion(String email, String pass, String hora, boolean activo) {
        ArrayList<String> lineasPreferencias = new ArrayList<>();
        
        File archivo = new File(FICHERO_SISTEMA);
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("PREF;")) {
                        lineasPreferencias.add(linea);
                    }
                }
            } catch (Exception e) { e.printStackTrace(); }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            
            bw.write("CONFIG;" + email + ";" + pass + ";" + hora + ";" + activo);
            bw.newLine();
            
            String todasLasUrls = "URLS;" +
                "El Economista=https://www.eleconomista.es/;" +
                "Expansión=https://www.expansion.com/;" +
                "Cinco Días=https://cincodias.elpais.com/;" +
                "Marca=https://www.marca.com/;" +
                "As=https://as.com/;" +
                "Mundo Deportivo=https://www.mundodeportivo.com/;" +
                "El País=https://elpais.com/;" +
                "El Mundo=https://www.elmundo.es/;" +
                "ABC=https://www.abc.es/;" +
                "The Guardian=https://www.theguardian.com/international;" +
                "BBC News=https://www.bbc.com/news;" +
                "Le Monde=https://www.lemonde.fr/;" +
                "3DJuegos=https://www.3djuegos.com/;" +
                "IGN España=https://es.ign.com/;" +
                "Meristation=https://as.com/meristation/;" +
                "Fotogramas=https://www.fotogramas.es/;" +
                "Espinof=https://www.espinof.com/;" +
                "Sensacine=https://www.sensacine.com/";
            
            bw.write(todasLasUrls);
            bw.newLine();

            for (String pref : lineasPreferencias) {
                bw.write(pref);
                bw.newLine();
            }

        } catch (Exception e) { e.printStackTrace(); }
    }

    public String[] leerConfiguracion() {
        String[] config = new String[4];
        config[0] = "marcosescamilla1304@gmail.com";
        config[1] = "dfsu catc hjrm wjug";
        config[2] = "08:00"; 
        config[3] = "false"; 

        File archivo = new File(FICHERO_SISTEMA);
        if (!archivo.exists()) return config;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("CONFIG;")) {
                    String[] partes = linea.split(";");
                    if (partes.length >= 5) {
                        config[0] = partes[1];
                        config[1] = partes[2];
                        config[2] = partes[3];
                        config[3] = partes[4];
                    }
                    break; 
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return config;
    }

    public void guardarPreferencias(Usuario u, String eco, String dep, String nac, String inter, String tec, String cine) {
        ArrayList<String> todoElFichero = new ArrayList<>();
        File archivo = new File(FICHERO_SISTEMA);
        
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("CONFIG;") || linea.startsWith("URLS;")) {
                        todoElFichero.add(linea);
                    } 
                    else if (linea.startsWith("PREF;") && !linea.startsWith("PREF;" + u.getNickname() + ";")) {
                        todoElFichero.add(linea);
                    }
                }
            } catch (Exception e) { e.printStackTrace(); }
        }

        String nuevaPref = "PREF;" + u.getNickname() + ";" + eco + ";" + dep + ";" + nac + ";" + inter + ";" + tec + ";" + cine;
        todoElFichero.add(nuevaPref);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String l : todoElFichero) {
                bw.write(l);
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public String[] cargarPreferencias(Usuario u) {
        // Inicializamos con "Sin selección" por seguridad
        String[] fuentes = {"Sin selección", "Sin selección", "Sin selección", "Sin selección", "Sin selección", "Sin selección"};
        
        File archivo = new File(FICHERO_SISTEMA); 
        if (!archivo.exists()) return fuentes;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("PREF;" + u.getNickname() + ";")) {
                    String[] partes = linea.split(";");
                    for(int i=0; i<6; i++) {
                        if (i+2 < partes.length) {
                            fuentes[i] = partes[i+2];
                        }
                    }
                    return fuentes;
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return fuentes;
    }

    public boolean tienePreferencias(Usuario u) {
        File archivo = new File(FICHERO_SISTEMA);
        if (!archivo.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("PREF;" + u.getNickname() + ";")) {
                    return true;
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    

    public void escribirHistorico(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_HISTORICO, true))) { 
            bw.write("HISTORICO;" + java.time.LocalDateTime.now() + ";" + mensaje);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> leerHistoricoUsuario(Usuario u) {
        ArrayList<String> historial = new ArrayList<>();
        File archivo = new File(FICHERO_HISTORICO);

        if (!archivo.exists()) return historial;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 3) {
                    String mensaje = partes[2];
                    if (mensaje.contains(u.getNickname())) {
                        String fechaBonita = partes[1].replace("T", " ").substring(0, 19);
                        historial.add("[" + fechaBonita + "] " + mensaje);
                    }
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return historial;
    }



    
    public Usuario validarUsuario(String nick, String pass) {
        ArrayList<Usuario> lista = leerUsuarios();
        for (Usuario u : lista) {
            if (u.getNickname().equals(nick) && u.getPassword().equals(pass)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Usuario> leerUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        File archivo = new File(FICHERO_USUARIOS);
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length >= 4) {
                    boolean isAdmin = Boolean.parseBoolean(partes[3].trim());
                    lista.add(new Usuario(partes[0].trim(), partes[1].trim(), partes[2].trim(), isAdmin));
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    public void guardarUsuarios(ArrayList<Usuario> listaUsuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_USUARIOS))) {
            for (Usuario u : listaUsuarios) {
                bw.write(u.getNickname() + ";" + u.getPassword() + ";" + u.getEmail() + ";" + u.isAdmin());
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}