package Model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AsignacionResponsableTecnicoRT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AsignacionResponsableTecnico_id_seq")
    @SequenceGenerator(name = "AsignacionResponsableTecnico_id_seq", sequenceName = "AsignacionResponsableTecnico_id_seq", allocationSize = 1)
    private Integer ID;
    
    private Date fechaDesde;
    private Date fechaHasta;
    private PersonalCientifico pc;
    private ArrayList<RecursoTecnologico> recursoTecnologico;

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

    public ArrayList<RecursoTecnologico> getRT() {
        return recursoTecnologico;
    }

    public void setRT(ArrayList<RecursoTecnologico> recursoTecnologico) {
        this.recursoTecnologico = recursoTecnologico;
    }
    
    public boolean esActual(){
        if (this.fechaHasta==null){
            return true;
        }
        return false;
    }
    public ArrayList<RecursoTecnologico> misRT(){
       return recursoTecnologico;
        
    }
}
