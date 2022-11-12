package casoUso36;
import Model.Login.GestorLogin;
import Hibernate.HibernateUtil;
import InterfaceNotificaciones.*;
/**
 *
 * @author Juan
 */
public class Main {
   public static void main(String[] args) {
        HibernateUtil.inicializar();
        GestorLogin gl = new GestorLogin();
        gl.open();
        Notificaciones n = new Notificaciones();
        //n.notificacionMail("nicolasarieldurelli@gmail.com","asdasdasda");
    }
}