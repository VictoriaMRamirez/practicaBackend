package com.dh.practica.service.impl;

import com.dh.practica.dto.entity.Estudiante;
import com.dh.practica.dto.EstudianteDTO;
import com.dh.practica.repository.IEstudianteRepository;
import com.dh.practica.service.IEstudianteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override // Metodo guardar
    public void guardarEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override // Metodo buscar por id
    public EstudianteDTO buscarEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;

        if (estudiante.isPresent()) {
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }

        return estudianteDTO;
    }

    @Override // Metodo save (tmb modifica)
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        guardarEstudiante(estudianteDTO);
    }

    @Override // Metodo delete por id
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override // Metodo find all
    public Set<EstudianteDTO> listarTodos() {
       List<Estudiante> estudiantes = estudianteRepository.findAll();
       Set<EstudianteDTO> estudiantesDTO = new HashSet<>();

       for (Estudiante estudiante : estudiantes) {
           estudiantesDTO.add(mapper.convertValue(estudiante, EstudianteDTO.class));
       }

       return estudiantesDTO;
    }
}
