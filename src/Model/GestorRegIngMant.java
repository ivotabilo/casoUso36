package Model;

import java.util.Date;
import java.util.List;

public class GestorRegIngMant {
    private Usuario usuarioLog;
    private PersonalCientifico personalCientificoDeUsu;
    private List<RecursoTecnologico> recursosTecnologicosDisponibles;
    private List<RecursoTecnologico> recursosTecnologicosDisponiblesOrdenado;
    private RecursoTecnologico SelRt;
    private Date IngFecFin;
    private String IngRazMant;
    private List<Turno> turnosRT;
    private List<Turno> turnosRtOrdenado;
    private String tipoNotificacion;
    private Date fechaActual;
    
    private PantRegIngMant form;

    public PantRegIngMant getForm() {
        return form;
    }

    public void setForm(PantRegIngMant form) {
        this.form = form;
    }
    
    public void nuevoIngMantCorre(){
        //to-do
    }
    
    public Usuario buscarRtUsLog(){
        return new Usuario();//to-do
    }

    public PersonalCientifico obtenerPersDeUsu(){
        return new PersonalCientifico();//to-do
    }
    
    public List<RecursoTecnologico> buscarRtEnEstadoDisponible() {
        return (List<RecursoTecnologico>) new RecursoTecnologico();//to-do
    }
    
    public List<RecursoTecnologico> ordenarPorTipoRT(List<RecursoTecnologico> recursosTecnologicosDisponibles){
        //to-do
        
        return this.recursosTecnologicosDisponiblesOrdenado;
    }
    
    public void tomarSelRt(RecursoTecnologico recursoTecnologico){
        this.SelRt=recursoTecnologico;
    }
    
    public void tomarIngFecFin(Date ingFecFin){
        this.IngFecFin=ingFecFin;
    }
    
    public void tomarIngRazMant(String ingRazMant){
        this.IngRazMant=ingRazMant;
    }
    
    public List<Turno> buscarTurnosRT(){
        return (List<Turno>) new Turno();//to-do
    }
    
    public List<Turno> ordenarTurnosPorCientifico(List<Turno> turnosRT){
        //to-do
        
        return this.turnosRtOrdenado;
    }
    
    public void tomarConfirmacion(){
        //to-do
    }
    
    public void tomarSelFormaNotificacion(String tipoNotificacion){
        this.tipoNotificacion=tipoNotificacion;  
    }
    
    public Estado buscarEstadoCanceladoPorMantCorr(){
        return new Estado();//to-do
    }
    
    public Estado buscarEstadoConIngMantCorrectivo(){
        return new Estado();//to-do
    }
    
    public Date getFechaHoraActual(){
        return new Date(); //to-do
    }
    
    public void crearMantenimiento(){
        //to-do
    }
}
