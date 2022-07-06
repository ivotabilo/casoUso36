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
import javax.persistence.Temporal;

@Entity
public class CambioEstadoTurno implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CambioEstadoTurno_id_seq")
    @SequenceGenerator(name = "CambioEstadoTurno_id_seq", sequenceName = "CambioEstadoTurno_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHoraDesde;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHoraHasta;
    @ManyToOne(targetEntity = Estado.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Estado estado;

    public CambioEstadoTurno() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaHoraDesde() {
        return fechaHoraDesde;
    }

    public void setFechaHoraDesde(Date fechaHoraDesde) {
        this.fechaHoraDesde = fechaHoraDesde;
    }

    public Date getFechaHoraHasta() {
        return fechaHoraHasta;
    }

    public void setFechaHoraHasta(Date fechaHoraHasta) {
        this.fechaHoraHasta = fechaHoraHasta;
    }
    
    public boolean esConfirmado(){
        return this.estado.esConfirmado();
    }
    
    public boolean esPendienteConf(){
        return this.estado.esPendienteConf();
    }
    //new
}
