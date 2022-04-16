package com.dh.practica.dto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Cursadas")
@Getter @Setter
public class Cursada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double nota;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;

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
