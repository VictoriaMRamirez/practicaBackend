package com.dh.practica.service.impl;

import com.dh.practica.dto.EstudianteDTO;
import com.dh.practica.service.IEstudianteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EstudianteServiceTest {

    @Autowired
    private IEstudianteService estudianteService;

    @Test
    public void guardarEstudiante() {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre("Victoria");
        estudianteDTO.setApellido("Ramírez");
        estudianteService.guardarEstudiante(estudianteDTO);

        EstudianteDTO estudianteVictoria = estudianteService.buscarEstudiante(1L);

        Assertions.assertTrue(estudianteVictoria != null);
    }
}