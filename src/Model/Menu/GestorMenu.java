
package Model.Menu;

import Generico.GestorGn;



public class GestorMenu extends GestorGn {
    private PantMenu form;

    public PantMenu getForm() {
        return form;
    }

    public void setForm(PantMenu form) {
        this.form = form;
    }
    public void open() {
        setForm(new PantMenu());
        this.getForm().setMenu(this);
        getForm().setVisible(true); 
    }
}
