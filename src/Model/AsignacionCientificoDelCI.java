package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
public class AsignacionCientificoDelCI implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AsignacionCientificoDelCI_id_seq")
    @SequenceGenerator(name = "AsignacionCientificoDelCI_id_seq", sequenceName = "AsignacionCientificoDelCI_id_seq", allocationSize = 1)
    private Integer ID;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDesde;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHasta;
    @OneToMany(targetEntity = Turno.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Turno> turnos = new HashSet();
    @OneToOne(targetEntity = PersonalCientifico.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private PersonalCientifico personalCientifico;

    public AsignacionCientificoDelCI() {
    }
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    //mostrarCientifico
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
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

    /*public <any> getTurnos() {
        return turnos;
    }

    public void setTurnos(<any> turnos) {
        this.turnos = turnos;
    }*/

    public PersonalCientifico getPersonalCientifico() {
        return personalCientifico;
    }

    public void setPersonalCientifico(PersonalCientifico personalCientifico) {
        this.personalCientifico = personalCientifico;
    }
    
    
}
