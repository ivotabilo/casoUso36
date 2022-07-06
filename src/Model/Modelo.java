package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Modelo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Modelo_id_seq")
    @SequenceGenerator(name = "Modelo_id_seq", sequenceName = "Modelo_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Column(columnDefinition = "TEXT")
    private String nombre;
    
    @ManyToOne(targetEntity = Marca.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Marca marca;

    public Modelo() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Modelo(String nombre) {
        this.nombre = nombre;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString() {
        return this.getNombre();
    }
    
}
