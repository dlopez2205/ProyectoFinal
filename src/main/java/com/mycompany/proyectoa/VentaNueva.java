/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author diego-lopez
 */
public class VentaNueva extends javax.swing.JFrame 
{ 
    public String usuariologeado;

    /**
     * Creates new form VentaNueva
     */
    public VentaNueva(String usuariologeado) 
    {
        initComponents();
        this.usuariologeado = usuariologeado;
        llenarComboLibro();
        LlenarTitulos();
        llenarComboCupones();
    }
    
    private void llenarComboLibro () {
        
        jComboBoxLibros.removeAllItems();
        
        for( int i = 0; i < ProyectoFinal.libros.size(); i++ ) 
        {
            Libro l = ProyectoFinal.libros.get(i);
            jComboBoxLibros.addItem(l.titulo);
        } 
    }
    
    private void llenarComboCupones() {
        
        jComboBoxCuponesDescuento.removeAllItems();

        for(int i = 0; i < ProyectoFinal.cupones.size(); i++) {
            Cupon c = ProyectoFinal.cupones.get(i);
            jComboBoxCuponesDescuento.addItem(c.codigo_descuento);
        }
        jComboBoxCuponesDescuento.setSelectedIndex(-1);
    }
    
    private void LlenarTitulos() {
        
        String encabezado[] = {"Libro","Cantidad" , "Subtotal" , "Fecha Venta"};
        DefaultTableModel t = new DefaultTableModel(encabezado, 0);
        jTableLibroVenta.setModel(t);
        TableModel tabla = jTableLibroVenta.getModel();
        
    }
    
    private void AgregaVenta()
    {        
        Venta v = new Venta();
        Double Descuento = 0.0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Cupon c = null;
        String fechaVenta = "";
        String fechaCupon = "";
        
        if( jTextFieldNit.getText().isEmpty() == false )
        {
            v.nit = jTextFieldNit.getText();
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Debe llenar Nit" );
            return;
        }
        
        if( jTextFieldNombre.getText().isEmpty()== false)
        {
            v.nombrecliente = jTextFieldNombre.getText();
            
        }else {
            
            JOptionPane.showMessageDialog(this, "Debe llenar Nombre" );
            return;
        }
        
        if( jTextFieldDireccion.getText().isEmpty()== false)
        {
            v.direccioncliente = jTextFieldDireccion.getText();
            
        }else {
            
           JOptionPane.showMessageDialog(this, "Debe llenar Direccion" );
           return;
        }
        
        v.empleado = this.usuariologeado;
        v.fecha = new Date();
        
        v.total = 0.0;
        v.totalsiniva = 0.0;
        
        // Buscar libros ventas
        
        for( int i = 0; i < ProyectoFinal.libroventa.size(); i++ ) 
        {
            LibroVenta lv = ProyectoFinal.libroventa.get(i);
            v.total += lv.subtotal;
        } 
        v.totalsiniva = v.total / 1.12;
                
        if( ProyectoFinal.libroventa.size() == 0 )
        {
            JOptionPane.showMessageDialog(this, "Debe agregar libros");
            return;
        }else{
            v.libroventa = ProyectoFinal.libroventa;        
        }
        
        if(jComboBoxCuponesDescuento.getSelectedIndex() > -1 ) 
        {
            JOptionPane.showMessageDialog(this, "Si hay descuento que calcular");
            
            for(int i = 0; i < ProyectoFinal.cupones.size(); i++) 
            {
                c = ProyectoFinal.cupones.get(i);
                String CodigoCupon = jComboBoxCuponesDescuento.getItemAt(jComboBoxCuponesDescuento.getSelectedIndex());

                if( c.codigo_descuento.equalsIgnoreCase(CodigoCupon) )
                {                                        
                    if(v.fecha.after(c.fecha_de_vencimiento))
                    {
                        JOptionPane.showMessageDialog(this, "Fecha de cupon vencido!!!");
                        return;
                    }
                    if( c.tipo_descuento.equalsIgnoreCase("Porcentaje") )
                    {
                        Descuento = v.total * ( c.descuento / 100.0 );
                        v.total = v.total - Descuento;                        
                        
                    }else{  // Aqui es descuento * valor
                        
                        Descuento = c.descuento.doubleValue();
                        v.total = v.total - Descuento;
                        
                    }
                    v.totalsiniva = v.total / 1.12;

                    JOptionPane.showMessageDialog(this, "Su descuento fue de: " + Descuento + " Total de su compra: " + v.total);
                    break;
                }
            }            
        }
        v.descuento = Descuento;

        ProyectoFinal.ventas.add(v);
        JOptionPane.showMessageDialog(this, "Venta agregada..." );
        limpiarForma();
        llenarComboCupones();                
    }
    
    private void limpiarForma() { 
        
        jTextFieldNit.setText("");
        jTextFieldNombre.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldCantidad.setText("");
        jComboBoxLibros.setSelectedIndex(-1);
        DefaultTableModel model = (DefaultTableModel) jTableLibroVenta.getModel();
        model.setRowCount(0); // Esto elimina todas las filas
    }
    
    private void AgregaLibroVenta()
    {        
        LibroVenta lv = new LibroVenta();
         
        if( jTextFieldCantidad.getText().isEmpty() == false ){
            lv.cantidad = Integer.parseInt(jTextFieldCantidad.getText());
        }else{
            JOptionPane.showMessageDialog(this,"Debe ingresar una cantidad");
            return;
        }
        
        if( jComboBoxLibros.getSelectedIndex() >= 0 ){
            lv.librotitulo = jComboBoxLibros.getItemAt(jComboBoxLibros.getSelectedIndex() );
        }else{
            JOptionPane.showMessageDialog(this, "Debe elegir un libro");
            return;
        }
        
        for( int i = 0; i < ProyectoFinal.libros.size(); i++ ) 
        {
            Libro l = ProyectoFinal.libros.get(i);
            
            if( l.titulo.equals(lv.librotitulo) )
            {
                if(l.cantidad_stock >= lv.cantidad ) {
                    
                     lv.subtotal = lv.cantidad * l.precio;
                     l.cantidad_stock = l.cantidad_stock - lv.cantidad;
                     
                }else {
                    JOptionPane.showMessageDialog(this, "La cantidad minima a pedir es: "+ l.cantidad_stock);
                    return;
                }     
            }
            lv.fecha_venta = Calendar.getInstance();
        }
        
        ProyectoFinal.libroventa.add(lv);
        pintarTablaLibroVenta();
        JOptionPane.showMessageDialog(this, "Libro agregado..." );
    }
    
    private void pintarTablaLibroVenta() {
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        
        String encabezado[] = {"Libro","Cantidad" , "Subtotal","Fecha Venta"};
        DefaultTableModel t = new DefaultTableModel(encabezado, ProyectoFinal.libroventa.size());
        jTableLibroVenta.setModel(t);
        TableModel tabla = jTableLibroVenta.getModel();

        for( int i = 0; i < ProyectoFinal.libroventa.size(); i++ ) 
        {
            LibroVenta lv = ProyectoFinal.libroventa.get(i);
            tabla.setValueAt(lv.librotitulo, i, 0);
            tabla.setValueAt(lv.cantidad, i, 1);
            tabla.setValueAt(lv.subtotal, i, 2);
            String fechaFormateada = formato.format(lv.fecha_venta.getTime());
            tabla.setValueAt(fechaFormateada, i, 3);
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
        jTextFieldNit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxLibros = new javax.swing.JComboBox<>();
        jTextFieldCantidad = new javax.swing.JTextField();
        jButtonAgregarLibro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLibroVenta = new javax.swing.JTable();
        jButtonVenta = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jComboBoxCuponesDescuento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nit:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Libro:");

        jLabel5.setText("Cantidad:");

        jComboBoxLibros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAgregarLibro.setText("Agregar libro");
        jButtonAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarLibroActionPerformed(evt);
            }
        });

        jTableLibroVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableLibroVenta);

        jButtonVenta.setText("Realizar venta");
        jButtonVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVentaActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jComboBoxCuponesDescuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Cupones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCantidad)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonAgregarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCuponesDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVenta)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonSalir)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregarLibro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVenta)
                    .addComponent(jButtonSalir)
                    .addComponent(jComboBoxCuponesDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();       
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarLibroActionPerformed
        AgregaLibroVenta();
    }//GEN-LAST:event_jButtonAgregarLibroActionPerformed

    private void jButtonVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVentaActionPerformed
        AgregaVenta();
    }//GEN-LAST:event_jButtonVentaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarLibro;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonVenta;
    private javax.swing.JComboBox<String> jComboBoxCuponesDescuento;
    private javax.swing.JComboBox<String> jComboBoxLibros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLibroVenta;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNit;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
