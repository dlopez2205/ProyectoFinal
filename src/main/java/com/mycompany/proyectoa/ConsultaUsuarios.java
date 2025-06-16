/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoa;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author diego-lopez
 */
public class ConsultaUsuarios extends javax.swing.JFrame {
    
    private Usuario usuario;

    /**
     * Creates new form ConsultaUsuarios
     */
    public ConsultaUsuarios() 
    {
        initComponents();
        pintarTabla();
        
        jComboBoxRol.removeAllItems();
        jComboBoxRol.addItem("Administrador");
        jComboBoxRol.addItem("Vendedor");
        
        jComboBoxEstado.removeAllItems();
        jComboBoxEstado.addItem("Activo");
        jComboBoxEstado.addItem("Inactivo");
        jComboBoxEstado.addItem("Eliminado");


    }
    
    private void pintarTabla() {
        
        String encabezado[] = {"Nombre","Usuario" , "Password" , "Rol", "Estado"};
        DefaultTableModel t = new DefaultTableModel(encabezado, ProyectoFinal.usuarios.size());
        jTableUsuarios.setModel(t);
        TableModel tabla = jTableUsuarios.getModel();

        for(int i = 0; i < ProyectoFinal.usuarios.size();i++) {
            Usuario u = ProyectoFinal.usuarios.get(i);
            tabla.setValueAt(u.nombre, i, 0);
            tabla.setValueAt(u.usuario, i, 1);
            tabla.setValueAt(u.password, i, 2);
            tabla.setValueAt(u.rol, i, 3);
            tabla.setValueAt(u.estado, i, 4);
            
            
        }                
    }
    
    private void guardar()
    {
        String nuevoPassword;
        nuevoPassword = jTextfieldPassword.getText();
        UsuarioNuevo un = new UsuarioNuevo();   
        
        if( usuario != null ){

            if( jTextfieldNombre.getText().isEmpty() == false )
            {
                usuario.nombre = jTextfieldNombre.getText();
            }else{
                JOptionPane.showMessageDialog(this, "Nombre vacio!!!");
                return;
            }

            if( jTextfieldPassword.getText().isEmpty() == false ) {
                
                //if( un.LargoPassword(nuevoPassword) == true 
                //    && un.CantidadMayusculasPassword( nuevoPassword ) == true 
                //    && un.CantidadMinusculasPassword( nuevoPassword ) == true  
                //    && un.CantidadNumerosPassword( nuevoPassword ) == true)
                //{

                    usuario.password = jTextfieldPassword.getText();
                //}else {
                //    return;
                //}
                    

            }else {
                JOptionPane.showMessageDialog(this, "Password vacio!!!");
                return;
            }

            if( jTextfieldUsuario.getText().isEmpty() == false) {

                usuario.usuario = jTextfieldUsuario.getText();

            }else {

                JOptionPane.showMessageDialog(this, "Usuario vacio!!!");
                return;
            }
            String rol = jComboBoxRol.getSelectedItem().toString();
            
            if(rol.equals("Administrador")){
                usuario.rol = "A";
                
            }else {
                usuario.rol = "V";
            }
            
            usuario.estado = jComboBoxEstado.getSelectedItem().toString();
            
            pintarTabla();
            JOptionPane.showMessageDialog(this, "Usuario modificado exitosamente");
            jTextfieldNombre.setText("");
            jTextfieldUsuario.setText("");
            jTextfieldPassword.setText("");
            jComboBoxRol.setSelectedIndex(-1);
            jComboBoxEstado.setSelectedIndex(-1);
            jTextfieldNombre.enable();
            jTextfieldUsuario.enable();
            jTextfieldPassword.enable();
            jComboBoxRol.enable();
            jComboBoxEstado.enable();
        }        
    }
    
    private void eliminar()
    {
        jTableUsuarios.getSelectedRow();
    
        int eliminar = jTableUsuarios.getSelectedRow();
    
        if(eliminar > 0) 
        {
            if(JOptionPane.showConfirmDialog(this, "Esta seguro de elimar")== 0)
            {
                ProyectoFinal.usuarios.remove(eliminar);
                pintarTabla();
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un usuario valido para elimirar");
        }
        
    }
    
    private void eliminarNuevoCambio()
    {
       if(jTableUsuarios.getSelectedRow() >= 0)
       {           
           usuario = ProyectoFinal.usuarios.get(jTableUsuarios.getSelectedRow());
           jTextfieldNombre.setText(usuario.nombre);
           jTextfieldNombre.disable();
           jTextfieldUsuario.setText(usuario.usuario);
           jTextfieldUsuario.disable();
           jTextfieldPassword.setText(usuario.password);
           jTextfieldPassword.disable();
           
           if(usuario.rol.equals("A"))
           {
               jComboBoxRol.setSelectedIndex(0);
               
           }else {
               
               jComboBoxRol.setSelectedIndex(1);
           }
           jComboBoxEstado.setSelectedIndex(2);
           
           jComboBoxRol.disable();
           jComboBoxEstado.disable();
       }        
    }
    
    private void modificar()
    {
       if(jTableUsuarios.getSelectedRow() >= 0)
       {
           
           usuario = ProyectoFinal.usuarios.get(jTableUsuarios.getSelectedRow());
           jTextfieldNombre.setText(usuario.nombre);
           jTextfieldUsuario.setText(usuario.usuario);
           jTextfieldPassword.setText(usuario.password);
           if(usuario.rol.equals("A"))
           {
               jComboBoxRol.setSelectedIndex(0);
               
           }else {
               
               jComboBoxRol.setSelectedIndex(1);
           }
           
           for(int i = 0; i < jComboBoxEstado.getItemCount(); i++) {
               if(usuario.estado.equalsIgnoreCase(jComboBoxEstado.getItemAt(i))) {
                   jComboBoxEstado.setSelectedIndex(i);
               }
           }              
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonSalir = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextfieldNombre = new javax.swing.JTextField();
        jTextfieldUsuario = new javax.swing.JTextField();
        jComboBoxRol = new javax.swing.JComboBox<>();
        jTextfieldPassword = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableUsuarios);

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Borrar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Usuarios:");

        jLabel3.setText("Password:");

        jLabel4.setText("Rol:");

        jTextfieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextfieldNombreActionPerformed(evt);
            }
        });

        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRolActionPerformed(evt);
            }
        });

        jTextfieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextfieldPasswordActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextfieldUsuario))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextfieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextfieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSalir)))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(316, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalir)
                            .addComponent(jButtonEliminar)
                            .addComponent(jButtonModificar))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextfieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextfieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextfieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addComponent(jButtonGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        //eliminar();
        eliminarNuevoCambio();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jComboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRolActionPerformed

    }//GEN-LAST:event_jComboBoxRolActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        modificar();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTextfieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextfieldPasswordActionPerformed
    }//GEN-LAST:event_jTextfieldPasswordActionPerformed

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jTextfieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextfieldNombreActionPerformed

    }//GEN-LAST:event_jTextfieldNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextfieldNombre;
    private javax.swing.JTextField jTextfieldPassword;
    private javax.swing.JTextField jTextfieldUsuario;
    // End of variables declaration//GEN-END:variables
}
