package com.pitore.backendpitore.service.impl;


import com.pitore.backendpitore.model.DetallePregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.DetallePreguntaRepository;
import com.pitore.backendpitore.service.DetallePreguntaService;

import java.util.List;
import java.util.Optional;
@Service
public class DetallePreguntaServiceImpl implements DetallePreguntaService {

    @Autowired
    private DetallePreguntaRepository detallePreguntaRepository;


    @Override
    public JpaRepository<DetallePregunta, Integer> getRepository() {
        return detallePreguntaRepository;
    }

    @Override
    public List<DetallePregunta> getAll() throws Exception {
        return DetallePreguntaService.super.getAll();
    }

    @Override
    public Optional<DetallePregunta> findById(Integer integer) throws Exception {
        return DetallePreguntaService.super.findById(integer);
    }

    @Override
    public DetallePregunta create(DetallePregunta entity) throws Exception {
        return DetallePreguntaService.super.create(entity);
    }

    @Override
    public DetallePregunta update(DetallePregunta entity) throws Exception {
        return DetallePreguntaService.super.update(entity);
    }



    @Override
    public void deleteById(Integer integer) throws Exception {
        DetallePreguntaService.super.deleteById(integer);
    }

    @Override
    public List<DetallePregunta> ListarPorIdIteracion(int idIteracion) {
        return detallePreguntaRepository.ListarPorIdIteracion(idIteracion);
    }
}
