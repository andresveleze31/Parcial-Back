package com.parcial.parcial.services;

import com.parcial.parcial.dto.CelularDTO;
import com.parcial.parcial.entities.Celular;
import com.parcial.parcial.repositories.CelularRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CelularService {

    private CelularRepository celularRepository;
    ModelMapper modelMapper;

    @Autowired
    CelularService(CelularRepository celularRepository, ModelMapper modelMapper){
        this.celularRepository = celularRepository;
        this.modelMapper = modelMapper;
    }

    public CelularDTO get(Integer id) {
        Optional<Celular> celularOpt = celularRepository.findById(id);
        CelularDTO celularDTO = null;

        if(celularOpt.isPresent()){
            Celular celular = celularOpt.get();
            celularDTO = modelMapper.map(celular, CelularDTO.class);

        }

        return  celularDTO;
    }

    public List<CelularDTO> get(){
        List<Celular> celulares =  (List<Celular>) celularRepository.findAll();
        List<CelularDTO> celularDTOS = celulares.stream().map(celular -> modelMapper.map(celular, CelularDTO.class)).collect(Collectors.toList());

        return celularDTOS;
    }

    public CelularDTO create(CelularDTO celularDTO){
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        celular = celularRepository.save(celular);

        return modelMapper.map(celular, CelularDTO.class);
    }

    public CelularDTO update(CelularDTO celularDTO){
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        celular = celularRepository.save(celular);

        return modelMapper.map(celular, CelularDTO.class);
    }
    public void delete(Integer id){
        celularRepository.deleteById(id);
    }
}
