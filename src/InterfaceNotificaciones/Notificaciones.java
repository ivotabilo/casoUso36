/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceNotificaciones;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message; 

/**
 *
 * @author sebac
 */
public class Notificaciones implements NotificacionesInterface{
    public static final String ACCOUNT_SID = "ACc913ba7931b461bac444f3725dfb6fe7"; 
    public static final String AUTH_TOKEN = "7b95d6491ac3d2f430276ed9a79ef271"; 
    // token vencido.. hacer que lo tome de data base para que no me lo den de baja de twilio
    
    @Override
    public void notificacionWhatsapp(String numeroPhone, String mensaje) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:"+numeroPhone), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                "Hola! \n" + mensaje)      
            .create();  
        
 
        System.out.println(message.getSid()); 
        System.out.println("\n");
        
    }

    @Override
    public void notificacionMail(String mail, String mensaje) {
        
        
        
    }
    
}
