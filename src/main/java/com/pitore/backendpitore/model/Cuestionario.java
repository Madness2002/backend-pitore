package com.pitore.backendpitore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "cuestionario")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cCuestionario;

    @NotEmpty(message = "Ingrese el titulo del cuestionario")
    @Column(name = "tCuestionario", nullable = false, length = 50)
    private String tCuestionario;
    @JsonBackReference
    @OneToMany(mappedBy = "cuestionario")
    private List<Pregunta> preguntas;

    public Cuestionario() {
    }
    public Cuestionario(int cCuestionario, String tCuestionario, List<Pregunta> pregunta) {
        this.cCuestionario = cCuestionario;
        this.tCuestionario = tCuestionario;
        this.preguntas = pregunta;
    }

    public int getcCuestionario() {
        return cCuestionario;
    }

    public String gettCuestionario() {
        return tCuestionario;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setcCuestionario(int cCuestionario) {
        this.cCuestionario = cCuestionario;
    }

    public void settCuestionario(String tCuestionario) {
        this.tCuestionario = tCuestionario;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
