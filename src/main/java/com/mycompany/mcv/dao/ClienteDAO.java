/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.dao;

import com.mycompany.mcv.modelo.Cliente;
import com.mycompany.mcv.config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isaiv
 */
public class ClienteDAO implements CrudDAO<Cliente> {
 
    @Override
    public boolean insertar(Cliente Objeto) {
        String sql = "Insert Into clientes (Nit, Nombres, Apellidos, Email) VALUES (?,?,?,?)";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Objeto.getNit());
            ps.setString(2, Objeto.getNombre());
            ps.setString(3, Objeto.getApellidos());
            ps.setString(4, Objeto.getEmail());
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de insertar un cliente: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public boolean actualizar(Cliente Objeto) {
        String sql = "Update clientes Set Nit = ?, Nombres = ?, Apellidos = ?, Email = ? Where id_clientes = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Objeto.getNit());
            ps.setString(2, Objeto.getNombre());
            ps.setString(3, Objeto.getApellidos());
            ps.setString(4, Objeto.getEmail());
            ps.setInt(5, Objeto.getId());
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de actualizar el cliente: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public boolean eliminar(int id) {
        String sql = "Delete From clientes Where id_clientes = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de eliminar el cliente: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public Cliente buscarPorID(int id) {
        String sql = "Select id_clientes, Nit, Nombres, Apellidos, Email From clientes Where id_clientes = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearCliente(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar un cliente: " + e.getMessage());
        }
        return null;
    }
 
    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "Select id_clientes, Nit, Nombres, Apellidos, Email From clientes";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(mapearCliente(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }
 
    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getInt("id_clientes"),
                rs.getString("Nit"),
                rs.getString("Nombres"),
                rs.getString("Apellidos"),
                rs.getString("Email")
        );
    }
}
