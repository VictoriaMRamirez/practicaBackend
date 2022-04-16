package com.dh.practica.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Materias")
@Getter @Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    private Set<Cursada> cursadas;

    /* --------- GETTERS --------- */
    /*public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public Set<Cursada> getCursadas() {return cursadas;}*/

    /* --------- SETTERS --------- */
    /*public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setCursadas(Set<Cursada> cursadas) {this.cursadas = cursadas;}*/
}
