package com.dh.practica.service;

import com.dh.practica.dto.CursadaDTO;

import java.util.Set;

public interface ICursadaService {
    void guardarCursada(CursadaDTO cursadaDTO);
    CursadaDTO buscarCursada(Long id);
    void modificarCursada(CursadaDTO cursadaDTO);
    void eliminarCursada(Long id);
    Set<CursadaDTO> listarTodas();
}
