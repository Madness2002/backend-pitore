package com.pitore.backendpitore.controller;


import com.pitore.backendpitore.model.Iteracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitore.backendpitore.service.IteracionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/iteracion")
public class IteracionController {

    @Autowired
    IteracionService iteracionService;

    @RequestMapping("/list")
    public ResponseEntity<?> listAll() {
        List<Iteracion> list= new ArrayList<Iteracion>();
		try {
			list = iteracionService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.ok(list);
    }
    
    @RequestMapping("/buscar/{cIteracion}")
    public ResponseEntity<?> listById(@PathVariable int cIteracion) {
        Optional<Iteracion> iteracion = iteracionService.getRepository().findById(cIteracion);
        return ResponseEntity.ok(iteracion);
    }

    @RequestMapping("/grupo/{c_grupo}")
    public ResponseEntity<?> listByGrupo(@PathVariable int c_grupo) {

        try {
            List<Iteracion> iteraciones = iteracionService.getIteracionByC_grupo(c_grupo);
            return ResponseEntity.ok(iteraciones);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    @PostMapping(value="/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody Iteracion iteracion) {
        try {
            iteracionService.create(iteracion);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.valueOf(e.getMessage()));
        }
    }

    @PutMapping("/update/{cIteracion}")
    public ResponseEntity<?> update(@PathVariable int cIteracion, @RequestBody Iteracion iteracion) {
        try {
            Iteracion i = iteracionService.findById(cIteracion).get();
            i.setNombIteracion(iteracion.getNombIteracion());
            iteracionService.update(i);
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
}
