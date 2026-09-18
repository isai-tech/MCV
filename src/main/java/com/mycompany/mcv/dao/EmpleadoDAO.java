/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.dao;

import com.mycompany.mcv.config.ConexionBD;
import com.mycompany.mcv.modelo.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isaiv
 */
public class EmpleadoDAO implements CrudDAO<Empleado> {

    @Override
    public boolean insertar(Empleado Objeto) {
        String sql = "Insert Into empleados (id_puesto, Nombre, Apellidos, Fecha_contratacion) VALUES (?,?,?,?)";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Objeto.getIdPuesto());
            ps.setString(2, Objeto.getNombre());
            ps.setString(3, Objeto.getApellidos());
            ps.setDate(4, Date.valueOf(Objeto.getFechaContratacion()));
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de insertar un empleado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Empleado Objeto) {
        String sql = "Update empleados Set id_puesto = ?, Nombre = ?, Apellidos = ?, Fecha_contratacion = ? Where id_empleado = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Objeto.getIdPuesto());
            ps.setString(2, Objeto.getNombre());
            ps.setString(3, Objeto.getApellidos());
            ps.setDate(4, Date.valueOf(Objeto.getFechaContratacion()));
            ps.setInt(5, Objeto.getId());
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de actualizar el empleado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "Delete From empleados Where id_empleado = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de eliminar el empleado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Empleado buscarPorID(int id) {
        String sql = "Select id_empleado, id_puesto, Nombre, Apellidos, Fecha_contratacion From empleados Where id_empleado = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearEmpleado(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar un empleado: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Empleado> listarTodos() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "Select id_empleado, id_puesto, Nombre, Apellidos, Fecha_contratacion From empleados";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empleados.add(mapearEmpleado(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
        return empleados;
    }
    
    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(
                rs.getInt("id_empleado"),
                rs.getString("Nombre"),
                rs.getString("Apellidos"),
                rs.getInt("id_puesto"),
                rs.getDate("Fecha_contratacion").toLocalDate()
        );
    }
}
