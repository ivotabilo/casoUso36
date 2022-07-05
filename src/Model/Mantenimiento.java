package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
@Entity
public class Mantenimiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Mantenimiento_id_seq")
    @SequenceGenerator(name = "Mantenimiento_id_seq", sequenceName = "Mantenimiento_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fefhaFin;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicioPrevista;
    @Column(columnDefinition = "TEXT")
    private String motivoMantenimiento;

    public Mantenimiento() {
    }

    public Mantenimiento(Date fefhaFin, Date fechaInicio, String motivoMantenimiento) {
        this.fefhaFin = fefhaFin;
        this.fechaInicio = fechaInicio;
        this.motivoMantenimiento = motivoMantenimiento;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Date getFefhaFin() {
        return fefhaFin;
    }

    public void setFefhaFin(Date fefhaFin) {
        this.fefhaFin = fefhaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicioPrevista() {
        return fechaInicioPrevista;
    }

    public void setFechaInicioPrevista(Date fechaInicioPrevista) {
        this.fechaInicioPrevista = fechaInicioPrevista;
    }

    public String getMotivoMantenimiento() {
        return motivoMantenimiento;
    }

    public void setMotivoMantenimiento(String motivoMantenimiento) {
        this.motivoMantenimiento = motivoMantenimiento;
    }  
}
