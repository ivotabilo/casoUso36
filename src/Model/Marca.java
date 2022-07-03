
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;



public class Marca implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Marca_id_seq")
    @SequenceGenerator(name = "Marca_id_seq", sequenceName = "Marca_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Column(columnDefinition = "TEXT")
    private String nombre;
    private ArrayList<Modelo> modelo;
    
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
