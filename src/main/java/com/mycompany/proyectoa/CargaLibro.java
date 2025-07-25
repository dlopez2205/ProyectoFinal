/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoa;

import java.io.FileReader;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author diego-lopez
 */
public class CargaLibro extends javax.swing.JFrame {
    
    JFileChooser fileChooser = new JFileChooser();


    /**
     * Creates new form CargaLibro
     */
    public CargaLibro() {
        initComponents();
        pintarTabla();
    }
    
     private void pintarTabla() {
        
         String encabezado[] = {"Titulo", "Autor", "Genero", "Precio", "Stock"};
         DefaultTableModel t = new DefaultTableModel(encabezado, ProyectoFinal.libros.size());
         jTableCargarLibros.setModel(t);
         TableModel tabla = jTableCargarLibros.getModel();

         for (int i = 0; i < ProyectoFinal.libros.size(); i++) {
             Libro l = ProyectoFinal.libros.get(i);
             tabla.setValueAt(l.titulo, i, 0);
             tabla.setValueAt(l.autor, i, 1);
             tabla.setValueAt(l.genero, i, 2);
             tabla.setValueAt(l.precio, i, 3);
             tabla.setValueAt(l.cantidad_stock, i, 4);
        }                
    } 
    
    public void leerJson(String path) {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);
           
            JSONArray librosList = (JSONArray) obj;
            System.out.println("El archivo contiene el siguente JSON ");
            System.out.println(librosList);
            
            for( Object li: librosList )
            {
                guardarLibros((JSONObject) li);         
            }
            pintarTabla();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void guardarLibros(JSONObject li)
    {
        Libro l = new Libro();

        JSONObject libroJson = (JSONObject) li;

        l.titulo = (String) libroJson.get("titulo");
        l.autor = (String) libroJson.get("autor");
        l.genero = (String) libroJson.get("genero");
        l.precio = ((Number) libroJson.get("precio")).doubleValue();
        l.cantidad_stock = ((Number) libroJson.get("cantidad")).intValue();
        
        ProyectoFinal.libros.add(l);
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
        jTableCargarLibros = new javax.swing.JTable();
        jButtonCargar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableCargarLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableCargarLibros);

        jButtonCargar.setText("Cargar");
        jButtonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButtonCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCargar)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarActionPerformed
        File nombreArchivo;
        this.fileChooser.setDialogTitle("Busque el archivo");
        int option = this.fileChooser.showOpenDialog(this);

        if(option == JFileChooser.APPROVE_OPTION) {

            nombreArchivo = this.fileChooser.getSelectedFile();
            System.out.print( nombreArchivo.getAbsoluteFile());
            leerJson(nombreArchivo.getAbsoluteFile().toString());
        }
    }//GEN-LAST:event_jButtonCargarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCargar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCargarLibros;
    // End of variables declaration//GEN-END:variables

}
