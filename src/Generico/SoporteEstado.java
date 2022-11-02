package Generico;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class SoporteEstado {
    CambioEstadoRT cert= new CambioEstadoRT();
    List<CambioEstadoTurno> lcet= new ArrayList<>();
    List<Turno> lt= new ArrayList<>();
    
    public SoporteEstado(CambioEstadoRT cert, List<CambioEstadoTurno> lcet, List<Turno> lt){
        this.cert=cert;
        this.lcet=lcet;
        this.lt=lt;
    }

    public CambioEstadoRT getCert() {
        return cert;
    }

    public void setCert(CambioEstadoRT cert) {
        this.cert = cert;
    }

    public List<CambioEstadoTurno> getLcet() {
        return lcet;
    }

    public void setLcet(List<CambioEstadoTurno> lcet) {
        this.lcet = lcet;
    }

    public List<Turno> getLt() {
        return lt;
    }

    public void setLt(List<Turno> lt) {
        this.lt = lt;
    }
    
}
