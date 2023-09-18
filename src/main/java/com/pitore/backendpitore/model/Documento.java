package com.pitore.backendpitore.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cDocumento;

    @NotEmpty(message = "Ingrese el nombre del grupo de evaluacion")
    @Column(name = "nomGrupoEvaluacion", nullable = false)
    private Byte tDocumento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cGrupoEvaluacion", nullable = false)
    private GrupoEvaluacion grupoEvaluacion;

    public Documento(int cDocumento, Byte tDocumento, GrupoEvaluacion grupoEvaluacion) {
        this.cDocumento = cDocumento;
        this.tDocumento = tDocumento;
        this.grupoEvaluacion = grupoEvaluacion;
    }
    public Documento() {
    }
    public int getcDocumento() {
        return cDocumento;
    }

    public Byte gettDocumento() {
        return tDocumento;
    }

    public GrupoEvaluacion getGrupoEvaluacion() {
        return grupoEvaluacion;
    }

}
