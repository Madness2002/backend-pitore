package com.pitore.backendpitore.controller;

import com.pitore.backendpitore.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pitore.backendpitore.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @RequestMapping("/list")
    public ResponseEntity<?> listAll() {
        List<Usuario> list = usuarioService.getRepository().findAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping("/list/{username}")
    public ResponseEntity<?> listByUsername(@PathVariable String username) {
        Usuario usuario = usuarioService.obtenerUsuario(username);
        return ResponseEntity.ok(usuario);
    }


    @RequestMapping("/buscar/{cusuario}")
    public ResponseEntity<?> listById(@PathVariable int cusuario) {
        Optional<Usuario> usuario = usuarioService.getRepository().findById(cusuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Usuario usuario) {
        try {
            usuario.setfUsuario(true);
            usuarioService.guardarUsuario(usuario);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.valueOf(e.getMessage()));
        }
    }

    @PutMapping("/update/{cusuario}")
    public ResponseEntity<?> update(@PathVariable int cusuario,@RequestBody Usuario usuarioUpdate) {
        try {
            Usuario usuario = usuarioService.findById(cusuario).get();
            usuario.setNomUsuario(usuarioUpdate.getNomUsuario());
            usuario.setdUsuario(usuarioUpdate.getdUsuario());
            usuario.setPassword(usuarioUpdate.getPassword());
            usuarioService.update(usuario);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
         System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("delete/{cusuario}")
    public ResponseEntity<?> Delete(@PathVariable int cusuario) {
        try {
            usuarioService.deleteById(cusuario);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return null;
    }

}
