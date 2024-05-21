package com.parcial.parcial.controller;

import com.parcial.parcial.dto.CelularDTO;
import com.parcial.parcial.services.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcial/celular")
public class CelularController {

    CelularService celularService;

    @Autowired
    public CelularController( CelularService celularService){
        this.celularService = celularService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO get(@PathVariable Integer id){
        return celularService.get(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CelularDTO> get(){
        return celularService.get();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO create(@RequestBody CelularDTO celularDTO){
        return celularService.create(celularDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO update(@RequestBody CelularDTO celularDTO){
        return celularService.update(celularDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        celularService.delete(id);
    }
}
