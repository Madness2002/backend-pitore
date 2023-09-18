package com.pitore.backendpitore.service;


import com.pitore.backendpitore.model.Iteracion;

import java.util.List;

public interface IteracionService extends CrudService<Iteracion, Integer>{
    Integer isIteracionRespondida(int idIteracion);

    List<Iteracion> getIteracionByC_grupo(int C_grupo) throws Exception;
}
