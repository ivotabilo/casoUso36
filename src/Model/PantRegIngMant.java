package Model;

import Generico.SoporteRT;
import Generico.SoporteTurno;
import Model.RecursoTecnologico;
import Model.Sesion;
import Model.Turno;
import Modelos.ABMGn;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    //habilita pantalla
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
        //llama al gestor con un nuevo mantenimiento correctivo
        this.gl.nuevoIngMantCorre();
    }
    
    public void initializeTableRT(Set<SoporteRT> list) { 
        //se agregan las columnas correspondientes a los datos a mostrar
        modeloRT.addColumn("Numero");
        modeloRT.addColumn("Tipo RT");
        modeloRT.addColumn("Marca");
        modeloRT.addColumn("Modelo");
        //se agregan los datos
        traerDatosRT(modeloRT,RecursoTecnologico.class,this.tbRT,list);
    }
    
    public void initializeTableTurno(Set<SoporteTurno> list) { 
        //se agregan las columnas correspondientes a los datos a mostrar
        modeloTurnos.addColumn("ID");
        modeloTurnos.addColumn("Fecha Hora");
        modeloTurnos.addColumn("Cientifico");
        modeloTurnos.addColumn("Email");
        modeloTurnos.addColumn("Telefono");
        //se agregan los datos
        traerDatosTurno(modeloTurnos,Turno.class,this.tbTurnos,list);
    }
    
    public void traerDatosRT(DefaultTableModel modelo,Class clase,JTable tabla,Set<SoporteRT> list){
        limpiarTabla(modelo);
        //se agregan los datos al modelo
        modelo = this.gl.listarDatosRT(modelo,clase,list);
        //se muestra el modelo en la tabla
        tabla.setModel(modelo);
    }
    
    public void traerDatosTurno(DefaultTableModel modelo,Class clase,JTable tabla,Set<SoporteTurno> list){
        limpiarTabla(modelo);
         //se agregan los datos al modelo
        modelo = this.gl.listarDatosTurno(modelo,clase,list);
        //se muestra el modelo en la tabla
        tabla.setModel(modelo);
    }
    
    public void mostrarYSolSelRt(Set<SoporteRT> RT){
        //se guardan los datos de los recursos en la pantalla
        this.recursosTecnologicos=RT;
        //se inicializa la pantalla con los recursos
        this.initializeTableRT(this.recursosTecnologicos);
    }
    
    public void tomarSelRt(){
        //guardar en variable el rt seleccionado
        this.RtSel = (RecursoTecnologico) this.tbRT.getValueAt(tbRT.getSelectedRow(),0);
        //enviar al gestor el rt seleccioando
        this.gl.tomarSelRt(this.RtSel);
    }
    
    public void solIngFecFin(){
        //habilitar campos correspondientes
        this.txtFecFinMant.setEnabled(true);
    }
    
    public void solIngrRazMant(){
        //habilitar campos correspondientes
        this.txtRazMant.setEnabled(true);
        this.btnConfirmar.setEnabled(true);
    }
    
    public void tomarIngFecFin() {
        //guardar fecha en variable
        try {
            this.IngFecFin = new SimpleDateFormat("dd/MM/yyyy").parse(this.txtFecFinMant.getText());
        } catch (Exception e) {
            System.out.println("ERROR AL PARSEAR STRING TO DATE" + e);
        }
        
    }
    
    public void tomarIngRazMant(){
        //guardar razon en mantenimiento
        this.IngRazMant= this.txtRazMant.getText();
        
    }
    
    public void solConfirmacion(Set<SoporteTurno> turnosMostrar){
        //habilitar boton confirmar turno
        this.btnConfirmarTurno.setEnabled(true);
        //inicializar tabla turno
        initializeTableTurno(turnosMostrar);
        //mostrar turnos
    }
    
    public void solFormaNotificacion(){
        //habilitar campos correspondientes
        this.cbEmail.setEnabled(true);
        this.cbWhatsApp.setEnabled(true);
    }
    
    public void tomarSelFormaNotificacion(){
      //guardar en variable el tipo de notificacion seleccionado
      //llamar al gestor tomarselformanotificacion
      if (this.cbEmail.isSelected()== true && this.cbWhatsApp.isSelected()== true){
        this.gl.tomarSelFormaNotificacion("e+w");
      }if(this.cbEmail.isSelected()== true){
        this.gl.tomarSelFormaNotificacion("e");
      }else{
        this.gl.tomarSelFormaNotificacion("w");
      }
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
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
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
        cbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmailActionPerformed(evt);
            }
        });

        cbWhatsApp.setText("WhatsApp");
        cbWhatsApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbWhatsAppActionPerformed(evt);
            }
        });

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
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane4)
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
                .addContainerGap()
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       //se guarda el recurso en la pantalla
       this.tomarSelRt();
       this.btnSeleccionar.setEnabled(false);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        //tomar valores fecha fin mantenimiento, razon mantenimiento
        this.tomarIngFecFin();
        this.tomarIngRazMant();
        //enviar al gestor valores fecha fin mantenimiento, razon mantenimiento
        this.gl.tomarIngFecFin(IngFecFin);
        this.gl.tomarIngRazMant(IngRazMant);
        //desabilitar campos
        this.btnConfirmar.setEnabled(false);
        this.txtRazMant.setEnabled(false);
        this.txtFecFinMant.setEnabled(false);
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnConfirmarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTurnoActionPerformed
        //enviar confirmacion al gestor
        this.gl.tomarConfirmacion();
        //desabilitar boton
        this.btnConfirmarTurno.setEnabled(false);
    }//GEN-LAST:event_btnConfirmarTurnoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //toma tipo notificacion
        this.tomarSelFormaNotificacion();  
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        //cierra la sesion
        cerrarSesion();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmailActionPerformed
        this.btnAceptar.setEnabled(true);
    }//GEN-LAST:event_cbEmailActionPerformed

    private void cbWhatsAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbWhatsAppActionPerformed
        this.btnAceptar.setEnabled(true);
    }//GEN-LAST:event_cbWhatsAppActionPerformed

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
    
    public void cerrarSesion(){
        //crear sesion vacia
        Sesion s = new Sesion();
        //buscar sesion activa
        s=(Sesion) this.gl.buscarSesion(Sesion.class);
        Date fechaActual=new Date();
        //asignar fecha
        s.setFechafin(fechaActual);
        //guardar actualizacion
        this.gl.actualizarObjeto(s);
    }
}
