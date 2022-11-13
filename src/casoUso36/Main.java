package casoUso36;
import Model.Login.GestorLogin;
import Hibernate.HibernateUtil;

public class Main {
   public static void main(String[] args) {
       HibernateUtil.inicializar();
       GestorLogin gl = new GestorLogin();
       gl.open();
    }
}