/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoa;

import java.util.ArrayList;
import java.util.Calendar;       


/**
 *
 * @author diego-lopez
 */
public class ProyectoFinal {
    
    public static ArrayList<Usuario>usuarios = new ArrayList<>();
    public static ArrayList<Libro>libros = new ArrayList<>();
    public static ArrayList<Cupon>cupones = new ArrayList<>();
    public static ArrayList<Venta>ventas = new ArrayList<>();
    public static ArrayList<LibroVenta>libroventa = new ArrayList<>();
    public static ArrayList<Proveedor>proveedores = new ArrayList<>();

    public static void main(String[] args) {
        Usuario admin = new Usuario();
        Usuario vendedor = new Usuario();
        
        admin.nombre = "admin";
        admin.password = "admin";
        admin.rol = "A";
        admin.usuario = "admin";
        admin.estado = "Activo";
        
        usuarios.add(admin);

        vendedor.nombre = "Diego";
        vendedor.password = "diego";
        vendedor.rol = "V";
        vendedor.usuario = "dlopez";
        vendedor.estado = "Activo";
        
        usuarios.add(vendedor);

        Libro libro = new Libro();
        Libro libro2 = new Libro();
        
        libro.titulo = "La Odicea";
        libro.autor  = "Homero";
        libro.genero = "Mitologia";
        libro.precio = 200.0;
        libro.cantidad_stock = 200;
        libros.add(libro);

        libro2.titulo = "La Iliada";
        libro2.autor  = "Homero";
        libro2.genero = "Mitologia";
        libro2.precio = 100.0;
        libro2.cantidad_stock = 200;
        libros.addLast(libro2);
                
        Login l = new Login();
        
        l.setVisible(true);
        
    }
}
