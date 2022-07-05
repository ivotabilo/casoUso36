/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generico;

/**
 *
 * @author sebac
 */
public class SoporteRT2 {
    
    private String modelo;
    private String marca;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public SoporteRT2(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }
    
    public SoporteRT2(){}
    
}
