package com.pitore.backendpitore.service.impl;

import com.pitore.backendpitore.model.Cuestionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.CuestionarioRepository;
import com.pitore.backendpitore.service.CuestionarioService;

import java.util.Optional;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {
    @Autowired
    private CuestionarioRepository cuestionarioRepository;


    @Override
    public JpaRepository<Cuestionario, Integer> getRepository() {
        return cuestionarioRepository;
    }

    @Override
    public Optional<Cuestionario> findById(Integer integer) throws Exception {
        return CuestionarioService.super.findById(integer);
    }

    @Override
    public Cuestionario create(Cuestionario entity) throws Exception {
        return CuestionarioService.super.create(entity);
    }

    @Override
    public Cuestionario update(Cuestionario entity) throws Exception {
        return CuestionarioService.super.update(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        CuestionarioService.super.deleteById(integer);
    }
}
