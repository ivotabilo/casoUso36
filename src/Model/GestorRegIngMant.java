 package Model;

import Generico.GestorGn;
import Generico.SoporteRT;
import Generico.SoporteRT2;
import InterfaceNotificaciones.Notificaciones;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

public class GestorRegIngMant extends GestorGn{
    private String usuarioLog;
    private Sesion activaSesion; 
    private PersonalCientifico personalCientificoDeUsu;
    private List<PersonalCientifico> personalesCientifico;  
    private Set<SoporteRT> recursosTecnologicosDisponibles;
    private Set<SoporteRT> recursosTecnologicosDisponiblesOrdenado;
    private RecursoTecnologico SelRt;
    private Date IngFecFin;
    private String IngRazMant;
    private List<Turno> turnosRT;
    private List<Turno> turnosRtOrdenado;
    private String tipoNotificacion;
    private Date fechaActual;
    private List<Sesion> habilitarSesion;
    private List<Estado> estados;
    private Estado estadosTurnos;
    private Estado estadosRT;
    private Notificaciones notificacion;
            
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

    public Set<SoporteRT> getRecursosTecnologicosDisponibles() {
        return recursosTecnologicosDisponibles;
    }

    public void setRecursosTecnologicosDisponibles(Set<SoporteRT> recursosTecnologicosDisponibles) {
        this.recursosTecnologicosDisponibles = recursosTecnologicosDisponibles;
    }

    public Set<SoporteRT> getRecursosTecnologicosDisponiblesOrdenado() {
        return recursosTecnologicosDisponiblesOrdenado;
    }

    public void setRecursosTecnologicosDisponiblesOrdenado(Set<SoporteRT> recursosTecnologicosDisponiblesOrdenado) {
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
        this.buscarRtUsLog();
//to-do
    }
    
    public void buscarRtUsLog(){
        //buscar las sesiones
        //buscar la activa
        this.activaSesion = (Sesion) this.buscarSesion(Sesion.class);
        //tomarle el usuario 
        this.usuarioLog=this.activaSesion.buscarUsuario();
        //invocar obtenerPersDeUSU
        this.obtenerPersDeUsu(usuarioLog);
    }
    
    public void obtenerPersDeUsu(String usuarioLog){  
        //buscarUsuarios
        this.personalesCientifico = (List<PersonalCientifico>) this.traerGenerico(PersonalCientifico.class);
        //compararsu usuario con el nombre del usuario logueado 
        for (int i=0;i<this.personalesCientifico.size(); i++){
           if(this.personalesCientifico.get(i).esTuUsuario(usuarioLog)!=null){
                this.personalCientificoDeUsu=this.personalesCientifico.get(i).esTuUsuario(usuarioLog);
           }
        }
        this.buscarRtEnEstadoDisponible();
               //invocar buscarRtEnEstadoDisponible
        
    }
    
    public void buscarRtEnEstadoDisponible() {
        //invocar al usuario logueado el metodo buscarRTenestadodisponible
        this.recursosTecnologicosDisponibles = this.personalCientificoDeUsu.burcarRTenEstadoDisponible((AsignacionResponsableTecnicoRT) this.buscarAsignacion(AsignacionResponsableTecnicoRT.class));
        //invocar metodo ordenarportiport
        this.recursosTecnologicosDisponiblesOrdenado = this.recursosTecnologicosDisponibles;
        this.ordenarPorTipoRT(this.recursosTecnologicosDisponiblesOrdenado);
        this.form.mostrarYSolSelRt(recursosTecnologicosDisponiblesOrdenado);
    }
    
    public void ordenarPorTipoRT(Set<SoporteRT> recursosTecnologicosDisponibles){
        //ordenarlosportipo rt
        //enviar a la pantalla con el metodo mostysolselrt
        //return this.recursosTecnologicosDisponiblesOrdenado;
        List<SoporteRT> lista = new ArrayList<>(recursosTecnologicosDisponibles);
        
        //List<SoporteRT> lista = (List<SoporteRT>) recursosTecnologicosDisponibles;
        Collections.sort(lista, new Comparator<SoporteRT>(){
            public int compare(SoporteRT obj1, SoporteRT obj2) {
                return obj1.getTipoRT().compareTo(obj2.getTipoRT());
            }
        });
        
        recursosTecnologicosDisponibles.clear();
        recursosTecnologicosDisponibles.addAll(lista);
        
    }
    
    public void tomarSelRt(RecursoTecnologico recursoTecnologico){
        this.SelRt=recursoTecnologico;
        //llamar a solicitar fecha fin de pantalla
        this.form.solIngFecFin();
        //llamar a solicitar razon de pantalla
        this.form.solIngrRazMant();
    }
    
    public void tomarIngFecFin(Date ingFecFin){
        this.IngFecFin=ingFecFin;
    }
    
    public void tomarIngRazMant(String ingRazMant){
        this.IngRazMant=ingRazMant;
        //llamar buscar turnos rt
        this.buscarTurnosRT();
    }
    
    public void buscarTurnosRT(){
        //llamar a buscar turnos confpend
        //llamar a ordenar turnos por cientifico
       this.turnosRT = this.SelRt.buscarTurnosPendientes();
       this.turnosRtOrdenado = this.turnosRT;
       this.ordenarTurnosPorCientifico(turnosRtOrdenado);
       this.form.solConfirmacion(this.turnosRtOrdenado);
    }
    
    public void ordenarTurnosPorCientifico(List<Turno> turnosRtOrdenado){
        //to-do
        
        Collections.sort(turnosRtOrdenado, new Comparator<Turno>(){
            @Override
            public int compare(Turno obj1, Turno obj2) {
                return obj1.getAsignacion().getPc().getNombre().compareTo(obj2.getAsignacion().getPc().getNombre());
            }
        });
        
        //llamar a pantalla solicitar confirmacion
    }
    
    public void tomarConfirmacion(){
        //to-do
        //llamar a solformaNotificacion en pantalla
        this.form.solFormaNotificacion();
    }
    
    public void tomarSelFormaNotificacion(String tipoNotificacion){
        this.tipoNotificacion=tipoNotificacion;
        //llamar a buscarestado cancelado por mant corr
        this.buscarEstadoCanceladoPorMantCorr();
       
    }
    
    public void buscarEstadoCanceladoPorMantCorr(){
        this.estados=(List<Estado>) this.traerGenerico(Estado.class);
        for(int i=0;i<this.estados.size();i++){
           if(this.estados.get(i).esAmbitoTurno()&& this.estados.get(i).esCanceladoPorMantenimientoCorrectivo() ){
                 this.estadosTurnos=this.estados.get(i);
           }
        }
          
         this.buscarEstadoConIngMantCorrectivo();
        //implementar
        //llamar a buscar estado con ingmantcorrectivo
    }
    
    public void buscarEstadoConIngMantCorrectivo(){
       this.estados=(List<Estado>) this.traerGenerico(Estado.class);
        for(int i=0;i<this.estados.size();i++){
           if(this.estados.get(i).esAmbitoRT()&& this.estados.get(i).esConIngresoAMantenimientoCorrectivo() ){
                 this.estadosRT=this.estados.get(i);
           }
        }
        //implementar
        //llamar a getFechaHoraActual
        this.getFechaHoraActual();
    }
    
    public void getFechaHoraActual(){
        LocalDateTime.now();
        this.crearMantenimiento();
        //implementar
        //llamar a crear mantenimiento
    }
    
    public void crearMantenimiento(){
        //to-do
        //implementar
        //+ notificar
        this.SelRt.conocerCambioEstadoActual();
        Mantenimiento m =new Mantenimiento();
        this.guardarObjeto(m);
        if("Email".equals(tipoNotificacion)){
            this.notificacion.notificacionMail(IngRazMant, IngRazMant);
        }else if("WhatsApp".equals(tipoNotificacion)){
            this.notificacion.notificacionWhatsapp(usuarioLog, IngRazMant); //FALTA TERMINAR
        }
        
    }
    
    public void open() {
        setForm(new PantRegIngMant());
        this.getForm().setGestor(this);
        getForm().setVisible(true); 
    }

    public DefaultTableModel listarDatosRT(DefaultTableModel modelTabla,Class clase,Set<SoporteRT> list) {
        TreeSet<SoporteRT> lista= new TreeSet();
        SoporteRT auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext()) {
            auxModel =(SoporteRT) it.next();
            lista.add(auxModel);
        }
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext()) {
            auxModel =(SoporteRT) it2.next();
            Object[] fila = {auxModel,auxModel.getIdRt(),auxModel.getTipoRT(),auxModel.getMarca(),auxModel.getModelo()};
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
    
    public DefaultTableModel listarDatosTurno(DefaultTableModel modelTabla,Class clase,Set<SoporteRT2> list) {
        TreeSet<SoporteRT2> lista= new TreeSet();
        SoporteRT2 auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext()) {
            auxModel =(SoporteRT2) it.next();
            lista.add(auxModel);
        }
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext()) {
            auxModel =(SoporteRT2) it2.next();
            Object[] fila = {auxModel/*,auxModel.getId(),*/};//completar
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
    
}
