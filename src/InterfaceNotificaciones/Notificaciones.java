/*/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
package InterfaceNotificaciones;

import Generico.GestorGn;
import Generico.Token;
//gmail
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//whatsapp
import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
/**
 *
 * @author sebac
 *
public class Notificaciones extends GestorGn{
    public final String ACCOUNT_SID = "ACc913ba7931b461bac444f3725dfb6fe7"; 
    public final String AUTH_TOKEN_WHATSAPP = ((Token) this.traerToken(Token.class, "whatsapp")).getToken(); 
    public final String AUTH_TOKEN_GMAIL = ((Token) this.traerToken(Token.class, "gmail")).getToken();
    
    /*@Override
    public void notificacionWhatsapp(String numeroPhone, String mensaje) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN_WHATSAPP); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+5493571"+numeroPhone), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                "Hola! \n" + mensaje)      
            .create();  
        
 
        System.out.println(message.getSid()); 
    }

    @Override
    public void notificacionMail(String emailDestino, String mensaje) {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "casodeuso36@gmail.com";
        String contrasena = AUTH_TOKEN_GMAIL;
        String receptor = emailDestino;
        String asunto = "Cancelacion por mantenimiento correctivo";
        MimeMessage mail = new MimeMessage(sesion);
        try {
            try {
                mail.setFrom(new InternetAddress(correoEnvia));
                mail.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress (receptor));
                mail.setSubject(asunto);
                mail.setText(mensaje);
            
                Transport transportar = sesion.getTransport("smtp");
                transportar.connect(correoEnvia,contrasena);
                transportar.sendMessage(mail, mail.getRecipients(javax.mail.Message.RecipientType.TO));          
                transportar.close();
                JOptionPane.showMessageDialog(null, "Correo Enviado");
            } catch (AddressException ex) {
                Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MessagingException ex) {
            Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Notificaciones() {
    }
}*/
