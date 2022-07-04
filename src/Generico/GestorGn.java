package Generico;

import Hibernate.GestorHibernate;
import static Hibernate.HibernateUtil.getSession;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GestorGn extends GestorHibernate {
    
    
    public List listar(Class clase,String cadena,int max){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max);
            if (!cadena.contentEquals("")) {
                crit.add (Restrictions.like("nombre",cadena+"%"));
            }   
        return crit.list();
    }
    
    public List listarProductos(Class clase,String cadena,int max,Object objeto){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("comercio",objeto));
            if (!cadena.contentEquals("")) {
                crit.add (Restrictions.like("nombre",cadena+"%"));
            }   
        return crit.list();
    }
    
    public boolean buscarProductosPedido(Class clase,int max,Object comercio){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("comercio",comercio));  
        return !crit.list().isEmpty();
    }
     
    public Object traerObjeto(Class clase){   
       Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(1);  
        return crit.list().get(0);
    }
    
    public Object traerObjeto(Class clase,String cadena,int max){   
       Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("nombre",cadena));  
        return crit.list().get(0);
    }
    
    public boolean buscarObjeto(Class clase,String cadena,int max){   
       Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("estado",true)).setMaxResults(max).add (Restrictions.eq("nombre",cadena));  
        return !crit.list().isEmpty();
    }
    
    public Object traerUsuario(Class clase,String cadena,int max){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add (Restrictions.eq("habilitado",true)).setMaxResults(max).add(Restrictions.eq("nombre", cadena));  
        return crit.list().get(0);
    }
    
    public boolean buscarUsuario(Class clase,String cadena){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.asc("id"))
            .add (Restrictions.eq("habilitado",true)).add (Restrictions.eq("nombre",cadena)) ;
        return !crit.list().isEmpty();
    }
    
    
    public Object traerToken(Class clase,String cadena){   
        Criteria crit = getSession().createCriteria(clase).addOrder(Order.desc("id"))
            .add(Restrictions.eq("nombre", cadena));  
        return crit.list().get(0);
    }
    
}