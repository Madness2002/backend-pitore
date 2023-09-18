package com.pitore.backendpitore.controller;

import com.pitore.backendpitore.model.DetallePregunta;
import com.pitore.backendpitore.model.Iteracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitore.backendpitore.service.DetallePreguntaService;
import com.pitore.backendpitore.service.GrupoEvaluacionService;
import com.pitore.backendpitore.service.IteracionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle")
public class DetallePreguntaController {

    @Autowired
    DetallePreguntaService detallePreguntaService;
    @Autowired
    IteracionService iteracionService;
    @Autowired
    GrupoEvaluacionService grupoEvaluacionService;

    @RequestMapping("/list")
    public ResponseEntity<?> listAll() {
        List<DetallePregunta> list= detallePreguntaService.getRepository().findAll();
        System.out.println("CHUPE");
        return ResponseEntity.ok(list);
    }

    @RequestMapping("/list/{cIteracion}")
    public ResponseEntity<?> listByIdItereacion(@PathVariable int cIteracion) {
        List<DetallePregunta> list= detallePreguntaService.ListarPorIdIteracion(cIteracion);
        return ResponseEntity.ok(list);
    }
    @RequestMapping("/buscar/{cDetallePregunta}")
    public ResponseEntity<?> listById(@PathVariable int cDetallePregunta) {
        Optional<DetallePregunta> detallePregunta = detallePreguntaService.getRepository().findById(cDetallePregunta);
        return ResponseEntity.ok(detallePregunta);
    }

    @PostMapping(value="/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody DetallePregunta detallePregunta) {
        try {
         detallePreguntaService.create(detallePregunta);
         if(detallePregunta.getPregunta().gettPregunta().equals("Ingrese el valor del área bajo la curva característica operativa del receptor (AUC-ROC)")) {
        	Iteracion iteracion =  detallePregunta.getIteracion();
        	
        	
        	 iteracionService.update(new Iteracion(iteracion.getcIteracion(),
        			 iteracion.getNombIteracion(),
        			 iteracion.getdIteracion(),
        			 true,
        			 grupoEvaluacionService.getGrupoEvaluacionByIdIteracion(iteracion.getcIteracion())));
             System.out.println(detallePregunta.gettRespuestaPregunta());
         }
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.valueOf(e.getMessage()));
        }
    }
/*
    @PutMapping("/update/{cIteracion}")
    public ResponseEntity<?> update(@PathVariable int cIteracion, @RequestBody Iteracion iteracion) {
        try {
            Iteracion i = detallePreguntaService.findById(cIteracion).get();
            i.setNombIteracion(iteracion.getNombIteracion());
            detallePreguntaService.update(i);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("delete/{cIteracion}")
    public ResponseEntity<?> Delete(@PathVariable int cIteracion) {
        try {
            iteracionService.deleteById(cIteracion);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    */
}
