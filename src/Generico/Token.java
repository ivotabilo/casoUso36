/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author sebac
 */
@Entity
public class Token {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Token_id_seq")
    @SequenceGenerator(name = "Token_id_seq", sequenceName = "Token_id_seq", allocationSize = 1)
    private Integer ID;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "token")
    private String token;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Token(Integer ID, String nombre, String token) {
        this.ID = ID;
        this.nombre = nombre;
        this.token = token;
    }

    public Token() {
    }
    
    
    
}
