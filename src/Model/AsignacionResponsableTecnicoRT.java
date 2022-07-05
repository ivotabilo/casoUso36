package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

@Entity
public class AsignacionResponsableTecnicoRT implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AsignacionResponsableTecnico_id_seq")
    @SequenceGenerator(name = "AsignacionResponsableTecnico_id_seq", sequenceName = "AsignacionResponsableTecnico_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDesde;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHasta;
    @ManyToOne(targetEntity = PersonalCientifico.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private PersonalCientifico pc;
    @ManyToMany(targetEntity = RecursoTecnologico.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<RecursoTecnologico> recursoTecnologico = new HashSet();

    public AsignacionResponsableTecnicoRT() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Set<RecursoTecnologico> getRecursoTecnologico() {
        return recursoTecnologico;
    }

    public void setRecursoTecnologico(Set<RecursoTecnologico> recursoTecnologico) {
        this.recursoTecnologico = recursoTecnologico;
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

    public PersonalCientifico getPc() {
        return pc;
    }

    public void setPc(PersonalCientifico pc) {
        this.pc = pc;
    }

    public Set<RecursoTecnologico> getRT() {
        return recursoTecnologico;
    }

    public void setRT(Set<RecursoTecnologico> recursoTecnologico) {
        this.recursoTecnologico = recursoTecnologico;
    }
    
    public boolean esActual(){
        if (this.fechaHasta==null){
            return true;
        }
        return false;
    }
    public Set<RecursoTecnologico>  misRT(){
       return recursoTecnologico;
        
    }
}
