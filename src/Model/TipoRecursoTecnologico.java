
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoRecursoTecnologico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoRecursoTecnologico_id_seq")
    @SequenceGenerator(name = "TipoRecursoTecnologico_id_seq", sequenceName = "TipoRecursoTecnologico_id_seq", allocationSize = 1)
    private Integer ID;
    @Column(columnDefinition = "TEXT")
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNomre(String nomre) {
        this.nombre = nomre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
