package InterfaceNotificaciones;

public interface ISujetoNotificacion {
    public void suscribir(IObserverNotificacion o);
    public void eliminar(IObserverNotificacion o);
    public void notificar();
}
