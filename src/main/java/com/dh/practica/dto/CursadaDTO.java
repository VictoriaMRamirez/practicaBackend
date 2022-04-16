package com.dh.practica.dto;

import com.dh.practica.dto.entity.Estudiante;
import com.dh.practica.dto.entity.Materia;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CursadaDTO {
    private Long id;
    private Estudiante estudiante;
    private Materia materia;
    private double nota;

    /* --------- GETTERS --------- */
    /*public Long getId() {return id;}
    public Estudiante getEstudiante() {return estudiante;}
    public Materia getMateria() {return materia;}
    public double getNota() {return nota;}*/

    /* --------- SETTERS --------- */
    /*public void setId(Long id) {this.id = id;}
    public void setEstudiante(Estudiante estudiante) {this.estudiante = estudiante;}
    public void setMateria(Materia materia) {this.materia = materia;}
    public void setNota(double nota) {this.nota = nota;}*/
}
