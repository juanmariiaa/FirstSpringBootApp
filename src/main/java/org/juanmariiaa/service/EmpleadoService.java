package org.juanmariiaa.service;

import org.juanmariiaa.model.Empleado;
import org.juanmariiaa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    // Método para obtener un empleado por su ID
    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    // Método para guardar un nuevo empleado
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }




    // Método para eliminar un empleado por su ID
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

}
