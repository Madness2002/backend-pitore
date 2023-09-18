package com.pitore.backendpitore.repository;

import com.pitore.backendpitore.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
}
