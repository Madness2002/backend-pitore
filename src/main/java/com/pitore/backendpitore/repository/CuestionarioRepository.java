package com.pitore.backendpitore.repository;


import com.pitore.backendpitore.model.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuestionarioRepository extends JpaRepository<Cuestionario, Integer> {
}
