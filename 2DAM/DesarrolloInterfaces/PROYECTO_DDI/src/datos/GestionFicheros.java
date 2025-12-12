package datos;

import java.io.*;
import java.util.ArrayList;
import modelo.Usuario;

public class GestionFicheros {

    private final String FICHERO_USUARIOS = "usuarios.txt";
    private final String FICHERO_PREFERENCIAS = "preferencias.txt";
    private final String FICHERO_SISTEMA = "sistema.txt"; // CONFIGURACIÓN + HISTÓRICO

    // ========================================================================
    // SECCIÓN 1: CONFIGURACIÓN Y HISTÓRICO (EL TERCER FICHERO)
    // ========================================================================

    // Devuelve un array: [0]=Email, [1]=Pass, [2]=HoraEnvio, [3]=Activo(true/false)
    public String[] leerConfiguracion() {
        String[] config = new String[4];
        // Valores por defecto (Puestos por ti, el desarrollador)
        config[0] = "marcosescamilla1304@gmail.com";
        config[1] = "dfsu catc hjrm wjug";
        config[2] = "08:00"; // Hora por defecto
        config[3] = "false"; // Envío automático desactivado por defecto

        File archivo = new File(FICHERO_SISTEMA);
        if (!archivo.exists()) return config;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Solo leemos las líneas que empiezan por CONFIG;
                if (linea.startsWith("CONFIG;")) {
                    String[] partes = linea.split(";");
                    // Formato: CONFIG;Email;Pass;Hora;Activo
                    if (partes.length >= 5) {
                        config[0] = partes[1];
                        config[1] = partes[2];
                        config[2] = partes[3];
                        config[3] = partes[4];
                    }
                    break; // Solo hay una línea de configuración
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }

    public void guardarConfiguracion(String email, String pass, String hora, boolean activo) {
        // 1. Leemos el histórico existente para no perderlo
        ArrayList<String> historico = new ArrayList<>();
        File archivo = new File(FICHERO_SISTEMA);
        
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Guardamos todo lo que NO sea configuración ni URLs (es decir, el histórico)
                    if (!linea.startsWith("CONFIG;") && !linea.startsWith("URLS;")) {
                        historico.add(linea);
                    }
                }
            } catch (Exception e) { e.printStackTrace(); }
        }

        // 2. Sobrescribimos el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            
            // LÍNEA 1: CONFIGURACIÓN GENERAL
            bw.write("CONFIG;" + email + ";" + pass + ";" + hora + ";" + activo);
            bw.newLine();
            
            // LÍNEA 2: TODAS LAS URLS DEL SISTEMA (LAS 18)
            // Esto cumple el requisito de tener las URLs en el TXT
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
                "Vandal=https://vandal.elespanol.com/;" +
                "Meristation=https://as.com/meristation/;" +
                "Fotogramas=https://www.fotogramas.es/;" +
                "Espinof=https://www.espinof.com/;" +
                "Sensacine=https://www.sensacine.com/";
            
            bw.write(todasLasUrls);
            bw.newLine();

            // LÍNEA 3 EN ADELANTE: EL HISTÓRICO RECUPERADO
            for (String h : historico) {
                bw.write(h);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para añadir una línea al histórico
    public void escribirHistorico(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_SISTEMA, true))) { // true = añadir al final
            bw.write("HISTORICO;" + java.time.LocalDateTime.now() + ";" + mensaje);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ========================================================================
    // SECCIÓN 2: USUARIOS (LOGIN Y GESTIÓN) - IGUAL QUE ANTES
    // ========================================================================
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

    // ========================================================================
    // SECCIÓN 3: PREFERENCIAS - IGUAL QUE ANTES
    // ========================================================================
    public void guardarPreferencias(Usuario u, String eco, String dep, String nac, String inter, String tec, String cine) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = new File(FICHERO_PREFERENCIAS);
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (!linea.startsWith(u.getNickname() + ";")) lineas.add(linea);
                }
            } catch (Exception e) { e.printStackTrace(); }
        }
        lineas.add(u.getNickname() + ";" + eco + ";" + dep + ";" + nac + ";" + inter + ";" + tec + ";" + cine);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_PREFERENCIAS))) {
            for (String l : lineas) { bw.write(l); bw.newLine(); }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public String[] cargarPreferencias(Usuario u) {
        String[] fuentes = {"El Economista", "Marca", "El País", "The Guardian", "3DJuegos", "Fotogramas"};
        File archivo = new File(FICHERO_PREFERENCIAS);
        if (!archivo.exists()) return fuentes;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(u.getNickname() + ";")) {
                    String[] partes = linea.split(";");
                    for(int i=0; i<6; i++) fuentes[i] = (i+1 < partes.length) ? partes[i+1] : "Sin selección";
                    return fuentes;
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return fuentes;
    }
}