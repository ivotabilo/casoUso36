package Hibernate;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil  {
    public static SessionFactory sessionFactory;
    public static Session session;

    public static void inicializar() {
        try {
           Configuration conf = new Configuration(); 
           try{
               //coneccion con la base de datos
                conf.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
                conf.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");                 
                conf.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/TPIDisenio");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de Base de Datos N° 2001");
            }
            //propiedades de la base de datos
            //nombre de usuario de la db
            conf.setProperty("hibernate.connection.username","postgres");
            //contraseña
            conf.setProperty("hibernate.connection.password","7322");
            //cantidad de conecciones
            conf.setProperty("hibernate.connection.pool_size","10");
            //politica de creaccion de la base de datos
            conf.setProperty("hibernate.hbm2ddl.auto","update");
            //paquetes con persitencia
            conf.addPackage("Model");
            
            //estructura para agregar clases que necesiten persistencia
            //Ejemplo: conf.addAnnotatedClass(tpi.Model.DetalleExposicion.class);
            
            conf.addAnnotatedClass(Model.Usuario.class);
            conf.addAnnotatedClass(Model.Turno.class);
            conf.addAnnotatedClass(Model.TipoRecursoTecnologico.class);
            conf.addAnnotatedClass(Model.Sesion.class);
            conf.addAnnotatedClass(Model.RecursoTecnologico.class);
            conf.addAnnotatedClass(Model.PersonalCientifico.class);
            conf.addAnnotatedClass(Model.Marca.class);
            conf.addAnnotatedClass(Model.Mantenimiento.class);
            conf.addAnnotatedClass(Model.Estado.class);
            conf.addAnnotatedClass(Model.CambioEstadoTurno.class);
            conf.addAnnotatedClass(Model.AsignacionResponsableTecnicoRT.class);
            conf.addAnnotatedClass(Model.AsignacionCientificoDelCI.class);
            conf.addAnnotatedClass(Model.CambioEstadoRT.class);
            conf.addAnnotatedClass(Model.Modelo.class);
            conf.addAnnotatedClass(Generico.Token.class);
            
            
            try {
                    sessionFactory = conf.buildSessionFactory();
                    session=sessionFactory.openSession();
                }
                catch(HibernateException e){
                    JOptionPane.showMessageDialog(null, e);
                }
        } catch (HeadlessException | MappingException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession()
    throws HibernateException {
        return session;
    }
}