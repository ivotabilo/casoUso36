package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Sesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sesion_id_seq")
    @SequenceGenerator(name = "Sesion_id_seq", sequenceName = "Sesion_id_seq", allocationSize = 1)
    private Integer ID;
    @ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String buscarUsuario(){    
        return this.usuario.getNombre(); //invoca el metodo getNombre para obtener el nombre del usuario logeado
    }
    
}
