package com.parcial.parcial.repositories;

import com.parcial.parcial.entities.Celular;
import org.springframework.data.repository.CrudRepository;

public interface CelularRepository extends CrudRepository<Celular, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}