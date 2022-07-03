
package Model;

import java.util.ArrayList;


public class Marca {
    private Integer ID;
    private String nombre;
    private ArrayList<Modelo> modelo;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca(String nombre, String nombreModelo) {
        this.nombre = nombre;
        this.modelo.add(new Modelo(nombreModelo));
    }
    
    
}
