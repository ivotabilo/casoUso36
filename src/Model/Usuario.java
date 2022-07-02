package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuario_id_seq")
    @SequenceGenerator(name = "Usuario_id_seq", sequenceName = "Usuario_id_seq", allocationSize = 1)
    private Integer ID;
    @Column(name = "nombre",columnDefinition = "TEXT")
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String contrasenia;
    @Column(name = "habilitado", columnDefinition = "Boolean default 'true'")
    private boolean habilitado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
