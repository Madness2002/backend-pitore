package com.pitore.backendpitore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cPregunta;
    @NotEmpty(message = "Ingrese texto de la pregunta")
    @Column(name = "tPregunta", nullable = false, length = 250)
    private String tPregunta;
    @NotNull
    @ManyToOne

    @JoinColumn(name = "cCuestionario", nullable = false)
    private Cuestionario cuestionario;
    @JsonBackReference
    @OneToMany(mappedBy = "pregunta" , cascade = {
            CascadeType.REMOVE
    })
    private List<DetallePregunta> detallePreguntas;

    public Pregunta(int cPregunta, String tPregunta, Cuestionario cuestionario, List<DetallePregunta> detallePreguntas) {
        this.cPregunta = cPregunta;
        this.tPregunta = tPregunta;
        this.cuestionario = cuestionario;
        this.detallePreguntas = detallePreguntas;
    }

    public Pregunta() {

    }

    public List<DetallePregunta> getDetallePreguntas() {
        return detallePreguntas;
    }

    public void setDetallePreguntas(List<DetallePregunta> detallePreguntas) {
        this.detallePreguntas = detallePreguntas;
    }

    public int getcPregunta() {
        return cPregunta;
    }

    public String gettPregunta() {
        return tPregunta;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setcPregunta(int cPregunta) {
        this.cPregunta = cPregunta;
    }

    public void settPregunta(String tPregunta) {
        this.tPregunta = tPregunta;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }



}
