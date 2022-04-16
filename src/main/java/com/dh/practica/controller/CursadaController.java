package com.dh.practica.controller;

import com.dh.practica.dto.CursadaDTO;
import com.dh.practica.service.ICursadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cursadas")
public class CursadaController {

    @Autowired
    ICursadaService cursadaService;

    @PostMapping // post = guardar
    public ResponseEntity<?> guardarCursada(@RequestBody CursadaDTO cursadaDTO) {
        cursadaService.guardarCursada(cursadaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}") // get = buscar
    public CursadaDTO buscarCursada(@PathVariable Long id) {
        return cursadaService.buscarCursada(id);
    }

    @PutMapping // put = modificar
    public ResponseEntity<?> modificarCursada(@RequestBody CursadaDTO cursadaDTO) {
        cursadaService.modificarCursada(cursadaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // delete = eliminar
    public ResponseEntity<?> eliminarCursada(@PathVariable Long id) {
        cursadaService.eliminarCursada(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping // get = listar todas
    public Collection<CursadaDTO> listarTodas() {
        return cursadaService.listarTodas();
    }
}
