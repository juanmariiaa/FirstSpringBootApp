package org.juanmariiaa.controller;

import org.juanmariiaa.model.Proyecto;
import org.juanmariiaa.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/proyectos")
    public String listarProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.obtenerTodosLosProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }

    @GetMapping("/proyectos/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        Proyecto proyecto = new Proyecto();
        model.addAttribute("proyecto", proyecto);
        return "crear_proyecto";
    }

    @PostMapping("/proyectos")
    public String guardarProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
        proyectoService.guardarProyecto(proyecto);
        return "redirect:/proyectos";
    }
}