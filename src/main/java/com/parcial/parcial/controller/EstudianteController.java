package com.parcial.parcial.controller;

import com.parcial.parcial.dto.EstudianteDTO;
import com.parcial.parcial.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcial/estudiante")
public class EstudianteController {

    EstudianteService estudianteService;

    @Autowired
    public EstudianteController( EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EstudianteDTO get(@PathVariable Integer id){
        return estudianteService.get(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EstudianteDTO> get(){
        return estudianteService.get();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EstudianteDTO create(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.create(estudianteDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EstudianteDTO update(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.update(estudianteDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        estudianteService.delete(id);
    }
}
