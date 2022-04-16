package com.dh.practica.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Estudiantes")
@Getter @Setter
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String apellido;

    @OneToMany(mappedBy = "estudiante")
    @JsonIgnore
    private Set<Cursada> cursadas;

    /* --------- GETTERS --------- */
    /*public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public Set<Cursada> getCursadas() {return cursadas;}*/

    /* --------- SETTERS --------- */
    /*public void setId(Long id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setCursadas(Set<Cursada> cursadas) {this.cursadas = cursadas;}*/
}
