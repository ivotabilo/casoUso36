package Generico;

public class FrmGenerica extends javax.swing.JInternalFrame  implements Vistas {

    public FrmGenerica() {
        initComponents();
    }

    public void viewEditarEnter() {
    }

    public void viewNuevoEnter() {  
    }

    public void setBusqueda(Object model){
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void cargarCombos() {
    }

    @Override
    public void clearView() {
    }

    @Override
    public void onViewOpened() {
    }

    @Override
    public void cancelarView(){
    }
    
    @Override
    public void deleteView(){
    }
    
    @Override
    public void saveView() {
    }

    @Override
    public void setView() {
    }
    
    @Override
    public void viewCamposEnabled(Boolean tipo) {
    }

    @Override
    public void viewEliminar() {
    }

    @Override
    public void viewGuardar() {
    }

    public boolean isOnlyRead() {
        return false;
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
