/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.modelo;

/**
 *
 * @author isaiv
 */
public class Marca {

    private int id_marca;
    private String Nombre;

    public Marca() {
    }

    public Marca(int idMarca, String nombre) {
        this.id_marca = idMarca;
        this.Nombre = nombre;
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

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + id_marca + ", nombre=" + Nombre + '}';
    }
}
