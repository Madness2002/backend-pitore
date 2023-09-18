package com.pitore.backendpitore.service;


import com.pitore.backendpitore.model.GrupoEvaluacion;

public interface GrupoEvaluacionService extends CrudService<GrupoEvaluacion, Integer>{
	GrupoEvaluacion getGrupoEvaluacionByIdIteracion(int idIteracion);
}
