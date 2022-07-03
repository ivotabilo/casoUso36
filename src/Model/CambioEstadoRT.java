/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
/**
 *
 * @author el negro
 */

@Entity
public class CambioEstadoRT implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CambioEstadoRT_id_seq")
    @SequenceGenerator(name = "CambioEstadoRT_id_seq", sequenceName = "CambioEstadoRT_id_seq", allocationSize = 1)
    private Integer ID;
    
    private Date fechaHoraDesde;
    private Date fechaHoraHasta;
    @ManyToOne(targetEntity = Estado.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaHoraDesde() {
        return fechaHoraDesde;
    }

    public void setFechaHoraDesde(Date fechaHoraDesde) {
        this.fechaHoraDesde = fechaHoraDesde;
    }

    public Date getFechaHoraHasta() {
        return fechaHoraHasta;
    }

    public void setFechaHoraHasta(Date fechaHoraHasta) {
        this.fechaHoraHasta = fechaHoraHasta;
    }
    //mostrarCambioEstadoRT
}
