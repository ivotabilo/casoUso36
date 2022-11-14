package Model;

import Generico.SoporteEstado;
import Generico.SoporteRT;
import Generico.SoporteRT2;
import Generico.SoporteTurno;
import Hibernate.GestorHibernate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
import javax.persistence.Temporal;

@Entity
public class RecursoTecnologico implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RecursoTecnologico_id_seq")
    @SequenceGenerator(name = "RecursoTecnologico_id_seq", sequenceName = "RecursoTecnologico_id_seq", allocationSize = 1)
    private Integer ID;
    
    @Column(name="nro", columnDefinition="Integer default '0'")
    private int nro;
    @Temporal(javax.persistence.TemporalType.DATE)
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
    private List<Turno> turno ;
    
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
        return (Mantenimiento) mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = (Set<Mantenimiento>) mantenimiento;
    }

    public TipoRecursoTecnologico getTipoRT() {
        return tipoRT;
    }

    public void setTipoRT(TipoRecursoTecnologico tipoRT) {
        this.tipoRT = tipoRT;
    }

    public CambioEstadoRT getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(CambioEstadoRT estadoActual) {
        this.estadoActual = estadoActual;
    }

    public ArrayList<CambioEstadoRT> getCambioEstado() {
        return (ArrayList<CambioEstadoRT>) cambioEstado;
    }

    public void setCambioEstado(ArrayList<CambioEstadoRT> cambioEstado) {
        this.cambioEstado = (Set<CambioEstadoRT>) cambioEstado;
    }

    public ArrayList<Turno> getTurno() {
        return (ArrayList<Turno>) turno;
    }

    public void setTurno(ArrayList<Turno> turno) {
        this.turno = (List<Turno>) turno;
    }
    
    
    public RecursoTecnologico() {
        
    }
    
    public RecursoTecnologico(Integer ID, int nro, Date fechaAlta, String imagen, int periodicidadMantPreventivo, int duracionMantPreventivo, int fraccionHorariosTurnos, Modelo modelo, Mantenimiento mantenimiento, TipoRecursoTecnologico tipoRT, CambioEstadoRT estadoActual, Set<CambioEstadoRT> cambioEstado, List<Turno> turno) {
        this.ID = ID;
        this.nro = nro;
        this.fechaAlta = fechaAlta;
        this.imagen = imagen;
        this.periodicidadMantPreventivo = periodicidadMantPreventivo;
        this.duracionMantPreventivo = duracionMantPreventivo;
        this.fraccionHorariosTurnos = fraccionHorariosTurnos;
        this.modelo = modelo;
        this.mantenimiento.add(mantenimiento);
        this.tipoRT = tipoRT;
        this.estadoActual = estadoActual;
        this.cambioEstado = cambioEstado;
        this.turno = turno;
    }
    
    public Set<SoporteTurno> buscarTurnosConfPend(){
        Set<SoporteTurno> turnos = new TreeSet<>();
        for (int i=0;i<this.turno.size();i++){
            if(this.turno.get(i).esRangoFecha()){
                if(this.turno.get(i).conocerEstadoActual()){
                    SoporteTurno soporte= new SoporteTurno(this.turno.get(i),this.turno.get(i).getAsignacion().mostrarCientifico());
                    turnos.add(soporte);
                }
            }
        }
        return turnos;
    }
    
    public SoporteRT2 miModeloYMarca(){
        return new SoporteRT2(this.modelo.getNombre(),this.modelo.getMarca().getNombre());
    }
    
    //devuelve un puntero de la clase actual de recurso recnologico
    /*public RecursoTecnologico conocerRT() throws CloneNotSupportedException{ //ver bien implementacion
        if (this.estadoActual.conocerActual()){
            return (RecursoTecnologico) this.clone();           
        }
        return null;
    }*/
    
    
    public SoporteEstado conocerCambioEstadoActual(Estado estadoNuevoRT, Estado estadoNuevoTurno){
        // cerrar hora fin de estado actual rt
        this.estadoActual.setFechaHoraHasta(Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-3"))));
        //guardar estado en el array 
        this.cambioEstado.add(this.estadoActual);
        //crear uno nuevo
        CambioEstadoRT nuevoCambio = new CambioEstadoRT(Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-3"))),estadoNuevoRT);
        //asignar a estado actual
        this.setCambioEstadoActual(nuevoCambio);
        List<CambioEstadoTurno> listaCambioTurno = new ArrayList<>();
        for (Turno turnoRT :  turno) { 
            listaCambioTurno.add(turnoRT.crearNuevoCambioEstado(estadoNuevoTurno));
        }
        SoporteEstado soporteEstado  = new SoporteEstado(nuevoCambio,listaCambioTurno,turno); //CambioEstadoRT cert, List<CambioEstadoTurno> lcet, List<Turno> lt
        return soporteEstado;
    }
    
    public void setCambioEstadoActual(CambioEstadoRT nuevoCambio){
        cambioEstado.add(this.estadoActual);
        // asignar el nuevo al actual
        this.setEstadoActual(nuevoCambio);

    }
    
    public RecursoTecnologico conocerRT(){
        Boolean esdisponible = this.estadoActual.conocerActual().esDisponible();
        if (esdisponible!=null && esdisponible){
            RecursoTecnologico rt = new RecursoTecnologico();
            return rt;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.nro+"";
    }

    
   
}
