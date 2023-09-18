package com.pitore.backendpitore.repository;


import com.pitore.backendpitore.model.Iteracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IteracionRepository extends JpaRepository<Iteracion, Integer> {

    @Query(value = "select count(*) from (select * from iteracion i inner join detallepregunta dp on i.c_iteracion=dp.c_iteracion where i.c_iteracion=?1) as a",nativeQuery = true)
    Integer isIteracionRespondida(int idIteracion);

    @Query(value = "select * from iteracion where c_grupo_evaluacion = ?1",nativeQuery = true)
    List<Iteracion> getIteracionByC_grupo(int C_grupo);

}
