 package Model;

import java.util.Date;
import java.util.List;

public class GestorRegIngMant {
    private String usuarioLog;
    private Sesion activaSesion; 
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

    public String getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(String usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public Sesion getActivaSesion() {
        return activaSesion;
    }

    public void setActivaSesion(Sesion activaSesion) {
        this.activaSesion = activaSesion;
    }

    public PersonalCientifico getPersonalCientificoDeUsu() {
        return personalCientificoDeUsu;
    }

    public void setPersonalCientificoDeUsu(PersonalCientifico personalCientificoDeUsu) {
        this.personalCientificoDeUsu = personalCientificoDeUsu;
    }

    public List<RecursoTecnologico> getRecursosTecnologicosDisponibles() {
        return recursosTecnologicosDisponibles;
    }

    public void setRecursosTecnologicosDisponibles(List<RecursoTecnologico> recursosTecnologicosDisponibles) {
        this.recursosTecnologicosDisponibles = recursosTecnologicosDisponibles;
    }

    public List<RecursoTecnologico> getRecursosTecnologicosDisponiblesOrdenado() {
        return recursosTecnologicosDisponiblesOrdenado;
    }

    public void setRecursosTecnologicosDisponiblesOrdenado(List<RecursoTecnologico> recursosTecnologicosDisponiblesOrdenado) {
        this.recursosTecnologicosDisponiblesOrdenado = recursosTecnologicosDisponiblesOrdenado;
    }

    public RecursoTecnologico getSelRt() {
        return SelRt;
    }

    public void setSelRt(RecursoTecnologico SelRt) {
        this.SelRt = SelRt;
    }

    public Date getIngFecFin() {
        return IngFecFin;
    }

    public void setIngFecFin(Date IngFecFin) {
        this.IngFecFin = IngFecFin;
    }

    public String getIngRazMant() {
        return IngRazMant;
    }

    public void setIngRazMant(String IngRazMant) {
        this.IngRazMant = IngRazMant;
    }

    public List<Turno> getTurnosRT() {
        return turnosRT;
    }

    public void setTurnosRT(List<Turno> turnosRT) {
        this.turnosRT = turnosRT;
    }

    public List<Turno> getTurnosRtOrdenado() {
        return turnosRtOrdenado;
    }

    public void setTurnosRtOrdenado(List<Turno> turnosRtOrdenado) {
        this.turnosRtOrdenado = turnosRtOrdenado;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public PantRegIngMant getForm() {
        return form;
    }

    public void setForm(PantRegIngMant form) {
        this.form = form;
    }
    
    public void nuevoIngMantCorre(){
        //invocar buscarrtuslog
//to-do
    }
    
    public void buscarRtUsLog(){
        //buscar las sesiones
        //buscar la activa
        //tomarle el usuario
        this.usuarioLog=this.activaSesion.buscarUsuario();
        //invocar obtenerPersDeUSU
    }

    public PersonalCientifico obtenerPersDeUsu(){
        //buscarUsuarios
        //compararsu usuario con el nombre del usuario logueado
        return new PersonalCientifico();//to-do
        //invocar buscarRtEnEstadoDisponible
    }
    
    public List<RecursoTecnologico> buscarRtEnEstadoDisponible() {
        //invocar al usuario logueado el metodo buscarRTenestadodisponible 
        return (List<RecursoTecnologico>) new RecursoTecnologico();//to-do
        //invocar metodo ordenarportiport
    }
    
    public List<RecursoTecnologico> ordenarPorTipoRT(List<RecursoTecnologico> recursosTecnologicosDisponibles){
        //ordenarlosportipo rt
        //enviar a la pantalla con el metodo mostysolselrt
        return this.recursosTecnologicosDisponiblesOrdenado;
    }
    
    public void tomarSelRt(RecursoTecnologico recursoTecnologico){
        this.SelRt=recursoTecnologico;
        //llamar a solicitar fecha fin de pantalla
        //llamar a solicitar razon de pantalla
    }
    
    public void tomarIngFecFin(Date ingFecFin){
        this.IngFecFin=ingFecFin;
    }
    
    public void tomarIngRazMant(String ingRazMant){
        this.IngRazMant=ingRazMant;
        //llamar buscar turnos rt
    }
    
    public List<Turno> buscarTurnosRT(){
        //llamar a buscar turnos confpend
        return (List<Turno>) new Turno();//to-do
        //llamar a ordenar turnos por cientifico
    }
    
    public List<Turno> ordenarTurnosPorCientifico(List<Turno> turnosRT){
        //to-do
        
        return this.turnosRtOrdenado;
        //llamar a pantalla solicitar confirmacion
    }
    
    public void tomarConfirmacion(){
        //to-do
        //llamar a solformaNotificacion en pantalla
    }
    
    public void tomarSelFormaNotificacion(String tipoNotificacion){
        this.tipoNotificacion=tipoNotificacion;
        //llamar a buscarestado cancelado por mant corr
    }
    
    public Estado buscarEstadoCanceladoPorMantCorr(){
        return new Estado();//to-do
        //implementar
        //llamar a buscar estado con ingmantcorrectivo
    }
    
    public Estado buscarEstadoConIngMantCorrectivo(){
        return new Estado();//to-do
        //implementar
        //llamar a getFechaHoraActual
    }
    
    public Date getFechaHoraActual(){
        return new Date(); //to-do
        //implementar
        //llamar a crear mantenimiento
    }
    
    public void crearMantenimiento(){
        //to-do
        //implementar
        //+ notificar
    }
    
    public void open() {
        setForm(new PantRegIngMant());
        getForm().setVisible(true); 
    }
    
}
