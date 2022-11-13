package InterfaceNotificaciones;

import java.util.List;

public interface IObserverNotificacion {
    public void notificarCientificos(List<String> email, List<String> whatsapp, String mensaje);
}
