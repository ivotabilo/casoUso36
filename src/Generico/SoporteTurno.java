/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generico;

import Model.PersonalCientifico;
import Model.Turno;

/**
 *
 * @author Salocin0
 */
public class SoporteTurno implements Comparable<SoporteTurno>{
    private Turno turno;
    private PersonalCientifico pc;

    public Turno getTurno() {
        return turno;
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
