package com.pitore.backendpitore.repository;

import com.pitore.backendpitore.model.GrupoEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoEvaluacionRepository extends JpaRepository<GrupoEvaluacion, Integer> {
	@Query(value = "select ge.c_grupo_evaluacion,ge.d_grupo_evaluacion,ge.nom_grupo_evaluacion,ge.cusuario from grupo_evaluacion ge inner join iteracion i on ge.c_grupo_evaluacion=i.c_grupo_evaluacion  where c_iteracion =?1",nativeQuery = true)
    GrupoEvaluacion getGrupoEvaluacionByIdIteracion(int idIteracion);
}
