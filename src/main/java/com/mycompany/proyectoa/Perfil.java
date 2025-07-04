/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoa;

import javax.swing.JOptionPane;

/**
 *
 * @author diego-lopez
 */
public class Perfil extends javax.swing.JFrame {
    String usuarioLogeado;

    /**
     * Creates new form Perfil
     */
    public Perfil(String usuarioLogeado) {
        initComponents();
        this.usuarioLogeado = usuarioLogeado;
        
        boolean existe = false;
        
        for( Usuario u: ProyectoFinal.usuarios )
        {
            if( u.usuario.equals(usuarioLogeado) ) 
            {
                existe = true;
                
                jTextfieldNombre.disable();
                jTextfieldNombre.setText(u.nombre);
                jTextfieldPassword.setText(u.password);
                jTextfieldUsuario.disable();
                jTextfieldUsuario.setText(u.usuario);
                
                jTextfieldRole.disable();
                if( u.rol.equals("A") ){
                    jTextfieldRole.setText("Administrador");
                }else if( u.rol.equals("V")){
                    jTextfieldRole.setText("Vendedor");
                }else{
                    jTextfieldRole.setText("Error");
                }
            }
        }
        
        if( existe == false )
        {
            JOptionPane.showMessageDialog(this, "Usuario o password invalido.");
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

        jLabel1 = new javax.swing.JLabel();
        jTextfieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextfieldPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextfieldUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextfieldRole = new javax.swing.JTextField();
        jButtonCambiarPassword = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi Perfil");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Password:");

        jLabel3.setText("Usuario:");

        jLabel4.setText("Role:");

        jButtonCambiarPassword.setText("Cambiar Password");
        jButtonCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarPasswordActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextfieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextfieldUsuario)
                        .addGap(15, 15, 15))
                    .addComponent(jTextfieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCambiarPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTextfieldRole, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap(247, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jTextfieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextfieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextfieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextfieldRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCambiarPassword)
                    .addComponent(jButtonSalir))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addContainerGap(129, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarPasswordActionPerformed
        boolean existe = false;
        String nuevoPassword;
        nuevoPassword = jTextfieldPassword.getText();
        UsuarioNuevo un = new UsuarioNuevo();
        
        for( Usuario u: ProyectoFinal.usuarios )
        {
            if( u.usuario.equals(usuarioLogeado) ) 
            {
                existe = true;
                
                if( un.LargoPassword(nuevoPassword) == true 
                    && un.CantidadMayusculasPassword( nuevoPassword ) == true 
                    && un.CantidadMinusculasPassword( nuevoPassword ) == true  
                    && un.CantidadNumerosPassword( nuevoPassword ) == true)
                {
                    u.password = nuevoPassword;
                
                    JOptionPane.showMessageDialog(this, "Password modificado exitosamente");
                }
            }
        }
        
        if( existe == false )
        {
            JOptionPane.showMessageDialog(this, "Usuario o password invalido.");
        }     
    }//GEN-LAST:event_jButtonCambiarPasswordActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
            this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCambiarPassword;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextfieldNombre;
    private javax.swing.JTextField jTextfieldPassword;
    private javax.swing.JTextField jTextfieldRole;
    private javax.swing.JTextField jTextfieldUsuario;
    // End of variables declaration//GEN-END:variables
}
