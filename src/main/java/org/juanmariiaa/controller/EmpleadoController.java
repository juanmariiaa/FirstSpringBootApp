package org.juanmariiaa.controller;

import org.juanmariiaa.model.Empleado;
import org.juanmariiaa.model.Departamento;
import org.juanmariiaa.service.EmpleadoService;
import org.juanmariiaa.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("/empleados/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        Empleado empleado = new Empleado();
        List<Departamento> departamentos = departamentoService.obtenerTodosLosDepartamentos();
        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentos);
        return "crear_empleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        if (empleado.getDepartamento() != null && empleado.getDepartamento().getId() == null) {
            empleado.setDepartamento(null);
        }
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }
}