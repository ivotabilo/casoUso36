package Model;

import Generico.SoporteRT;
import Generico.SoporteRT2;
import Modelos.ABMGn;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PantRegIngMant extends ABMGn {
    DefaultTableModel modeloRT = new DefaultTableModel();
    DefaultTableModel modeloTurnos = new DefaultTableModel();
    GestorRegIngMant gl;
    private Set<SoporteRT> recursosTecnologicos;
    private RecursoTecnologico RtSel;
    private Date IngFecFin;
    private String IngRazMant;
    private String tipoNotificacion;

    public GestorRegIngMant getGestor() {
        if (gl == null) {
           synchronized (GestorRegIngMant.class) {
                gl = new GestorRegIngMant();
                gl.setForm(this);
           }
        }
        return gl;
    }
    
    public void setGestor(GestorRegIngMant g){
        this.gl=g;
    }
    
    public PantRegIngMant() {
        initComponents();
    }
    
    public void opcRecIngMantCorrectivo(){
        this.habilitarPantalla();
    }
    
    public void habilitarPantalla(){
        //bloquear vista para seleccion de RT
        this.btnAceptar.setEnabled(false);
        this.btnConfirmar.setEnabled(false);
        this.txtFecFinMant.setEnabled(false);
        this.txtRazMant.setEnabled(false);
        this.tbTurnos.setEnabled(false);
        this.cbEmail.setEnabled(false);
        this.cbWhatsApp.setEnabled(false);
        this.btnConfirmarTurno.setEnabled(false);
        this.panelMant.setEnabled(false);
        this.panelNotificaciones.setEnabled(false);
        this.panelTurnos.setEnabled(false);
//bloquear paneles
        
        this.gl.nuevoIngMantCorre();
        //to-do
    }
    
    public void initializeTableRT(Set<SoporteRT> list) { 
        modeloRT.addColumn("Objeto");
        modeloRT.addColumn("Numero");
        modeloRT.addColumn("Tipo RT");
        modeloRT.addColumn("Marca");
        modeloRT.addColumn("Modelo");
        traerDatosRT(modeloRT,RecursoTecnologico.class,this.tbRT,list);
    }
    
    public void initializeTableTurno(Set<SoporteRT2> list) { 
        modeloTurnos.addColumn("Objeto");
        modeloTurnos.addColumn("ID");
        modeloTurnos.addColumn("Nombre");
        modeloTurnos.addColumn("Descripcion");
        modeloTurnos.addColumn("Precio");
        modeloTurnos.addColumn("Categoria");
        modeloTurnos.addColumn("Comercio");
        traerDatosTurno(modeloTurnos,Turno.class,this.tbTurnos,list);
    }
    
    public void traerDatosRT(DefaultTableModel modelo,Class clase,JTable tabla,Set<SoporteRT> list){
        limpiarTabla(modelo);
        modelo = this.gl.listarDatosRT(modelo,clase,list);
        tabla.setModel(modelo);
    }
    
    public void traerDatosTurno(DefaultTableModel modelo,Class clase,JTable tabla,Set<SoporteRT2> list){
        limpiarTabla(modelo);
        modelo = this.gl.listarDatosTurno(modelo,clase,list);
        tabla.setModel(modelo);
    }
    
    public void mostrarYSolSelRt(Set<SoporteRT> RT){
        //to-do (guardar en variable)
        //mostrar los recursos en pantall
        this.recursosTecnologicos=RT;
        this.initializeTableRT(this.recursosTecnologicos);
        
        
    }
    
    public void tomarSelRt(){
        this.RtSel = (RecursoTecnologico) this.tbRT.getValueAt(tbRT.getSelectedRow(),0);
        //guardar en variable el rt seleccionado
        //enviar al gestor el rt seleccioando
        this.gl.tomarSelRt(this.RtSel);
        //to-do (guardar en variable)
    }
    
    public void solIngFecFin(){
        //to-do (habilitar campo)
        this.txtFecFinMant.setEnabled(true);
        //habilitar campos correspondientes
        
    }
    
    public void solIngrRazMant(){
        //to-do (habilitar campo)
        //habilitar campos correspondientes
        this.txtRazMant.setEnabled(true);
        this.btnConfirmar.setEnabled(true);
    }
    
    public void tomarIngFecFin(){
        //to-do (guardar en variable)
        //guardar fecha en variable
        //this.IngFecFin= this.txtFecFinMant.getText(); //terminar
    }
    
    public void tomarIngRazMant(){
        //to-do (guardar en variable)
        this.IngRazMant= this.txtRazMant.getText();
        
    }
    
    public void solConfirmacion(List<Turno> turnosMostrar){
        
        this.btnConfirmarTurno.setEnabled(true);
        //to-do (habilitar campo)
        //habilitar pantalla correspondiente
        //mostrar turnos
        
    }
    
    public void solFormaNotificacion(){
        //to-do (habilitar campo)
        //habilitar campos correspondientes
        
        this.cbEmail.setEnabled(true);
        this.cbWhatsApp.setEnabled(true);
        
    }
    
    public void tomarSelFormaNotificacion(){
      if (this.cbEmail.isSelected()== true){
        this.tipoNotificacion="Email"; //to-do (guardar en variable)
        //guardar en variable el tipo de notificacion seleccionado
        //llamar al gestor tomarselformanotificacion
       }else{
          this.tipoNotificacion="WhatsApp";
      }
      this.gl.tomarSelFormaNotificacion(tipoNotificacion);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRT = new javax.swing.JPanel();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRT = new javax.swing.JTable();
        panelMant = new javax.swing.JPanel();
        lbFecFinMant = new javax.swing.JLabel();
        txtFecFinMant = new javax.swing.JTextField();
        lbRazMant = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRazMant = new javax.swing.JTextArea();
        btnConfirmar = new javax.swing.JButton();
        panelNotificaciones = new javax.swing.JPanel();
        cbEmail = new javax.swing.JCheckBox();
        cbWhatsApp = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelTurnos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTurnos = new javax.swing.JTable();
        btnConfirmarTurno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRT.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Recurso Tecnologico"));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tbRT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbRT);

        javax.swing.GroupLayout panelRTLayout = new javax.swing.GroupLayout(panelRT);
        panelRT.setLayout(panelRTLayout);
        panelRTLayout.setHorizontalGroup(
            panelRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRTLayout.setVerticalGroup(
            panelRTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMant.setBorder(javax.swing.BorderFactory.createTitledBorder("Mantenimiento"));

        lbFecFinMant.setText("Fecha fin");

        txtFecFinMant.setToolTipText("DD/MM/AAAA");
        txtFecFinMant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecFinMantActionPerformed(evt);
            }
        });

        lbRazMant.setText("Razon");

        txtRazMant.setColumns(20);
        txtRazMant.setRows(5);
        jScrollPane2.setViewportView(txtRazMant);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMantLayout = new javax.swing.GroupLayout(panelMant);
        panelMant.setLayout(panelMantLayout);
        panelMantLayout.setHorizontalGroup(
            panelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMantLayout.createSequentialGroup()
                        .addGroup(panelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFecFinMant)
                            .addComponent(txtFecFinMant, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRazMant))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMantLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMantLayout.setVerticalGroup(
            panelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFecFinMant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecFinMant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRazMant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelNotificaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Notificacion"));

        cbEmail.setText("Email");

        cbWhatsApp.setText("WhatsApp");

        javax.swing.GroupLayout panelNotificacionesLayout = new javax.swing.GroupLayout(panelNotificaciones);
        panelNotificaciones.setLayout(panelNotificacionesLayout);
        panelNotificacionesLayout.setHorizontalGroup(
            panelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbEmail)
                    .addComponent(cbWhatsApp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNotificacionesLayout.setVerticalGroup(
            panelNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbWhatsApp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        panelTurnos.setBorder(javax.swing.BorderFactory.createTitledBorder("Turnos"));

        tbTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbTurnos);

        btnConfirmarTurno.setText("Confirmar");
        btnConfirmarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTurnosLayout = new javax.swing.GroupLayout(panelTurnos);
        panelTurnos.setLayout(panelTurnosLayout);
        panelTurnosLayout.setHorizontalGroup(
            panelTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTurnosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelTurnosLayout.setVerticalGroup(
            panelTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelMant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelNotificaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addComponent(panelTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
       this.tomarSelRt();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        this.tomarIngFecFin();
        this.tomarIngRazMant();
        this.gl.tomarIngFecFin(IngFecFin);
        this.gl.tomarIngRazMant(IngRazMant);              //llamar a los metodos del gestor tomar ingfecfin y tomaringrazmant
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtFecFinMantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecFinMantActionPerformed
        this.tomarIngFecFin();        // TODO add your handling code here:
    }//GEN-LAST:event_txtFecFinMantActionPerformed

    private void btnConfirmarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTurnoActionPerformed
        this.gl.tomarConfirmacion();
    }//GEN-LAST:event_btnConfirmarTurnoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.tomarSelFormaNotificacion();                // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantRegIngMant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantRegIngMant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantRegIngMant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantRegIngMant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantRegIngMant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnConfirmarTurno;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JCheckBox cbEmail;
    private javax.swing.JCheckBox cbWhatsApp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbFecFinMant;
    private javax.swing.JLabel lbRazMant;
    private javax.swing.JPanel panelMant;
    private javax.swing.JPanel panelNotificaciones;
    private javax.swing.JPanel panelRT;
    private javax.swing.JPanel panelTurnos;
    private javax.swing.JTable tbRT;
    private javax.swing.JTable tbTurnos;
    private javax.swing.JTextField txtFecFinMant;
    private javax.swing.JTextArea txtRazMant;
    // End of variables declaration//GEN-END:variables

    
}
