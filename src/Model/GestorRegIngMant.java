 package Model;

import Generico.GestorGn;
import Generico.SoporteEstado;
import Generico.SoporteRT;
import Generico.SoporteTurno;
import InterfaceNotificaciones.IObserverNotificacion;
import InterfaceNotificaciones.ISujetoNotificacion;
import InterfaceNotificaciones.InterfazEmail;
import InterfaceNotificaciones.InterfazWhatsapp;
import Model.AsignacionResponsableTecnicoRT;
import Model.CambioEstadoTurno;
import Model.Estado;
import Model.Mantenimiento;
import Model.PersonalCientifico;
import Model.RecursoTecnologico;
import Model.Sesion;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;

public class GestorRegIngMant extends GestorGn implements ISujetoNotificacion{
    private String usuarioLog;
    private Sesion activaSesion; 
    private PersonalCientifico personalCientificoDeUsu;
    private List<PersonalCientifico> personalesCientifico;  
    private Set<SoporteRT> recursosTecnologicosDisponibles;
    private Set<SoporteRT> recursosTecnologicosDisponiblesOrdenado;
    private RecursoTecnologico SelRt;
    private Date IngFecFin;
    private String IngRazMant;
    private Set<SoporteTurno> turnosRT;
    private Set<SoporteTurno> turnosRtOrdenado;
    private String tipoNotificacion;
    private Date fechaActual;
    private List<Sesion> habilitarSesion;
    private List<Estado> estados;
    private Estado estadosTurnos;
    private Estado estadosRT;
    //private Notificaciones notificacion;
    private List<IObserverNotificacion> notificadores = new ArrayList<>();
    private List<String> emailCientifico = new ArrayList<>();
    private List<String> telefonoCientifico = new ArrayList<>();
            
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

    public Set<SoporteTurno> getTurnosRT() {
        return turnosRT;
    }

    public void setTurnosRT(Set<SoporteTurno> turnosRT) {
        this.turnosRT = turnosRT;
    }

    public Set<SoporteTurno> getTurnosRtOrdenado() {
        return turnosRtOrdenado;
    }

    public void setTurnosRtOrdenado(Set<SoporteTurno> turnosRtOrdenado) {
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
        //busca usuario logueado
        this.buscarRtUsLog();
//to-do
    }
    
    public void buscarRtUsLog(){
        //busca la sesion activa
        this.activaSesion = (Sesion) this.buscarSesion(Sesion.class);
        //toma el usuario de la sesion
        this.usuarioLog=this.activaSesion.buscarUsuario();
        //busca personal cientifico del usuario
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
        //busca los recursos tecnologicos disponibles 
        this.buscarRtEnEstadoDisponible();
        
    }
    
    public void buscarRtEnEstadoDisponible() {
        //busca los recursos tecnologicos disponibles  
        this.recursosTecnologicosDisponibles = this.personalCientificoDeUsu.burcarRTenEstadoDisponible((AsignacionResponsableTecnicoRT) this.buscarAsignacion(AsignacionResponsableTecnicoRT.class, this.personalCientificoDeUsu.getID()));
        this.recursosTecnologicosDisponiblesOrdenado = this.recursosTecnologicosDisponibles;
        //ordena los recursos por tipo de recurso
        this.ordenarPorTipoRT(this.recursosTecnologicosDisponiblesOrdenado);
        //envia los recursos ordenados a la pantalla
        this.form.mostrarYSolSelRt(recursosTecnologicosDisponiblesOrdenado);
    }
    
    public void ordenarPorTipoRT(Set<SoporteRT> recursosTecnologicosDisponibles){
        List<SoporteRT> lista = new ArrayList<>(recursosTecnologicosDisponibles);
        //se ordena la lista alfabeticamente con el ordenamiento burbuja
        Collections.sort(lista, new Comparator<SoporteRT>(){
            public int compare(SoporteRT obj1, SoporteRT obj2) {
                return obj1.getTipoRT().compareTo(obj2.getTipoRT());
            }
        });
        
        recursosTecnologicosDisponibles.clear();
        recursosTecnologicosDisponibles.addAll(lista);
        
    }
    
    public void tomarSelRt(RecursoTecnologico recursoTecnologico){
        //se guarda el rt en el gestor
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
       this.turnosRT = this.SelRt.buscarTurnosConfPend();
       this.turnosRtOrdenado=this.turnosRT;
       List<SoporteTurno> turnosa= new ArrayList(turnosRT);
       for(int i=0;i<turnosa.size(); i++){
           this.emailCientifico.add(turnosa.get(i).getEmail());
           System.out.println(emailCientifico.get(i));
           this.telefonoCientifico.add(turnosa.get(i).getTelefono());
           System.out.println(telefonoCientifico.get(i));
       }
       
       this.ordenarTurnosPorCientifico(turnosRtOrdenado);
       this.form.solConfirmacion(this.turnosRtOrdenado);
    }
    
    public void ordenarTurnosPorCientifico(Set<SoporteTurno> turnosRtOrdenado){
        //ordenar por cientifico

        List<SoporteTurno> lista = new ArrayList<>(turnosRtOrdenado);
        Collections.sort(lista, new Comparator<SoporteTurno>(){
            public int compare(SoporteTurno obj1, SoporteTurno obj2) {
                return (obj1.getPc().getApellido()+", "+obj1.getPc().getNombre()).compareTo(obj2.getPc().getApellido()+", "+obj2.getPc().getNombre());
            }
        });
        
        turnosRtOrdenado.clear();
        turnosRtOrdenado.addAll(lista);

    }
    
    public void tomarConfirmacion(){
        //llamar a solformaNotificacion en pantalla
        this.form.solFormaNotificacion();
    }
    
    public void tomarSelFormaNotificacion(String tipoNotificacion){
        this.tipoNotificacion=tipoNotificacion;
        //crear interfaces de observadores/
        //suscribir interfaces de observadores/
        if ("e+w".equals(tipoNotificacion)){
            List<IObserverNotificacion> interfaces = new ArrayList<>();
            IObserverNotificacion interfaceEmail = new InterfazEmail();
            IObserverNotificacion interfaceWhatsapp = new InterfazWhatsapp();
            interfaces.add(interfaceEmail);
            interfaces.add(interfaceWhatsapp);
            for(int i=0;i<interfaces.size();i++){
                suscribir(interfaces.get(i));
            }
        }else if("e".equals(tipoNotificacion)){
            IObserverNotificacion interfaceEmail = new InterfazEmail();
            suscribir(interfaceEmail);
        }else{
            IObserverNotificacion interfaceWhatsapp = new InterfazWhatsapp();
            suscribir(interfaceWhatsapp);
        }
        //llamar a buscarestado cancelado por mant corr
        this.buscarEstadoCanceladoPorMantCorr();
       
    }
    
    public void buscarEstadoCanceladoPorMantCorr(){
        //busca estado cancelado por mantenimiento correctivo
        this.estados=(List<Estado>) this.traerGenerico(Estado.class);
        for(int i=0;i<this.estados.size();i++){
           if(this.estados.get(i).esAmbitoTurno()&& this.estados.get(i).esCanceladoPorMantenimientoCorrectivo() ){
                 this.estadosTurnos=this.estados.get(i);
           }
        }
          
         this.buscarEstadoConIngMantCorrectivo();
    }
    
    public void buscarEstadoConIngMantCorrectivo(){
        //busca estado ingreso con mantenimiento correctivo
       this.estados=(List<Estado>) this.traerGenerico(Estado.class);
        for(int i=0;i<this.estados.size();i++){
           if(this.estados.get(i).esAmbitoRT()&& this.estados.get(i).esConIngresoAMantenimientoCorrectivo() ){
                 this.estadosRT=this.estados.get(i);
           }
        }
        //toma fecha y hora actual
        this.getFechaHoraActual();
    }
    
    public void getFechaHoraActual(){
        //casteamos localdate a Date y zona horaria -3(arg)
        this.fechaActual = Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-3")));
        //llamar a crear mantenimiento
        this.crearMantenimiento();
    }
    
    public void crearMantenimiento(){
        SoporteEstado se= this.SelRt.conocerCambioEstadoActual(this.estadosRT,this.estadosTurnos);
        
        // + cambio de estado
        for(int i=0;i<se.getLcet().size();i++) {
            try {
               this.guardarObjeto((CambioEstadoTurno)se.getLcet().get(i)); 
            } catch (Exception e) {
               this.guardarObjeto((CambioEstadoTurno)se.getLcet().get(i));
            }
        }
        //guardar turnos
        for(int i=0;i<se.getLt().size();i++) {
            try {
               this.actualizaroguardaObjeto(se.getLt().get(i)); 
            } catch (Exception e) {
               this.actualizaroguardaObjeto(se.getLt().get(i));
            }
            
        }
        //cambio de estado
        this.guardarObjeto(se.getCert());
        //guardar rt +
        try {
            this.actualizaroguardaObjeto(SelRt); 
        } catch (Exception e) {
            this.actualizaroguardaObjeto(SelRt); 
        }
        
        Mantenimiento m =new Mantenimiento(IngFecFin, fechaActual, IngRazMant,fechaActual);
        try{
            this.guardarObjeto(m);
        }
        catch(Exception e){
            System.out.println(e);
            this.guardarObjeto(m);
        }
        
        try{
            this.notificar();
            this.getForm().cerrarSesion();
        }
        catch(Exception e){
            System.out.println(e);
            this.getForm().cerrarSesion();
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
            Object[] fila = {auxModel.getRt(),auxModel.getIdRt(),auxModel.getTipoRT(),auxModel.getMarca(),auxModel.getModelo()};
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }
    
    public DefaultTableModel listarDatosTurno(DefaultTableModel modelTabla,Class clase,Set<SoporteTurno> list) {
        TreeSet<SoporteTurno> lista= new TreeSet();
        SoporteTurno auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext()) {
            auxModel =(SoporteTurno) it.next();
            lista.add(auxModel);
        }
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext()) {
            auxModel =(SoporteTurno) it2.next();
            Object[] fila = {auxModel.getTurno(),auxModel.getTurno().getFechaHoraInicio(),auxModel.getPc().getApellido()+", "+auxModel.getPc().getNombre(),auxModel.getPc().getCorreoElectronicoPersonal(),auxModel.getPc().getTelCelular()};//completar
            modelTabla.addRow(fila);  
        }
        return modelTabla;
    }  

    @Override
    public void suscribir(IObserverNotificacion o) {
       this.notificadores.add(o);
    }

    @Override
    public void eliminar(IObserverNotificacion o) {
        this.notificadores.remove(o);
    }

    @Override
    public void notificar() {
        for(int i=0; i<this.notificadores.size();i++){
            this.notificadores.get(i).notificarCientificos(this.emailCientifico,this.telefonoCientifico, IngRazMant);
        }
    }
    
}
