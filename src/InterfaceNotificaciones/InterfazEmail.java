package InterfaceNotificaciones;

import Generico.GestorGn;
import Generico.Token;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class InterfazEmail extends GestorGn implements IObserverNotificacion{
    public final String AUTH_TOKEN_GMAIL = ((Token) this.traerToken(Token.class, "gmail")).getToken();
    
    private String mensaje;
    private List<String> email = new ArrayList<>();
    
    public InterfazEmail(){
        
    }
    
    @Override
    public void notificarCientificos(List<String> email, List<String> whatsapp, String mensaje){
        this.mensaje=mensaje;
        this.email= email;
        this.enviarEmail();
    }
    
    public void enviarEmail(){
        for(int i=0;i<email.size();i++){
            Properties propiedad = new Properties();
            propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
            propiedad.setProperty("mail.smtp.starttls.enable", "true");
            propiedad.setProperty("mail.smtp.port", "587");
            propiedad.setProperty("mail.smtp.auth", "true");
            Session sesion = Session.getDefaultInstance(propiedad);
            String correoEnvia = "casodeuso36@gmail.com";
            String contrasena = AUTH_TOKEN_GMAIL;
            String receptor = email.get(i);
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
                    Logger.getLogger(InterfazEmail.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (MessagingException ex) {
                Logger.getLogger(InterfazEmail.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }   
    }
}