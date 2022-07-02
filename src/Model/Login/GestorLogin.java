package Model.Login;

import Generico.GestorGn;
import Model.Usuario;

public class GestorLogin extends GestorGn {
    private PantLogin form;

    public PantLogin getForm() {
        return form;
    }

    public void setForm(PantLogin form) {
        this.form = form;
    }
    
    public boolean existeUsuario(){
        Usuario U;
        if(buscarUsuario(Usuario.class,this.getForm().getTxtCorreo().getText())==true){
            U = (Usuario) traerUsuario(Usuario.class,this.getForm().getTxtCorreo().getText(),1); 
            return String.valueOf(this.getForm().getTxtContraseña().getPassword()).equals(U.getContrasenia());
        }
        return false;
    }
    
    public void open() {
        setForm(new PantLogin());
        getForm().setVisible(true); 
    }
}
