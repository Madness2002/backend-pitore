package com.pitore.backendpitore.service.impl;


import com.pitore.backendpitore.model.GrupoEvaluacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.GrupoEvaluacionRepository;
import com.pitore.backendpitore.service.GrupoEvaluacionService;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoEvaluacionServiceImpl implements GrupoEvaluacionService {
    @Autowired
    private GrupoEvaluacionRepository grupoEvaluacionRepository;

    @Override
    public JpaRepository<GrupoEvaluacion, Integer> getRepository() {
        return grupoEvaluacionRepository;
    }

    @Override
    public List<GrupoEvaluacion> getAll() throws Exception {
        return GrupoEvaluacionService.super.getAll();
    }

    @Override
    public Optional<GrupoEvaluacion> findById(Integer integer) throws Exception {
        return GrupoEvaluacionService.super.findById(integer);
    }

    @Override
    public GrupoEvaluacion create(GrupoEvaluacion entity) throws Exception {
        return GrupoEvaluacionService.super.create(entity);
    }

    @Override
    public GrupoEvaluacion update(GrupoEvaluacion entity) throws Exception {
        return GrupoEvaluacionService.super.update(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        GrupoEvaluacionService.super.deleteById(integer);
    }

	@Override
	public GrupoEvaluacion getGrupoEvaluacionByIdIteracion(int idIteracion) {
		// TODO Auto-generated method stub
		return grupoEvaluacionRepository.getGrupoEvaluacionByIdIteracion(idIteracion);
	}
}
