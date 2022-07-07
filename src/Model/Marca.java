
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;


@Entity
public class Marca implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Marca_id_seq")
    @SequenceGenerator(name = "Marca_id_seq", sequenceName = "Marca_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Column(columnDefinition = "TEXT")
    private String nombre;
    @OneToMany(targetEntity = Modelo.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Modelo> modelo = new HashSet();;

    public Marca() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Set<Modelo> getModelo() {
        return modelo;
    }

    public void setModelo(Set<Modelo> modelo) {
        this.modelo = modelo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca(String nombre, String nombreModelo) {
        this.nombre = nombre;
        this.modelo.add(new Modelo(nombreModelo));
    }
    
    
}
