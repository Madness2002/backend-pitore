package com.pitore.backendpitore.controller;


import com.pitore.backendpitore.model.GrupoEvaluacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitore.backendpitore.service.GrupoEvaluacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupoevaluacion")
public class GrupoEvaluacionController {
    @Autowired
    GrupoEvaluacionService grupoEvaluacionService;

    @RequestMapping("/list")
    public ResponseEntity<?> listAll() {
        List<GrupoEvaluacion> list= grupoEvaluacionService.getRepository().findAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping("/buscar/{cGrupoEvaluacion}")
    public ResponseEntity<?> listById(@PathVariable int cGrupoEvaluacion) {
        Optional<GrupoEvaluacion> grupoEvaluacion = grupoEvaluacionService.getRepository().findById(cGrupoEvaluacion);
        grupoEvaluacion.get().setIteraciones(grupoEvaluacion.get().getIteraciones());
        return ResponseEntity.ok(grupoEvaluacion);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody GrupoEvaluacion grupoEvaluacion) {
        try {
            grupoEvaluacionService.create(grupoEvaluacion);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.valueOf(e.getMessage()));
        }
    }

    @PutMapping("/update/{cGrupoEvaluacion}")
    public ResponseEntity<?> update(@PathVariable int cGrupoEvaluacion, @RequestBody GrupoEvaluacion grupoEvaluacion) {
        try {
            GrupoEvaluacion grupo=grupoEvaluacionService.findById(cGrupoEvaluacion).get();
            grupo.setNomGrupoEvaluacion(grupoEvaluacion.getNomGrupoEvaluacion());
            grupoEvaluacionService.update(grupo);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("delete/{cGrupoEvaluacion}")
    public ResponseEntity<?> Delete(@PathVariable int cGrupoEvaluacion) {
        try {
            grupoEvaluacionService.deleteById(cGrupoEvaluacion);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
