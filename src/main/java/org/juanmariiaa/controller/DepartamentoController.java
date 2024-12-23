package org.juanmariiaa.controller;

import org.juanmariiaa.model.Departamento;
import org.juanmariiaa.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/departamentos")
    public String listarDepartamentos(Model model) {
        List<Departamento> departamentos = departamentoService.obtenerTodosLosDepartamentos();
        model.addAttribute("departamentos", departamentos);
        return "departamentos";
    }

    @GetMapping("/departamentos/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        Departamento departamento = new Departamento();
        model.addAttribute("departamento", departamento);
        return "crear_departamento";
    }

    @PostMapping("/departamentos")
    public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento) {
        departamentoService.guardarDepartamento(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Departamento departamento = departamentoService.obtenerDepartamentoPorId(id);
        model.addAttribute("departamento", departamento);
        return "crear_departamento";
    }

    @PostMapping("/departamentos/editar/{id}")
    public String actualizarDepartamento(@PathVariable Long id, @ModelAttribute("departamento") Departamento departamento) {
        Departamento departamentoExistente = departamentoService.obtenerDepartamentoPorId(id);
        departamentoExistente.setNombre(departamento.getNombre());
        departamentoService.guardarDepartamento(departamentoExistente);
        return "redirect:/departamentos";
    }

    @GetMapping("/departamentos/borrar/{id}")
    public String borrarDepartamento(@PathVariable Long id) {
        departamentoService.borrarDepartamento(id);
        return "redirect:/departamentos";
    }
}