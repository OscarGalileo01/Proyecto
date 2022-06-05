/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author O S C A R
 */
public class gerenteEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form gerenteEmpleado
     */
    public gerenteEmpleado() {
        initComponents();
        conectarBD();
        initCombo();

        //getInformacionEmpleado();
    }

    private void conectarBD() {
        try {
            //1ºCrear el objeto Connection
            conexion = null;
            conexion = Conexion.mySQL("fruteria4", "root", "");
            if (conexion == null) {
                JOptionPane.showMessageDialog(this, "ERROR, ha sido posible conectar con la BD");
                System.exit(0);
            }
            //2ºCrear el objeto Statement

            sentenciaEmpleados = conexion.createStatement();
            sentenciaModificar = conexion.createStatement();
            sentenciaDespedir = conexion.createStatement();
            sentenciaDNI = conexion.createStatement();
            sentenciaAddEmpleado = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initCombo() {

        empleado e;

        try {

            String sql = "SELECT * FROM `empleados` WHERE contratado = true;";
            resultadoEmpleados = sentenciaEmpleados.executeQuery(sql);

            while (resultadoEmpleados.next()) {

                int id = resultadoEmpleados.getInt(1);
                String dni = resultadoEmpleados.getString(2);
                String nombre = resultadoEmpleados.getString(3);
                String clave = resultadoEmpleados.getString(4);
                int cargo = resultadoEmpleados.getInt(5);
                double salario = resultadoEmpleados.getDouble(6);
                int contratado = resultadoEmpleados.getInt(7);

                e = new empleado(id, dni, nombre, clave, cargo, salario, contratado);//Creamos empleado

                comboEmpleados.addItem(e);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBTN = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObjeciones = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        comboEmpleados = new javax.swing.JComboBox<>();
        panelInformacion = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfSalario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfCargo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfClave = new javax.swing.JTextField();
        rbModificar = new javax.swing.JRadioButton();
        rbDespedir = new javax.swing.JRadioButton();
        btnModificar = new javax.swing.JButton();
        btnDespedir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbAdd = new javax.swing.JRadioButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtObjeciones.setColumns(20);
        txtObjeciones.setRows(5);
        jScrollPane1.setViewportView(txtObjeciones);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel11.setText("Seleccionar Empleado");

        comboEmpleados.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        comboEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEmpleadosActionPerformed(evt);
            }
        });

        panelInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N
        panelInformacion.setLayout(new java.awt.GridLayout(6, 2, 10, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel9.setText("id");
        panelInformacion.add(jLabel9);

        lblId.setBackground(new java.awt.Color(255, 255, 255));
        lblId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblId.setOpaque(true);
        panelInformacion.add(lblId);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setText("Nombre");
        panelInformacion.add(jLabel1);

        txfNombre.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        panelInformacion.add(txfNombre);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("DNI");
        panelInformacion.add(jLabel2);

        txfDNI.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        panelInformacion.add(txfDNI);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("Salario");
        panelInformacion.add(jLabel3);

        txfSalario.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        panelInformacion.add(txfSalario);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setText("Cargo");
        panelInformacion.add(jLabel4);

        txfCargo.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        panelInformacion.add(txfCargo);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel5.setText("Clave");
        panelInformacion.add(jLabel5);

        txfClave.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        panelInformacion.add(txfClave);

        grupoBTN.add(rbModificar);
        rbModificar.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rbModificar.setText("Modificar");
        rbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbModificarActionPerformed(evt);
            }
        });

        grupoBTN.add(rbDespedir);
        rbDespedir.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rbDespedir.setText("Despedir");
        rbDespedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDespedirActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnModificar.setText("Confirmar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDespedir.setBackground(new java.awt.Color(255, 0, 0));
        btnDespedir.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnDespedir.setText("Despedir");
        btnDespedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespedirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Causa:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 25)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("EMPLEADOS");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 17)); // NOI18N
        jLabel8.setText("Eliga una opcion: ");

        grupoBTN.add(rbAdd);
        rbAdd.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rbAdd.setText("Añadir");
        rbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAddActionPerformed(evt);
            }
        });

        btnAtras.setText("<");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(panelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbAdd)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDespedir)))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(30, 30, 30)
                                .addComponent(rbModificar)
                                .addGap(34, 34, 34)
                                .addComponent(rbDespedir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbModificar)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAdd)
                    .addComponent(rbDespedir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnDespedir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(btnModificar)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEmpleadosActionPerformed

        if (comboEmpleados.getItemCount() == 0) {

        } else {
            empleado e = (empleado) comboEmpleados.getSelectedItem();   //Obtenemos empleado del comoBox y establecemos su informacion

            lblId.setText(e.getId() + "");
            txfNombre.setText(e.getNombre());
            txfDNI.setText(e.getDni());
            txfSalario.setText(e.getSalario() + "");
            txfCargo.setText(e.getCargo()+"");
            txfClave.setText(e.getClave());
        }
    }//GEN-LAST:event_comboEmpleadosActionPerformed

    private void rbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbModificarActionPerformed
        if (rbModificar.isSelected()) {
            txtObjeciones.setEnabled(false);
            btnDespedir.setEnabled(false);

            txfNombre.setEnabled(true);
            txfDNI.setEnabled(true);
            txfSalario.setEnabled(true);
            txfCargo.setEnabled(true);
            txfClave.setEnabled(true);

        }
    }//GEN-LAST:event_rbModificarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (rbAdd.isSelected()) {   //Si se elige opcion de añadir empleado

            //boolean b = validarCampos();    //Comprobamos que los datos han sido rellenados

            //if (b == false) {
             //   JOptionPane.showMessageDialog(this, "Rellene todos los datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
           // } else if(b==true){
            System.out.println("vwlwjenclw");
                int n = validarDNI(txfDNI.getText());
                System.out.println(n);
                if (n == 0) {
                    String dni = txfDNI.getText();
                    String nombre = txfNombre.getText();
                    double salario = Double.parseDouble(txfSalario.getText());
                    String clave = txfClave.getText();
                    int cargo = Integer.parseInt(txfCargo.getText());

                    if (cargo >= 1 && cargo <= 2) {
                        try {
                            String sql = "INSERT INTO `empleados`(`DNI`, `nombre`, `clave`, `cod_cargo`, `salario`, `contratado`) VALUES ('" + dni + "','" + nombre + "','" + clave + "'," + cargo + "," + salario + ",true);";
                            sentenciaAddEmpleado.executeUpdate(sql);
                            JOptionPane.showMessageDialog(this, "Empleado contratado", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
                            
                            comboEmpleados.removeAllItems();
                            initCombo();
                            limpiarCampos();

                        } catch (SQLException ex) {
                            Logger.getLogger(gerenteEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Cargo no existente, 1-Gerente 2-Vendedor", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    JOptionPane.showMessageDialog(this, "DNI ya registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            //}

        } else if (rbModificar.isSelected()) { //Si se elige opcion de modificar
            if (comboEmpleados.getItemCount() == 0) {   //Si no hay clientes(para que no salte excepcion)

            } else {
                try {
                    String dni = txfDNI.getText();
                    String nombre = txfNombre.getText();
                    String clave = txfClave.getText();
                    int cargo = Integer.parseInt(txfCargo.getText());
                    double salario = Double.parseDouble(txfSalario.getText());
                    int id = Integer.parseInt(lblId.getText());
                    String sql = "UPDATE `empleados` SET `DNI`='" + dni + "',`nombre`='" + nombre + "',`clave`='" + clave + "',`cod_cargo`=" + cargo + ",`salario`=" + salario + " WHERE id = " + id;
                    int filas = sentenciaModificar.executeUpdate(sql);

                    //Filas acumula el numero de filas que se han modificado, en este caso tiene que ser una. Si fila == 1 se ha cumplido el update, sino no
                    if (filas == 1) {
                        JOptionPane.showMessageDialog(this, "Empleado actualizado", "Operacion realizada", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(gerenteEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void rbDespedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDespedirActionPerformed
        if (rbDespedir.isSelected()) {

            txtObjeciones.setEnabled(true);
            btnDespedir.setEnabled(true);

            txfNombre.setEnabled(false);
            txfDNI.setEnabled(false);
            txfSalario.setEnabled(false);
            txfCargo.setEnabled(false);
            txfClave.setEnabled(false);

            txtObjeciones.requestFocus();
        }
    }//GEN-LAST:event_rbDespedirActionPerformed

    private void btnDespedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespedirActionPerformed

        try {
            String sql = "UPDATE `empleados` SET `contratado`= false WHERE id = " + Integer.parseInt(lblId.getText());
            sentenciaDespedir.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(gerenteEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtObjeciones.removeAll();
        comboEmpleados.removeAllItems();
        initCombo();

    }//GEN-LAST:event_btnDespedirActionPerformed

    public int validarDNI(String dni) {
        int n = 0;
        try {
            String sql = "SELECT COUNT(*) FROM `empleados` WHERE empleados.DNI='" + dni + "'; ";
            resultadoDNI = sentenciaDNI.executeQuery(sql);
            while (resultadoDNI.next()) {
                n += resultadoDNI.getInt(1);
                return n;
            }
        } catch (SQLException ex) {
            Logger.getLogger(gerenteEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public boolean validarCampos() {
        if (txfNombre.getText().isEmpty() || txfDNI.getText().isEmpty() || txfClave.getText().isEmpty() || txfSalario.getText().isEmpty() || txfCargo.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        txfNombre.setText("");
        txfDNI.setText("");
        txfSalario.setText("");
        txfClave.setText("");
        txfCargo.setText("");
    }

    private void rbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAddActionPerformed
        //Limpoamos textFields
        limpiarCampos();

        //Activamos textFields
        txfNombre.setEnabled(true);
        txfDNI.setEnabled(true);
        txfSalario.setEnabled(true);
        txfCargo.setEnabled(true);
        txfClave.setEnabled(true);

        TextPrompt prompt = new TextPrompt("1-Gerente  2-Vendedor", txfCargo);//Placeholder
    }//GEN-LAST:event_rbAddActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        gerente form = new gerente();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gerenteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gerenteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gerenteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gerenteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gerenteEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnDespedir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<empleado> comboEmpleados;
    private javax.swing.ButtonGroup grupoBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JRadioButton rbAdd;
    private javax.swing.JRadioButton rbDespedir;
    private javax.swing.JRadioButton rbModificar;
    private javax.swing.JTextField txfCargo;
    private javax.swing.JTextField txfClave;
    private javax.swing.JTextField txfDNI;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfSalario;
    private javax.swing.JTextArea txtObjeciones;
    // End of variables declaration//GEN-END:variables
     private java.sql.Connection conexion;
    private java.sql.Statement sentenciaEmpleados;
    private java.sql.ResultSet resultadoEmpleados;

    private java.sql.Statement sentenciaModificar;
    private java.sql.Statement sentenciaDespedir;

    private java.sql.Statement sentenciaDNI;
    private java.sql.ResultSet resultadoDNI;

    private java.sql.Statement sentenciaAddEmpleado;

}
