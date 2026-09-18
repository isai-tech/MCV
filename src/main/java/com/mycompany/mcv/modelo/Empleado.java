/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.modelo;

/**
 *
 * @author isaiv
 */
import java.sql.Date;
import java.time.LocalDate;

public class Empleado extends Persona {

    private int idPuesto;
    private LocalDate fechaContratacion;

    public Empleado() {
        super();
    }

    public Empleado(int id, String nombre, String apellidos, int idPuesto, LocalDate fechaContratacion) {
        super(id, nombre, apellidos);
        this.idPuesto = idPuesto;
        this.fechaContratacion = fechaContratacion;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String getDescripcion() {
        return "Empleado: " + getNombreCompleto()
                + " | ID Puesto: " + idPuesto
                + " | Fecha contratación: " + fechaContratacion;
    }

    public Date getFecha_contratacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
