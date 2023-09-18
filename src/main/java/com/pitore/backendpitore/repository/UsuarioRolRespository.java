package com.pitore.backendpitore.repository;

import com.pitore.backendpitore.model.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRespository extends JpaRepository<UsuarioRol, Long> {
}
