/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import InterfaceNotificaciones.Notificaciones;

/**
 *
 * @author sebac
 */
public class InterfazWhatsapp {
    public void notificarCientifico(String numeroPhone, String mensaje){
        Notificaciones n = new Notificaciones();
        n.notificacionWhatsapp(numeroPhone, mensaje);
    }
}
