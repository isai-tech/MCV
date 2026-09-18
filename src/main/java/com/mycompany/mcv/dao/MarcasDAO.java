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
import com.mycompany.mcv.modelo.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class MarcasDAO implements CrudDAO<Marca> {
 
    @Override
    public boolean insertar(Marca Objeto) {
        String sql = "Insert Into marcas (Nombre) VALUES (?)";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Objeto.getNombre());
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de insertar una marca: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public boolean actualizar(Marca Objeto) {
        String sql = "Update marcas Set Nombre = ? Where id_marca = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Objeto.getNombre());
            ps.setInt(2, Objeto.getIdMarca());
 
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de actualizar la marca: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public boolean eliminar(int id) {
        String sql = "Delete From marcas Where id_marca = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Error al momento de eliminar la marca: " + e.getMessage());
            return false;
        }
    }
 
    @Override
    public Marca buscarPorID(int id) {
        String sql = "Select id_marca, Nombre From marcas Where id_marca = ?";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearMarca(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar una marca: " + e.getMessage());
        }
        return null;
    }
 
    @Override
    public List<Marca> listarTodos() {
        List<Marca> marcas = new ArrayList<>();
        String sql = "Select id_marca, Nombre From marcas";
        try {
            Connection conn = ConexionBD.IniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                marcas.add(mapearMarca(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar marcas: " + e.getMessage());
        }
        return marcas;
    }
 
    private Marca mapearMarca(ResultSet rs) throws SQLException {
        return new Marca(
                rs.getInt("id_marca"),
                rs.getString("Nombre")
        );
    }
}