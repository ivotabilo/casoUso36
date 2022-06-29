
import java.util.ArrayList;
import java.util.Date;

public class RecursoTecnologico {
    private int nro;
    private Date fechaAlta;
    private String imagen;
    private int periodicidadMantPreventivo;
    private int duracionMantPreventivo;
    private int fraccionHorariosTurnos;
    
    private Modelo modelo;
    private Mantenimiento mantenimiento;
    private TipoRT tipoRT;
    private CambioEstadoRT estadoActual;
    private ArrayList<CambioEstadoRT> cambioEstado;
    private ArrayList<Turno> turno;

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPeriodicidadMantPreventivo() {
        return periodicidadMantPreventivo;
    }

    public void setPeriodicidadMantPreventivo(int periodicidadMantPreventivo) {
        this.periodicidadMantPreventivo = periodicidadMantPreventivo;
    }

    public int getDuracionMantPreventivo() {
        return duracionMantPreventivo;
    }

    public void setDuracionMantPreventivo(int duracionMantPreventivo) {
        this.duracionMantPreventivo = duracionMantPreventivo;
    }

    public int getFraccionHorariosTurnos() {
        return fraccionHorariosTurnos;
    }

    public void setFraccionHorariosTurnos(int fraccionHorariosTurnos) {
        this.fraccionHorariosTurnos = fraccionHorariosTurnos;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public TipoRT getTipoRT() {
        return tipoRT;
    }

    public void setTipoRT(TipoRT tipoRT) {
        this.tipoRT = tipoRT;
    }

    public CambioEstadoRT getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(CambioEstadoRT estadoActual) {
        this.estadoActual = estadoActual;
    }

    public ArrayList<CambioEstadoRT> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(ArrayList<CambioEstadoRT> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public ArrayList<Turno> getTurno() {
        return turno;
    }

    public void setTurno(ArrayList<Turno> turno) {
        this.turno = turno;
    }
    
    //miModeloYMarca
    //conocerRT
    //buscarTurnosPendientes
    //conocerCambioEstadoActual
    
}
