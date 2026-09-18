/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.modelo;

/**
 *
 * @author isaiv
 */
public class Producto {

    private int id_producto;
    private int id_marca;
    private String Nombre;
    private float Precio;
    private int Stock;

    public Producto() {
    }

    public Producto(int idProducto, int idMarca, String nombre, float precio, int stock) {
        this.id_producto = idProducto;
        this.id_marca = idMarca;
        this.Nombre = nombre;
        this.Precio = precio;
        this.Stock = stock;
    }

    public int getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(int idProducto) {
        this.id_producto = idProducto;
    }

    public int getIdMarca() {
        return id_marca;
    }

    public void setIdMarca(int idMarca) {
        this.id_marca = idMarca;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        this.Precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        this.Stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + id_producto + ", idMarca=" + id_marca
                + ", nombre=" + Nombre + ", precio=" + Precio + ", stock=" + Stock + '}';
    }
}