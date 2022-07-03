package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CambioEstadoRT implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CambioEstadoRT_id_seq")
    @SequenceGenerator(name = "CambioEstadoRT_id_seq", sequenceName = "CambioEstadoRT_id_seq", allocationSize = 1)
    private Integer ID;
    
    private Date fechaDesde;
    private Date fechaHasta;
    @ManyToOne(targetEntity = Estado.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    public void conocerActual(){
        this.estado.esDisponible();
    }
    //new
}
