package com.pitore.backendpitore.service.impl;


import com.pitore.backendpitore.model.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.UsuarioRolRespository;
import com.pitore.backendpitore.service.UsuarioRolService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {


    @Autowired
    private UsuarioRolRespository usuarioRolRepository;


    @Override
    public JpaRepository<UsuarioRol, Long> getRepository() {
        return usuarioRolRepository;
    }

    @Override
    public List<UsuarioRol> getAll() throws Exception {
        return UsuarioRolService.super.getAll();
    }

    @Override
    public Optional<UsuarioRol> findById(Long aLong) throws Exception {
        return UsuarioRolService.super.findById(aLong);
    }

    @Override
    public UsuarioRol create(UsuarioRol entity) throws Exception {
        return UsuarioRolService.super.create(entity);
    }

    @Override
    public UsuarioRol update(UsuarioRol entity) throws Exception {
        return UsuarioRolService.super.update(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        UsuarioRolService.super.deleteById(aLong);
    }
}
