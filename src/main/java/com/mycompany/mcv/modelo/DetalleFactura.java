/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.modelo;

/**
 *
 * @author isaiv
 */
public class DetalleFactura {

    private int id_detalle;
    private int id_factura;
    private int id_producto;
    private int cantidad;
    private float precio_unitario;
    private float subtotal;

    public DetalleFactura() {
    }

    public DetalleFactura(int idDetalle, int idFactura, int idProducto,
                           int cantidad, float precioUnitario, float subtotal) {
        this.id_detalle = idDetalle;
        this.id_factura = idFactura;
        this.id_producto = idProducto;
        this.cantidad = cantidad;
        this.precio_unitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getIdDetalle() {
        return id_detalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.id_detalle = idDetalle;
    }

    public int getIdFactura() {
        return id_factura;
    }

    public void setIdFactura(int idFactura) {
        this.id_factura = idFactura;
    }

    public int getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(int idProducto) {
        this.id_producto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precio_unitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precio_unitario = precioUnitario;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "idDetalle=" + id_detalle + ", idFactura=" + id_factura
                + ", idProducto=" + id_producto + ", cantidad=" + cantidad
                + ", precioUnitario=" + precio_unitario + ", subtotal=" + subtotal + '}';
    }
}