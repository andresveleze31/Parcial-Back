package com.parcial.parcial.services;

import com.parcial.parcial.dto.EstudianteDTO;
import com.parcial.parcial.entities.Estudiante;
import com.parcial.parcial.repositories.EstudianteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private EstudianteRepository estudianteRepository;
    ModelMapper modelMapper;

    @Autowired
    EstudianteService(EstudianteRepository estudianteRepository, ModelMapper modelMapper){
        this.estudianteRepository = estudianteRepository;
        this.modelMapper = modelMapper;
    }

    public EstudianteDTO get(Integer id) {
        Optional<Estudiante> estudianteOpt = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;

        if(estudianteOpt.isPresent()){
            Estudiante estudiante = estudianteOpt.get();
            estudianteDTO = modelMapper.map(estudiante, EstudianteDTO.class);

        }

        return  estudianteDTO;
    }

    public List<EstudianteDTO> get(){
        List<Estudiante> arrendadors =  (List<Estudiante>) estudianteRepository.findAll();
        List<EstudianteDTO> arrendadorDTOS = arrendadors.stream().map(arrendador -> modelMapper.map(arrendador, EstudianteDTO.class)).collect(Collectors.toList());

        return arrendadorDTOS;
    }

    public EstudianteDTO create(EstudianteDTO estudianteDTO){
        Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);
        estudiante = estudianteRepository.save(estudiante);

        return modelMapper.map(estudiante, EstudianteDTO.class);
    }

    public EstudianteDTO update(EstudianteDTO estudianteDTO){
        Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);
        estudiante = estudianteRepository.save(estudiante);

        return modelMapper.map(estudiante, EstudianteDTO.class);
    }
    public void delete(Integer id){
        estudianteRepository.deleteById(id);
    }
}
