/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.modelo;

/**
 *
 * @author isaiv
 */

public class Cliente extends Persona {

    private String nit;
    private String email;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nit, String nombre, String apellidos, String email) {
        super(id, nombre, apellidos);
        this.nit = nit;
        this.email = email;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getDescripcion() {
        return "Cliente: " + getNombreCompleto() + " | NIT: " + nit + " | Email: " + email;
    }
}
