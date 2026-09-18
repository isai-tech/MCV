/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.dao;

import java.util.List;

/**
 *
 * @author isaiv
 */
public interface CrudDAO<T> {
    boolean insertar (T Objeto);
    boolean actualizar (T Objeto);
    boolean eliminar (int id);
    T buscarPorID(int id);
    List<T> listarTodos();
}
