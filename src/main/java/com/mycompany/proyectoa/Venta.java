/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoa;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author diego-lopez
 */
public class Venta {
    
    public String nit;
    public String nombrecliente;
    public String direccioncliente; 
    public String empleado;
    public Double total;
    public Double totalsiniva;
    public Double descuento;
    public Calendar fecha;
    public ArrayList<LibroVenta>libroventa = new ArrayList<>();
}
