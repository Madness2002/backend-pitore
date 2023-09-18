package com.pitore.backendpitore.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "detallepregunta")
public class DetallePregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_detalle_pregunta")
    private int cDetallePregunta;

    @ManyToOne
    @JoinColumn(name = "c_iteracion", nullable = false)
    private Iteracion iteracion;

    @ManyToOne
    @JoinColumn(name = "c_pregunta", nullable = false)
    private Pregunta pregunta;

    @DecimalMin("0.00")
    @NotEmpty(message = "Ingrese la respuesta")
    @Column(name = "t_respuesta_pregunta", nullable = false)
    private double tRespuestaPregunta;

    @NotEmpty(message = "Ingrese una fecha")
    @Column(name = "d_detalle_pregunta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dDetallePregunta;

    @Value("${fDetallePregunta:true}")
    @Column(name = "f_detalle_pregunta", nullable = false)
    private boolean fDetallePregunta;

    public DetallePregunta(int cDetallePregunta, Iteracion iteracion, Pregunta pregunta, double tRespuestaPregunta, Date dDetallePregunta, boolean fDetallePregunta) {
        this.cDetallePregunta = cDetallePregunta;
        this.iteracion = iteracion;
        this.pregunta = pregunta;
        this.tRespuestaPregunta = tRespuestaPregunta;
        this.dDetallePregunta = dDetallePregunta;
        this.fDetallePregunta = fDetallePregunta;
    }

    public void setcDetallePregunta(Integer cDetallePregunta) {
        this.cDetallePregunta = cDetallePregunta;
    }

    public boolean isfDetallePregunta() {
        return fDetallePregunta;
    }

    public void setfDetallePregunta(boolean fDetallePregunta) {
        this.fDetallePregunta = fDetallePregunta;
    }

    public DetallePregunta() {

    }

    public int getcDetallePregunta() {
        return cDetallePregunta;
    }

    public void setcDetallePregunta(int cDetallePregunta) {
        this.cDetallePregunta = cDetallePregunta;
    }

    public Iteracion getIteracion() {
        return iteracion;
    }

    public void setIteracion(Iteracion iteracion) {
        this.iteracion = iteracion;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public double gettRespuestaPregunta() {
        return tRespuestaPregunta;
    }

    public void settRespuestaPregunta(double tRespuestaPregunta) {
        this.tRespuestaPregunta = tRespuestaPregunta;
    }

    public Date getdDetallePregunta() {
        return dDetallePregunta;
    }

    public void setdDetallePregunta(Date dDetallePregunta) {
        this.dDetallePregunta = dDetallePregunta;
    }
}
