package com.dh.practica.controller;

import com.dh.practica.dto.MateriaDTO;
import com.dh.practica.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    IMateriaService materiaService;

    @PostMapping // post = guardar
    public ResponseEntity<?> guardarMateria(@RequestBody MateriaDTO materiaDTO) {
        materiaService.guardarMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}") // get = buscar
    public MateriaDTO buscarMateria(@PathVariable Long id) {
        return materiaService.buscarMateria(id);
    }

    @PutMapping // put = modificar
    public ResponseEntity<?> modificarMateria(@RequestBody MateriaDTO materiaDTO) {
        materiaService.modificarMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // delete = eliminar
    public ResponseEntity<?> eliminarMateria(@PathVariable Long id) {
        materiaService.eliminarMateria(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping // get = listar todas
    public Collection<MateriaDTO> listarTodas() {return materiaService.listarTodas();}
}
