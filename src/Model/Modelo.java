package Model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Modelo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Modelo_id_seq")
    @SequenceGenerator(name = "Modelo_id_seq", sequenceName = "Modelo_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Column(columnDefinition = "TEXT")
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
