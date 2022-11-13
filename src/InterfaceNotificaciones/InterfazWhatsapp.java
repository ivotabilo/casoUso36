package InterfaceNotificaciones;

import Generico.GestorGn;
import Generico.Token;
import java.util.List;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class InterfazWhatsapp extends GestorGn implements IObserverNotificacion{
    public final String ACCOUNT_SID = "ACc913ba7931b461bac444f3725dfb6fe7"; 
    public final String AUTH_TOKEN_WHATSAPP = ((Token) this.traerToken(Token.class, "whatsapp")).getToken(); 
    
    private String mensaje;
    private List<String> whatsapp;
    
    @Override
    public void notificarCientificos(List<String> email, List<String> whatsapp, String mensaje){
        this.mensaje=mensaje;
        this.whatsapp= whatsapp;
        this.enviarWhatsapp();
    }
    
    public void enviarWhatsapp(){
        for(int i=0;i>whatsapp.size();i++){
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN_WHATSAPP); 
            Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+5493571"+whatsapp.get(i)), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                "Hola! \n" + mensaje).create();  
            System.out.println(message.getSid()); 
        }
    }    
}