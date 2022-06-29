package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Sesion {
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sesion_id_seq")
    @SequenceGenerator(name = "Sesion_id_seq", sequenceName = "Sesion_id_seq", allocationSize = 1)
    private Integer ID;
    
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
