package com.dh.practica.service;

import com.dh.practica.dto.MateriaDTO;

import java.util.Set;

public interface IMateriaService {
    void guardarMateria(MateriaDTO materiaDTO);
    MateriaDTO buscarMateria(Long id);
    void modificarMateria(MateriaDTO materiaDTO);
    void eliminarMateria(Long id);
    Set<MateriaDTO> listarTodas();
}
