package com.dh.practica.controller;

import com.dh.practica.dto.EstudianteDTO;
import com.dh.practica.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    IEstudianteService estudianteService;

    @PostMapping // post = guardar
    public ResponseEntity<?> guardarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.guardarEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}") // get = buscar
    public EstudianteDTO buscarEstudiante(@PathVariable Long id) {
        return estudianteService.buscarEstudiante(id);
    }

    @PutMapping // put = modificar
    public ResponseEntity<?> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.modificarEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // delete = eliminar
    public ResponseEntity<?> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping // get = listar todos
    public Collection<EstudianteDTO> listarTodos() {
        return estudianteService.listarTodos();
    }
}
