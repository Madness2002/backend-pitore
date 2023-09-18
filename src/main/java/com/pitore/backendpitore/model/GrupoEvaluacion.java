package com.pitore.backendpitore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "grupo_evaluacion")
public class GrupoEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cGrupoEvaluacion;


    @NotBlank
    @NotNull
    @NotEmpty(message = "Ingrese el nombre del grupo de evaluacion")
    @Column(name = "nomGrupoEvaluacion", nullable = false, length = 50)
    private String nomGrupoEvaluacion;

    @NotEmpty(message = "Ingrese una fecha")
    @Column(name = "dGrupoEvaluacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dGrupoEvaluacion;

    @NotNull
    @JsonBackReference(value="usuario-grupo-evaluacion")
    @ManyToOne
    @JoinColumn(name = "cusuario", nullable = false)
    private Usuario usuario;


    @OneToMany(mappedBy = "grupoEvaluacion" , cascade = {
            CascadeType.REMOVE
    })
    private List<Iteracion> iteraciones;
    @OneToMany(mappedBy = "grupoEvaluacion")
    private List<Documento> documentos;


    public GrupoEvaluacion(int cGrupoEvaluacion, String nomGrupoEvaluacion, Date dGrupoEvaluacion, Usuario usuario, List<Iteracion> iteraciones) {
        this.cGrupoEvaluacion = cGrupoEvaluacion;
        this.nomGrupoEvaluacion = nomGrupoEvaluacion;
        this.dGrupoEvaluacion = dGrupoEvaluacion;
        this.usuario = usuario;
        this.iteraciones = iteraciones;
    }

    public GrupoEvaluacion() {
        iteraciones= new ArrayList<>();
    }

    public List<Iteracion> getIteraciones() {
        return iteraciones;
    }

    public int getcGrupoEvaluacion() {
        return cGrupoEvaluacion;
    }

    public String getNomGrupoEvaluacion() {
        return nomGrupoEvaluacion;
    }

    public Date getdGrupoEvaluacion() {
        return dGrupoEvaluacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setcGrupoEvaluacion(int cGrupoEvaluacion) {
        this.cGrupoEvaluacion = cGrupoEvaluacion;
    }

    public void setNomGrupoEvaluacion(String nomGrupoEvaluacion) {
        this.nomGrupoEvaluacion = nomGrupoEvaluacion;
    }

    public void setdGrupoEvaluacion(Date dGrupoEvaluacion) {
        this.dGrupoEvaluacion = dGrupoEvaluacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIteraciones(List<Iteracion> iteraciones) {
        this.iteraciones = iteraciones;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}
