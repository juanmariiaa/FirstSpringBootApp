package org.juanmariiaa.service;

import org.juanmariiaa.model.Empleado;
import org.juanmariiaa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public void borrarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}