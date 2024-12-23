package org.juanmariiaa.controller;

import org.juanmariiaa.model.Empleado;
import org.juanmariiaa.model.Departamento;
import org.juanmariiaa.service.EmpleadoService;
import org.juanmariiaa.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/empleados/{id}")
    public String verEmpleado(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        return "ver_empleado";
    }

    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        List<Departamento> departamentos = departamentoService.obtenerTodosLosDepartamentos();
        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentos);
        return "crear_empleado";
    }

    @PostMapping("/empleados/editar/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado) {
        Empleado empleadoExistente = empleadoService.obtenerEmpleadoPorId(id);
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido(empleado.getApellido());
        empleadoExistente.setCorreo(empleado.getCorreo());
        empleadoExistente.setSalario(empleado.getSalario());
        empleadoExistente.setDepartamento(empleado.getDepartamento());
        empleadoService.guardarEmpleado(empleadoExistente);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/borrar/{id}")
    public String borrarEmpleado(@PathVariable Long id) {
        empleadoService.borrarEmpleado(id);
        return "redirect:/empleados";
    }
}