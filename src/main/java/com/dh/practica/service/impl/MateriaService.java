package com.dh.practica.service.impl;

import com.dh.practica.dto.entity.Materia;
import com.dh.practica.dto.MateriaDTO;
import com.dh.practica.repository.IMateriaRepository;
import com.dh.practica.service.IMateriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public MateriaDTO buscarMateria(Long id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        MateriaDTO materiaDTO = null;

        if (materia.isPresent()) {
            materiaDTO = mapper.convertValue(materia, MateriaDTO.class);
        }

        return materiaDTO;
    }

    @Override
    public void modificarMateria(MateriaDTO materiaDTO) {
        guardarMateria(materiaDTO);
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public Set<MateriaDTO> listarTodas() {
        List<Materia> materias = materiaRepository.findAll();
        Set<MateriaDTO> materiasDTO = new HashSet<>();

        for (Materia materia : materias) {
            materiasDTO.add(mapper.convertValue(materia, MateriaDTO.class));
        }

        return materiasDTO;
    }
}
