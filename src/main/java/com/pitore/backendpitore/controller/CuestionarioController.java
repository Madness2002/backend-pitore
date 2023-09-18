package com.pitore.backendpitore.controller;


import com.pitore.backendpitore.model.Cuestionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitore.backendpitore.service.CuestionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuestionario")
public class CuestionarioController {

    @Autowired
    CuestionarioService cuestionarioService;

    @RequestMapping("/list")
    public ResponseEntity<?> listAll() {
        List<Cuestionario> list= cuestionarioService.getRepository().findAll();
        return ResponseEntity.ok(list);
    }


    @RequestMapping("/buscar/{cCuestionario}")
    public ResponseEntity<?> listById(@PathVariable int cCuestionario) {
        Optional<Cuestionario> cuestionario = cuestionarioService.getRepository().findById(cCuestionario);
        return ResponseEntity.ok(cuestionario);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Cuestionario cuestionario) {
        try {
            cuestionarioService.create(cuestionario);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.valueOf(e.getMessage()));
        }
    }

    @PutMapping("/update/{cCuestionario}")
    public ResponseEntity<?> update(@PathVariable int cCuestionario, @RequestBody Cuestionario cuestionario) {
        try {
            cuestionario.setcCuestionario(cCuestionario);
            cuestionarioService.update(cuestionario);
            return ResponseEntity.ok(cuestionario);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @DeleteMapping("delete/{cCuestionario}")
    public ResponseEntity<?> Delete(@PathVariable int cCuestionario) {
        try {
            cuestionarioService.deleteById(cCuestionario);
            return ResponseEntity.ok("El cuestionario ha sido eliminado");
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }



}
