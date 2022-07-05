/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generico;

import Model.RecursoTecnologico;

/**
 *
 * @author sebac
 */
public class SoporteRT /*implements Comparable<SoporteRT>*/{
    
    private RecursoTecnologico rt;
    private int idRt;
    private String tipoRT;
    private String marca;
    private String modelo;

    public int getIdRt() {
        return idRt;
    }

    public void setIdRt(int idRt) {
        this.idRt = idRt;
    }

    public RecursoTecnologico getRt() {
        return rt;
    }

    public void setRt(RecursoTecnologico rt) {
        this.rt = rt;
    }

    public String getTipoRT() {
        return tipoRT;
    }

    public void setTipoRT(String tipoRT) {
        this.tipoRT = tipoRT;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public SoporteRT(RecursoTecnologico rt, Integer idRt, String tipoRT, SoporteRT2 modeloMarca) {
        this.rt = rt;
        this.idRt = idRt;
        this.tipoRT = tipoRT;
        this.marca = modeloMarca.getMarca();
        this.modelo = modeloMarca.getModelo();
    }

    public SoporteRT() {
    }

    @Override
    public String toString() {
        return "SoporteRT{" + "rt=" + rt + ", idRt=" + idRt + ", tipoRT=" + tipoRT + ", marca=" + marca + ", modelo=" + modelo + '}';
    }

        
    
}
