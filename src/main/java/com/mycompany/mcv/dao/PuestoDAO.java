/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.dao;

/**
 *
 * @author isaiv
 */
import com.mycompany.mcv.config.ConexionBD;
import com.mycompany.mcv.modelo.Puesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class PuestoDAO implements CrudDAO<Puesto> {
 
    @Override
    public boolean insertar(Puesto Objeto) {
        String sql = "Insert Into puestos (Nombre, Salario_Base) VALUES (?,?)";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Objeto.getNombre());
            ps.setFloat(2, Objeto.getSalarioBase());
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de insertar un puesto: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public boolean actualizar(Puesto Objeto) {
        String sql = "Update puestos Set Nombre = ?, Salario_Base = ? Where id_puestos = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Objeto.getNombre());
            ps.setFloat(2, Objeto.getSalarioBase());
            ps.setInt(3, Objeto.getIdPuesto());
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de actualizar el puesto: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public boolean eliminar(int id) {
        String sql = "Delete From puestos Where id_puestos = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de eliminar el puesto: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public Puesto buscarPorID(int id) {
        String sql = "Select id_puestos, Nombre, Salario_Base From puestos Where id_puestos = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearPuesto(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar un puesto: " + e.getMessage());
        }
        return null;
    }
 
    @Override
    public List<Puesto> listarTodos() {
        List<Puesto> puestos = new ArrayList<>();
        String sql = "Select id_puestos, Nombre, Salario_Base From puestos";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                puestos.add(mapearPuesto(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar puestos: " + e.getMessage());
        }
        return puestos;
    }
 
    private Puesto mapearPuesto(ResultSet rs) throws SQLException {
        return new Puesto(
                rs.getInt("id_puestos"),
                rs.getString("Nombre"),
                rs.getFloat("Salario_Base")
        );
    }
}
