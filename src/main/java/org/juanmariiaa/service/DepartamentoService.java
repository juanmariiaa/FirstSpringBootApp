package org.juanmariiaa.service;

import org.juanmariiaa.model.Departamento;
import org.juanmariiaa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> obtenerTodosLosDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento obtenerDepartamentoPorId(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public void guardarDepartamento(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    public void borrarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}