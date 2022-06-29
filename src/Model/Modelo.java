package Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Modelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Modelo_id_seq")
    @SequenceGenerator(name = "Modelo_id_seq", sequenceName = "Modelo_id_seq", allocationSize = 1)
    private Integer ID;

    private String nombre;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
