package datos;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestionCorreo {

    private final String REMITENTE = "marcosescamilla1304@gmail.com"; 
    private final String PASSWORD = "dfsu catc hjrm wjug"; 

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, PASSWORD);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(REMITENTE));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            System.out.println("Enviando correo a " + destinatario);
            Transport.send(mensaje);
            System.out.println("¡Correo enviado con éxito!");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void enviarNoticia(String destinatario, String categoria, String titular) {
        
        String asunto = "NOTICIAS DAM";

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaActual = ahora.format(formato);


        String cuerpo = "FECHA/HORA: " + fechaActual + "\n" +
                        "CATEGORÍA: " + categoria + "\n" + titular; // Añadimos el tick y espacio

        enviarCorreo(destinatario, asunto, cuerpo);
    }
}