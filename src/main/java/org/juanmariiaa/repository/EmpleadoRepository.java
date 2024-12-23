package org.juanmariiaa.repository;

import org.juanmariiaa.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}