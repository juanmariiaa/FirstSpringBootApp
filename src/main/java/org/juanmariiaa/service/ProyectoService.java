package org.juanmariiaa.service;

import org.juanmariiaa.model.Proyecto;
import org.juanmariiaa.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoRepository.findAll();
    }

    public void guardarProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }
}