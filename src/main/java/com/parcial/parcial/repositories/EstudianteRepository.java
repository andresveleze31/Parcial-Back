package com.parcial.parcial.repositories;

import com.parcial.parcial.entities.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
