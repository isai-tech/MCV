/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.modelo;

/**
 *
 * @author isaiv
 */
public class Puesto {

    private int id_puestos;
    private String Nombre;
    private float Salario_Base;

    public Puesto() {
    }

    public Puesto(int idPuesto, String nombre, float salarioBase) {
        this.id_puestos = idPuesto;
        this.Nombre = nombre;
        this.Salario_Base = salarioBase;
    }

    public int getIdPuesto() {
        return id_puestos;
    }

    public void setIdPuesto(int idPuesto) {
        this.id_puestos = idPuesto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public float getSalarioBase() {
        return Salario_Base;
    }

    public void setSalarioBase(float salarioBase) {
        this.Salario_Base = salarioBase;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
