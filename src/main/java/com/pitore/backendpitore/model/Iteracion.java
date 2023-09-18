package com.pitore.backendpitore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "iteracion")
public class Iteracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cIteracion;

    @NotBlank(message = "Nombre de la iteración no puede estar vacio")
    @NotEmpty(message = "Ingrese el nombre de la iteración")
    @NotNull(message = "Nombre de la iteración no puede estar vacio")
    @Column(name = "nombIteracion", nullable = false, length = 50)
    private String nombIteracion;

    @NotEmpty(message = "Ingrese una fecha")
    @Column(name = "dIteracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dIteracion;

    @ManyToOne
    @JsonBackReference(value="grupo-iteracion")
    @JoinColumn(name = "cGrupoEvaluacion", nullable = false)
    private GrupoEvaluacion grupoEvaluacion;
    
    @JsonBackReference(value="detalle-pregunta-iteracion")
    @OneToMany(mappedBy = "iteracion" , cascade = {
            CascadeType.REMOVE
    })
    private List<DetallePregunta> detallePreguntas;
    
    @Value("${fRespondido:false}")
    @Column(name = "f_respondido")
    private boolean fRespondido;

    @Transient
    private double idoneidad;
    @Transient
    private double usabilidad;
    @Transient
    private double rendimiento;
    @Transient
    private int tNivel;

    @Transient
    private double pCalidad;

    public Iteracion(int cIteracion, String nombIteracion, Date dIteracion, GrupoEvaluacion grupoEvaluacion, List<DetallePregunta> detallePreguntas) {
        this.cIteracion = cIteracion;
        this.nombIteracion = nombIteracion;
        this.dIteracion = dIteracion;
        this.grupoEvaluacion = grupoEvaluacion;
        this.detallePreguntas = detallePreguntas;
    }

    public Iteracion() {

    }

    public double getIdoneidad() {
        return idoneidad;
    }

    public void setIdoneidad(double idoneidad) {
        this.idoneidad = idoneidad;
    }

    public double getUsabilidad() {
        return usabilidad;
    }

    public void setUsabilidad(double usabilidad) {
        this.usabilidad = usabilidad;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int gettNivel() {
        return tNivel;
    }

    public void settNivel(int tNivel) {
        this.tNivel = tNivel;
    }

    public double getpCalidad() {
        return pCalidad;
    }

    public void setpCalidad(double pCalidad) {
        this.pCalidad = pCalidad;
    }

    public Iteracion(int cIteracion, String nombIteracion, Date dIteracion, boolean fRespondido, GrupoEvaluacion grupoEvaluacion) {
        this.cIteracion = cIteracion;
        this.nombIteracion = nombIteracion;
        this.dIteracion = dIteracion;
        this.fRespondido=fRespondido;
        this.grupoEvaluacion = grupoEvaluacion;
    }
    
    public boolean isfRespondido() {
        return fRespondido;
    }

    public void setfRespondido(boolean fRespondido) {
        this.fRespondido = fRespondido;
    }

    public List<DetallePregunta> getDetallePreguntas() {
        return detallePreguntas;
    }

    public void setDetallePreguntas(List<DetallePregunta> detallePreguntas) {
        this.detallePreguntas = detallePreguntas;
    }

    public int getcIteracion() {
        return cIteracion;
    }

    public void setcIteracion(int cIteracion) {
        this.cIteracion = cIteracion;
    }

    public String getNombIteracion() {
        return nombIteracion;
    }

    public void setNombIteracion(String nombIteracion) {
        this.nombIteracion = nombIteracion;
    }

    public Date getdIteracion() {
        return dIteracion;
    }

    public void setdIteracion(Date dIteracion) {
        this.dIteracion = dIteracion;
    }

    public GrupoEvaluacion getGrupoEvaluacion() {
        return grupoEvaluacion;
    }

    public void setGrupoEvaluacion(GrupoEvaluacion grupoEvaluacion) {
        this.grupoEvaluacion = grupoEvaluacion;
    }
}
