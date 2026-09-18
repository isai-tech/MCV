package com.mycompany.mcv.modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isaiv
 */
import java.time.LocalDateTime;

public class Factura {

    private int id_facturas;
    private int id_Clientes;
    private int id_empleado;
    private LocalDateTime fecha;
    private float total;

    public Factura() {
    }

    public Factura(int idFactura, int idCliente, int idEmpleado, LocalDateTime fecha, float total) {
        this.id_facturas = idFactura;
        this.id_Clientes = idCliente;
        this.id_empleado = idEmpleado;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdFactura() {
        return id_facturas;
    }

    public void setIdFactura(int idFactura) {
        this.id_facturas = idFactura;
    }

    public int getIdCliente() {
        return id_Clientes;
    }

    public void setIdCliente(int idCliente) {
        this.id_Clientes = idCliente;
    }

    public int getIdEmpleado() {
        return id_empleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.id_empleado = idEmpleado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + id_facturas + ", idCliente=" + id_Clientes
                + ", idEmpleado=" + id_empleado + ", fecha=" + fecha + ", total=" + total + '}';
    }
}
