
package Model;

import java.util.Date;

public class Mantenimiento {
    private Date fefhaFin;
    private Date fechaInicio;
    private Date fechaInicioPrevista;
    private String motivoMantenimiento;

    public Mantenimiento(Date fefhaFin, Date fechaInicio, String motivoMantenimiento) {
        this.fefhaFin = fefhaFin;
        this.fechaInicio = fechaInicio;
        this.motivoMantenimiento = motivoMantenimiento;
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
