package Model;

import java.util.Date;
import java.util.ArrayList;

public class Turno {
    private Date fechaGeneracion;
    private String diaSemana;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private CambioEstadoTurno actual;
    private ArrayList<CambioEstadoTurno> cambioEstado;
    
    /*
    esRangoFecha
    conocerEstadoActual
    crearNuevoCambioEstado
    setCambioEstadoActual
    */

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

    /*public <any> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(CambioEstadoTurno cambioEstado) {
        this.cambioEstado = cambioEstado;
    }
    */
}
