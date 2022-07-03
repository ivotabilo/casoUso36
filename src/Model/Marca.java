
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


public class Marca implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Marca_id_seq")
    @SequenceGenerator(name = "Marca_id_seq", sequenceName = "Marca_id_seq", allocationSize = 1)
    private Integer ID;
    @OneToMany(targetEntity = CambioEstadoTurno.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Modelo modelo;
    @Column(columnDefinition = "TEXT")
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
