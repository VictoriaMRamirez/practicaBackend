package com.dh.practica.service;

import com.dh.practica.dto.EstudianteDTO;

import java.util.Set;

public interface IEstudianteService {
    void guardarEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO buscarEstudiante(Long id);
    void modificarEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiante(Long id);
    Set<EstudianteDTO> listarTodos();
}
