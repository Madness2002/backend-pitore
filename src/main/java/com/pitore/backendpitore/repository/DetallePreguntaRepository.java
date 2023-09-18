package com.pitore.backendpitore.repository;


import com.pitore.backendpitore.model.DetallePregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePreguntaRepository extends JpaRepository<DetallePregunta, Integer> {
        @Query(value = "select * from detallepregunta where c_iteracion =?1 order by 6",nativeQuery = true)
    List<DetallePregunta>ListarPorIdIteracion(int idIteracion);

}
