package Model;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class RecursoTecnologico implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RecursoTecnologico_id_seq")
    @SequenceGenerator(name = "RecursoTecnologico_id_seq", sequenceName = "RecursoTecnologico_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Column(name="nro", columnDefinition="Integer default '0'")
    private int nro;
    private Date fechaAlta;
    @Column(columnDefinition = "TEXT")
    private String imagen;
    @Column(name="periodicidadMantPreventivo", columnDefinition="Integer default '0'")
    private int periodicidadMantPreventivo;
    @Column(name="duracionMantPreventivo", columnDefinition="Integer default '0'")
    private int duracionMantPreventivo;
    @Column(name="fraccionHorariosTurnos", columnDefinition="Integer default '0'")
    private int fraccionHorariosTurnos;
    @ManyToOne(targetEntity = Modelo.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Modelo modelo;
    @OneToMany(targetEntity = Mantenimiento.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Mantenimiento> mantenimiento = new HashSet();
    @ManyToOne(targetEntity = TipoRecursoTecnologico.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private TipoRecursoTecnologico tipoRT;
    @OneToOne(targetEntity = CambioEstadoRT.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private CambioEstadoRT estadoActual;
    @OneToMany(targetEntity = CambioEstadoRT.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<CambioEstadoRT> cambioEstado = new HashSet();
    @OneToMany(targetEntity = Turno.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Turno> turno = new HashSet();
    
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
    
    //miModeloYMarca
    public void conocerRT(){
        this.estadoActual.conocerActual();
    }
    //buscarTurnosPendientes
    //conocerCambioEstadoActual
    
}
