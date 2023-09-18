package com.pitore.backendpitore.controller;

import com.pitore.backendpitore.model.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitore.backendpitore.service.PreguntaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {

    @Autowired
    PreguntaService preguntaService;

    @RequestMapping("/list")
    public ResponseEntity<?> listAll() {
        List<Pregunta> list= preguntaService.getRepository().findAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping("/buscar/{cPregunta}")
    public ResponseEntity<?> listById(@PathVariable int cPregunta) {
        Optional<Pregunta> pregunta = preguntaService.getRepository().findById(cPregunta);
        return ResponseEntity.ok(pregunta);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Pregunta pregunta) {
        try {
            preguntaService.create(pregunta);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.valueOf(e.getMessage()));
        }
    }

    @PutMapping("/update/{cPregunta}")
    public ResponseEntity<?> update(@PathVariable int cPregunta, @RequestBody Pregunta pregunta) {
        try {
            pregunta.setcPregunta(cPregunta);
            preguntaService.update(pregunta);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @DeleteMapping("delete/{cPregunta}")
    public ResponseEntity<?> Delete(@PathVariable int cPregunta) {
        try {
            preguntaService.deleteById(cPregunta);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
