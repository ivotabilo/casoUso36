package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Turno_id_seq")
    @SequenceGenerator(name = "Turno_id_seq", sequenceName = "Turno_id_seq", allocationSize = 1)
    private Integer ID;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaGeneracion;
    @Column(columnDefinition = "TEXT")
    private String diaSemana;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHoraInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHoraFin;
    @OneToOne(targetEntity = CambioEstadoTurno.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private CambioEstadoTurno actual;
    @OneToMany(targetEntity = CambioEstadoTurno.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<CambioEstadoTurno> cambioEstado = new HashSet();
    @OneToOne(targetEntity = AsignacionResponsableTecnicoRT.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private AsignacionResponsableTecnicoRT asignacion;

    public Turno() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Set<CambioEstadoTurno> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(Set<CambioEstadoTurno> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }
    
    public AsignacionResponsableTecnicoRT getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(AsignacionResponsableTecnicoRT asignacion) {
        this.asignacion = asignacion;
    }
    public boolean esRangoFecha(){
        if (fechaHoraInicio.getTime() >= Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-3"))).getTime() ){
            return true;
        } else {
            return false;
        }
        
    }
    public boolean conocerEstadoActual(){
        if(this.actual.esConfirmado()){
            return true;
        }else if(this.actual.esPendienteConf()){
            return true;
        }
        return false;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public CambioEstadoTurno getActual() {
        return actual;
    }

    public void setActual(CambioEstadoTurno actual) {
        this.actual = actual;
    }

    
    public void setCambioEstadoActual(CambioEstadoTurno nuevoEstadoTurno) {
        this.cambioEstado.add(actual);
        this.setActual(nuevoEstadoTurno);
    }

    public void crearNuevoCambioEstado(Estado cambioEstado) {
        // al actual setearle fecha fin 
        this.actual.setFechaHoraHasta(Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-3"))));
        // agregarlo al array
        CambioEstadoTurno nuevoEstadoTurno = new CambioEstadoTurno(Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-3"))),cambioEstado);
        this.setCambioEstadoActual(nuevoEstadoTurno);
        // y setearle el nuevo estado
    }
   
    /*
    crearNuevoCambioEstado
    setCambioEstadoActual
    */
}
