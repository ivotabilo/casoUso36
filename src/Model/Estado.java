
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


public class Estado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Estado_id_seq")
    @SequenceGenerator(name = "Estado_id_seq", sequenceName = "Estado_id_seq", allocationSize = 1)
    private Integer ID;
    @Column(columnDefinition = "TEXT")
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(columnDefinition = "TEXT")
    private String ambito;
    @Column(name = "esReservable", columnDefinition = "Boolean default 'false'")
    private boolean esReservable;
    @Column(name = "esCancelable", columnDefinition = "Boolean default 'false'")
    private boolean esCancelable;
     
    public boolean esDisponible(){
        return this.nombre.equalsIgnoreCase("disponible");
    }
    /*esConfirmado
    esPendiente
    esAambitoTurno
    esCanceladoPorMantenimientoCorrectivo
    esAmbitoRT
    esConIngresoAMantenimientoCorrectivo
*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public boolean isEsReservable() {
        return esReservable;
    }

    public void setEsReservable(boolean esReservable) {
        this.esReservable = esReservable;
    }

    public boolean isEsCancelable() {
        return esCancelable;
    }

    public void setEsCancelable(boolean esCancelable) {
        this.esCancelable = esCancelable;
    }
    
}
