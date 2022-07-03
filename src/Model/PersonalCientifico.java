package Model;
        
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PersonalCientifico implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonalCientifico_id_seq")
    @SequenceGenerator(name = "PersonalCientifico_id_seq", sequenceName = "PersonalCientifico_id_seq", allocationSize = 1)
    private Integer ID;

    @Column(name="legajo", columnDefinition="Integer default '0'")
    private int legajo;
    @Column(columnDefinition = "TEXT")
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String apellido;
    @Column(name="nroDocumento", columnDefinition="Integer default '0'")
    private int nroDocumento;
    @Column(columnDefinition = "TEXT")
    private String correoElectronicoInstitucional;
    @Column(columnDefinition = "TEXT")
    private String correoElectronicoPersonal;
    @Column(name="telCelular", columnDefinition="Integer default '0'")
    private int telCelular;
    @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(targetEntity = Turno.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private ArrayList<AsignacionResponsableTecnicoRT> asigRespTecnicoRt;
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public int getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(int telCelular) {
        this.telCelular = telCelular;
    }
    
    public PersonalCientifico esTuUsuario(String nombreUs){ 
        if (this.usuario.getNombre().equals(nombreUs)){  //invocamos el metodo getNombre de personal cientifico y lo comparamos con el nombre q nos pasaron como parametro
            return this;
        }
        return null;
    } 

    // revisar porque no toma el return del if
    public ArrayList<RecursoTecnologico> burcarRTenEstadoDisponible(){
        ArrayList<RecursoTecnologico> misRtDisponibles = new ArrayList<RecursoTecnologico>();
        ArrayList<AsignacionResponsableTecnicoRT> asignacionesActuales = new ArrayList<AsignacionResponsableTecnicoRT>();
        
        for(AsignacionResponsableTecnicoRT asignacion:asigRespTecnicoRt){
            if(asignacion.esActual()){
                asignacionesActuales.add(asignacion);
            }
        }
        
        for (AsignacionResponsableTecnicoRT asignacionesActuale : asignacionesActuales) {
            ArrayList<RecursoTecnologico> recursosTecnologicos = asignacionesActuale.misRT();
            for (RecursoTecnologico recursoTecnologico : recursosTecnologicos) {
                if (recursoTecnologico.conocerCambioEstadoActual().getEstado().esDisponible()){
                    misRtDisponibles.add(recursoTecnologico);
                }
            }
        }
            
            
                
        return misRtDisponibles;
    }
}
