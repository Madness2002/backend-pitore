package com.pitore.backendpitore.service.impl;




import com.pitore.backendpitore.model.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.PreguntaRepository;
import com.pitore.backendpitore.service.PreguntaService;

import java.util.List;
import java.util.Optional;


@Service
public class PreguntaServiceImpl  implements PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;


    @Override
    public JpaRepository<Pregunta, Integer> getRepository() {
        return preguntaRepository;
    }

    @Override
    public List<Pregunta> getAll() throws Exception {
        return PreguntaService.super.getAll();
    }

    @Override
    public Optional<Pregunta> findById(Integer integer) throws Exception {
        return PreguntaService.super.findById(integer);
    }

    @Override
    public Pregunta create(Pregunta entity) throws Exception {
        return PreguntaService.super.create(entity);
    }

    @Override
    public Pregunta update(Pregunta entity) throws Exception {
        return PreguntaService.super.update(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        PreguntaService.super.deleteById(integer);
    }
}
