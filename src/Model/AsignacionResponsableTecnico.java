
import java.util.ArrayList;
import java.util.Date;

public class AsignacionResponsableTecnico {
    private Date fechaDesde;
    private Date fechaHasta;
    private PersonalCientifico pc;
    private ArrayList<RecursoTecnologico> RT;

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
        return RT;
    }

    public void setRT(ArrayList<RecursoTecnologico> RT) {
        this.RT = RT;
    }
    
    //esActual
    //misRT
}
