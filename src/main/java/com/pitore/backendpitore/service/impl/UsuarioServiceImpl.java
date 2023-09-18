package com.pitore.backendpitore.service.impl;


import com.pitore.backendpitore.model.Rol;
import com.pitore.backendpitore.model.Usuario;
import com.pitore.backendpitore.model.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.RolRepository;
import com.pitore.backendpitore.repository.UsuarioRepository;
import com.pitore.backendpitore.repository.UsuarioRolRespository;
import com.pitore.backendpitore.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRolRespository UsuarioRolRepository;
    @Override
    public JpaRepository<Usuario, Integer> getRepository() {
        return usuarioRepository;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuario.setUsername(usuario.getUsername().toLowerCase());
        UsuarioRol usuarioRol = new UsuarioRol();
        Rol rol= new Rol();
            usuarioRol.setUsuario(usuario);
            usuarioRol.setRol(rolRepository.findById(1).get());
                UsuarioRolRepository.save(usuarioRol);
    }
    @Override
    public Usuario obtenerUsuario(String username) {
        System.out.println(usuarioRepository.findByUsername(username).getUsername());
        return usuarioRepository.findByUsername(username.toLowerCase());
    }

    @Override
    public void eliminarUsuario(Integer usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        return UsuarioService.super.getAll();
    }

    @Override
    public Optional<Usuario> findById(Integer integer) throws Exception {
        return UsuarioService.super.findById(integer);
    }

    @Override
    public Usuario create(Usuario entity) throws Exception {
        return UsuarioService.super.create(entity);
    }

    @Override
    public Usuario update(Usuario entity) throws Exception {
        return UsuarioService.super.update(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        UsuarioService.super.deleteById(integer);
    }


}
