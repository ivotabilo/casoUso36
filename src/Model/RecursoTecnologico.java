package Model;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class RecursoTecnologico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RecursoTecnologico_id_seq")
    @SequenceGenerator(name = "RecursoTecnologico_id_seq", sequenceName = "RecursoTecnologico_id_seq", allocationSize = 1)
    private Integer ID;
    
    private int nro;
    private Date fechaAlta;
    private String imagen;
    private int periodicidadMantPreventivo;
    private int duracionMantPreventivo;
    private int fraccionHorariosTurnos;
    private Modelo modelo;
    private Mantenimiento mantenimiento;
    private TipoRecursoTecnologico tipoRT;
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

    /*
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
    */
    
    public RecursoTecnologico() {
        
    }
    public RecursoTecnologico(Integer ID, int nro, Date fechaAlta, String imagen, int periodicidadMantPreventivo, int duracionMantPreventivo, int fraccionHorariosTurnos, Modelo modelo, Mantenimiento mantenimiento, TipoRecursoTecnologico tipoRT, CambioEstadoRT estadoActual, ArrayList<CambioEstadoRT> cambioEstado, ArrayList<Turno> turno) {
        this.ID = ID;
        this.nro = nro;
        this.fechaAlta = fechaAlta;
        this.imagen = imagen;
        this.periodicidadMantPreventivo = periodicidadMantPreventivo;
        this.duracionMantPreventivo = duracionMantPreventivo;
        this.fraccionHorariosTurnos = fraccionHorariosTurnos;
        this.modelo = modelo;
        this.mantenimiento = mantenimiento;
        this.tipoRT = tipoRT;
        this.estadoActual = estadoActual;
        this.cambioEstado = cambioEstado;
        this.turno = turno;
    }
    
    //buscarTurnosPendientes
    
    public void miModeloYMarca(){
        
    }
    
    //devuelve un puntero de la clase actual de recurso recnologico
    public RecursoTecnologico conocerRT() throws CloneNotSupportedException{ //ver bien implementacion
        if (this.estadoActual.conocerActual()){
            return (RecursoTecnologico) this.clone();           
        }
        return null;
    }
    
    // devuelve el estado actual del recurso tecnologico
    public CambioEstadoRT conocerCambioEstadoActual(){
        return this.estadoActual;
    }
    
}
