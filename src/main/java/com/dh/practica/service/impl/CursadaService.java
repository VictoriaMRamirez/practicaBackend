package com.dh.practica.service.impl;

import com.dh.practica.dto.entity.Cursada;
import com.dh.practica.dto.CursadaDTO;
import com.dh.practica.repository.ICursadaRepository;
import com.dh.practica.service.ICursadaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CursadaService implements ICursadaService {

    @Autowired
    private ICursadaRepository cursadaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public CursadaDTO buscarCursada(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        CursadaDTO cursadaDTO = null;

        if (cursada.isPresent()) {
            cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
        }

        return cursadaDTO;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        guardarCursada(cursadaDTO);
    }

    @Override
    public void eliminarCursada(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> listarTodas() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        Set<CursadaDTO> cursadasDTO = new HashSet<>();

        for (Cursada cursada : cursadas) {
            cursadasDTO.add(mapper.convertValue(cursada, CursadaDTO.class));
        }

        return cursadasDTO;
    }
}
