
package Model;

import InterfaceNotificaciones.Notificaciones;


public class InterfazEmail {
    
    public void notificarCientifico(String emailDestino, String mensaje){
        Notificaciones n = new Notificaciones();
        n.notificacionMail(emailDestino, mensaje);
    }
}
