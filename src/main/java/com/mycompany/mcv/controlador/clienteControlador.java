/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mcv.controlador;

import com.mycompany.mcv.dao.ClienteDAO;
import com.mycompany.mcv.modelo.Cliente;
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
@RequestMapping("/cliente")

public class clienteControlador {
    private ClienteDAO clienteDAO = new ClienteDAO();  
    
    @GetMapping()
    public String listar (Model model){
        model.addAttribute("clientes",clienteDAO.listarTodos());
        if (!model.containsAttribute("cliente")){
            model.addAttribute("cliente", new Cliente());
            }
            return "clientes";
        }
        @GetMapping("/editar/{id}")
        public String editar (@PathVariable int id, Model model){
            model.addAttribute ("clientes", clienteDAO.listarTodos());
            model.addAttribute("cliente", clienteDAO.buscarPorID(id));
            
            return "clientes";
        }
        @PostMapping("/guardar")
        public String guardar (@ModelAttribute Cliente cliente, RedirectAttributes ra){
        try{
            boolean ok = cliente.getId() == 0
                    ? clienteDAO.insertar(cliente)
                    : clienteDAO.actualizar(cliente);
            if (!ok){
                ra.addFlashAttribute("error", "Error al momento de almacenar");
            }
        }catch (Exception e){
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/cliente";
    }
        
    @PostMapping("/eliminar/{id}")
    public String eliminar (@PathVariable int id){
        clienteDAO.eliminar(id);
        return "redirect:/cliente";  
    }
}

