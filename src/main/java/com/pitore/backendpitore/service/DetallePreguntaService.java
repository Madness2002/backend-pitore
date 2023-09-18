package com.pitore.backendpitore.service;



import com.pitore.backendpitore.model.DetallePregunta;

import java.util.List;

public interface DetallePreguntaService extends CrudService<DetallePregunta, Integer>{

  List<DetallePregunta> ListarPorIdIteracion(int idIteracion);
}
