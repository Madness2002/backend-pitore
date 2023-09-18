package com.pitore.backendpitore.service.impl;


import com.pitore.backendpitore.model.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.pitore.backendpitore.repository.DocumentoRepository;
import com.pitore.backendpitore.service.DocumentoService;

import java.util.List;
import java.util.Optional;
@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    DocumentoRepository documentoRepository;
    @Override
    public JpaRepository<Documento, Integer> getRepository() {
        return documentoRepository;
    }

    @Override
    public List<Documento> getAll() throws Exception {
        return DocumentoService.super.getAll();
    }

    @Override
    public Optional<Documento> findById(Integer integer) throws Exception {
        return DocumentoService.super.findById(integer);
    }

    @Override
    public Documento create(Documento entity) throws Exception {
        return DocumentoService.super.create(entity);
    }

    @Override
    public Documento update(Documento entity) throws Exception {
        return DocumentoService.super.update(entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        DocumentoService.super.deleteById(integer);
    }
}
