package Generico;

import Model.PersonalCientifico;
import Model.Turno;

public class SoporteTurno implements Comparable<SoporteTurno>{
    private Turno turno;
    private PersonalCientifico pc;

    public Turno getTurno() {
        return turno;
    }

    public String getEmail(){
        return this.pc.getCorreoElectronicoInstitucional();
    }

    public String getTelefono(){
        return this.pc.getTelCelular()+"";
    }
    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public PersonalCientifico getPc() {
        return pc;
    }

    public void setPc(PersonalCientifico pc) {
        this.pc = pc;
    }

    public SoporteTurno(Turno turno, PersonalCientifico pc) {
        this.turno = turno;
        this.pc = pc;
    }
    
    @Override
    public int compareTo(SoporteTurno o) {
        SoporteTurno p=(SoporteTurno) o;
        return (this.pc.getApellido()+", "+this.pc.getNombre()).compareTo(p.pc.getApellido()+", "+this.pc.getNombre());
    }

}
