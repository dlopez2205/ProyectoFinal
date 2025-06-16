/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoa;

/**
 *
 * @author diego-lopez
 */
public class VentanaAdmin extends javax.swing.JFrame {
    String usuarioLogeado;

    /**
     * Creates new form VentanaAdmin
     */
    public VentanaAdmin(String usuario) {
        this.usuarioLogeado = usuario;
        initComponents();
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuLibro = new javax.swing.JMenu();
        jMenuLibroCrear = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuLibroConsultar = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItemExportarLibrosJSON = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemCargar = new javax.swing.JMenuItem();
        jMenuVentanaAdmin = new javax.swing.JMenu();
        jMenuUsuarioCrear = new javax.swing.JMenuItem();
        jMenuUsuarioConsultar = new javax.swing.JMenuItem();
        jMenuItemCargarUsuarios = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemProvedores = new javax.swing.JMenuItem();
        jMenuItemConsultarProveedores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu2.setText("Mi Perfil");

        jMenuItem3.setText("Datos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenuLibro.setText("Libro(s)");

        jMenuLibroCrear.setText("Crear");
        jMenuLibroCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLibroCrearActionPerformed(evt);
            }
        });
        jMenuLibro.add(jMenuLibroCrear);

        jMenuItem9.setText("Exportar XML");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenuLibro.add(jMenuItem9);

        jMenuLibroConsultar.setText("Consultar");
        jMenuLibroConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLibroConsultarActionPerformed(evt);
            }
        });
        jMenuLibro.add(jMenuLibroConsultar);

        jMenuItem4.setText("Cargar Json");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuLibro.add(jMenuItem4);

        jMenuItem8.setText("Exportar CVS");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuLibro.add(jMenuItem8);

        jMenuItemExportarLibrosJSON.setText("Exportar JSON");
        jMenuItemExportarLibrosJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarLibrosJSONActionPerformed(evt);
            }
        });
        jMenuLibro.add(jMenuItemExportarLibrosJSON);

        jMenuBar1.add(jMenuLibro);

        jMenu1.setText("Cupon(es)");

        jMenuItem1.setText("Crear");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Consultar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItemCargar.setText("Cargar CSV");
        jMenuItemCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCargar);

        jMenuBar1.add(jMenu1);

        jMenuVentanaAdmin.setText("Usuario(s)");

        jMenuUsuarioCrear.setText("Crear");
        jMenuUsuarioCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioCrearActionPerformed(evt);
            }
        });
        jMenuVentanaAdmin.add(jMenuUsuarioCrear);

        jMenuUsuarioConsultar.setText("Consultar");
        jMenuUsuarioConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioConsultarActionPerformed(evt);
            }
        });
        jMenuVentanaAdmin.add(jMenuUsuarioConsultar);

        jMenuItemCargarUsuarios.setText("Cargar XML");
        jMenuItemCargarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarUsuariosActionPerformed(evt);
            }
        });
        jMenuVentanaAdmin.add(jMenuItemCargarUsuarios);

        jMenuItem5.setText("Exportar CSV");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuVentanaAdmin.add(jMenuItem5);

        jMenuItem6.setText("Exportar XML");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuVentanaAdmin.add(jMenuItem6);

        jMenuItem7.setText("Exportar JSON");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuVentanaAdmin.add(jMenuItem7);

        jMenuBar1.add(jMenuVentanaAdmin);

        jMenu3.setText("Proveedore(s)");

        jMenuItemProvedores.setText("Proveedor Nuevo");
        jMenuItemProvedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProvedoresActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemProvedores);

        jMenuItemConsultarProveedores.setText("Consultar Proveedores");
        jMenuItemConsultarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarProveedoresActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemConsultarProveedores);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 393, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuUsuarioConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioConsultarActionPerformed
        ConsultaUsuarios c = new ConsultaUsuarios();
        c.setVisible(true);
        
    }//GEN-LAST:event_jMenuUsuarioConsultarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuUsuarioCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioCrearActionPerformed
        UsuarioNuevo n = new UsuarioNuevo();
        n.setVisible(true);    }//GEN-LAST:event_jMenuUsuarioCrearActionPerformed

    private void jMenuLibroCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLibroCrearActionPerformed
        LibroNuevo n = new LibroNuevo();
        n.setVisible(true);
    }//GEN-LAST:event_jMenuLibroCrearActionPerformed

    private void jMenuLibroConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLibroConsultarActionPerformed
        ConsultaLibros c = new ConsultaLibros();
        c.setVisible(true);
    }//GEN-LAST:event_jMenuLibroConsultarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CuponNuevo c = new CuponNuevo();
        c.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ConsultaCupon c = new ConsultaCupon();
        c.setVisible(true);        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Perfil p = new Perfil(this.usuarioLogeado);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemProvedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProvedoresActionPerformed
        VentanaProveedor vp = new VentanaProveedor();
        vp.setVisible(true);
    }//GEN-LAST:event_jMenuItemProvedoresActionPerformed

    private void jMenuItemConsultarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarProveedoresActionPerformed
        ConsultarProveedores CV = new ConsultarProveedores();
        CV.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemConsultarProveedoresActionPerformed

    private void jMenuItemCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarActionPerformed
        CargarCupon cp = new CargarCupon();
        cp.setVisible(true);
    }//GEN-LAST:event_jMenuItemCargarActionPerformed

    private void jMenuItemCargarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarUsuariosActionPerformed
        CargarUsuarios cu = new CargarUsuarios();
        cu.setVisible(true);
    }//GEN-LAST:event_jMenuItemCargarUsuariosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CargaLibro cl = new CargaLibro();
        cl.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ExportarUsuariosCSV eu = new ExportarUsuariosCSV();
        eu.setVisible(true);
   
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ExportarUsuariosXML exu = new ExportarUsuariosXML();
        exu.setVisible(true);        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        ExportarUsuariosJSON euj = new ExportarUsuariosJSON();
        euj.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       ExportarLibrosCSV elc = new ExportarLibrosCSV();
       elc.setVisible(true);
       
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       ExportarLibrosXML elx = new ExportarLibrosXML();
       elx.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItemExportarLibrosJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarLibrosJSONActionPerformed
        ExportarLibrosJSON elj = new ExportarLibrosJSON();
        elj.setVisible(true);
    }//GEN-LAST:event_jMenuItemExportarLibrosJSONActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCargar;
    private javax.swing.JMenuItem jMenuItemCargarUsuarios;
    private javax.swing.JMenuItem jMenuItemConsultarProveedores;
    private javax.swing.JMenuItem jMenuItemExportarLibrosJSON;
    private javax.swing.JMenuItem jMenuItemProvedores;
    private javax.swing.JMenu jMenuLibro;
    private javax.swing.JMenuItem jMenuLibroConsultar;
    private javax.swing.JMenuItem jMenuLibroCrear;
    private javax.swing.JMenuItem jMenuUsuarioConsultar;
    private javax.swing.JMenuItem jMenuUsuarioCrear;
    private javax.swing.JMenu jMenuVentanaAdmin;
    // End of variables declaration//GEN-END:variables
}
