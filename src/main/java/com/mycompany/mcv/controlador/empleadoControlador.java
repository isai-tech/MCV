/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.controlador;

import com.mycompany.mcv.dao.EmpleadoDAO;
import com.mycompany.mcv.dao.PuestoDAO;
import com.mycompany.mcv.modelo.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author isaiv
 */
@Controller
@RequestMapping("/empleado")
public class empleadoControlador {

    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private PuestoDAO puestoDAO = new PuestoDAO();

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("empleados", empleadoDAO.listarTodos());
        model.addAttribute("puestosDisponibles", puestoDAO.listarTodos());
        if (!model.containsAttribute("empleado")) {
            model.addAttribute("empleado", new Empleado());
        }
        return "empleados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("empleados", empleadoDAO.listarTodos());
        model.addAttribute("puestosDisponibles", puestoDAO.listarTodos());
        model.addAttribute("empleado", empleadoDAO.buscarPorID(id));
        return "empleados";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado empleado, RedirectAttributes ra) {
        try {
            boolean ok = empleado.getId() == 0
                    ? empleadoDAO.insertar(empleado)
                    : empleadoDAO.actualizar(empleado);
            if (!ok) {
                ra.addFlashAttribute("error", "Error al momento de almacenar");
            }
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/empleado";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        empleadoDAO.eliminar(id);
        return "redirect:/empleado";
    }
}