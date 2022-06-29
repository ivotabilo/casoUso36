package Model;

import java.util.Date;
import java.util.ArrayList;

public class AsignacionCientificoDelCI {
    private Date fechaDesde;
    private Date fechaHasta;
    private ArrayList<Turno> turnos;
    private PersonalCientifico personalCientifico;
    
    //mostrarCientifico

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
