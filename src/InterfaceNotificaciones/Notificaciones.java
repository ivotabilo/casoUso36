/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI; 
import java.math.BigDecimal;
/**
 *
 * @author sebac
 */
public class Notificaciones extends GestorGn /*implements NotificacionesInterface*/ {
    public final String ACCOUNT_SID = "ACc913ba7931b461bac444f3725dfb6fe7"; 
    public final String AUTH_TOKEN_WHATSAPP = ((Token) this.traerToken(Token.class, "whatsapp")).getToken(); 
    public final String AUTH_TOKEN_GMAIL = ((Token) this.traerToken(Token.class, "gmail")).getToken();
    // token vencido.. hacer que lo tome de data base para que no me lo den de baja de twilio
    
   // @Override
    public void notificacionWhatsapp(String numeroPhone, String mensaje) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN_WHATSAPP); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:"+numeroPhone), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                "Hola! \n" + mensaje)      
            .create();  
        
 
        System.out.println(message.getSid()); 
        /*System.out.println("\n");
        System.out.println(message.getSid().toString()); 
        System.out.println("\n"); 
        System.out.println(message.getMessagingServiceSid());
        System.out.println(message.getPrice());
        System.out.println(message.getStatus());
        System.out.println("xx "+message.getApiVersion());*/
    }

  //  @Override
    public void notificacionMail(String emailDestino, String mensaje) {
        Properties propiedad = new Properties();
        
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(propiedad);
        
        String emailSalida = "casodeuso36@gmail.com";
        String pass = AUTH_TOKEN_GMAIL; 
        
        String asunto = "Mantenimiento RT";
        
        MimeMessage mail = new MimeMessage(session);
        
        try {
            
            mail.setFrom(new InternetAddress(emailSalida));
            mail.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(emailDestino));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transporte = session.getTransport("smtp");
            transporte.connect(emailSalida,pass);
            transporte.sendMessage(mail, mail.getRecipients(javax.mail.Message.RecipientType.TO));
            transporte.close();
            
        } catch (Exception e) {
            System.out.println("ERROR MAIL. " + e.toString());
        }
                
    }

    public Notificaciones() {
    }
    
    
}
