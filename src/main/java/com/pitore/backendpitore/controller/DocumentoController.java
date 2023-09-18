package com.pitore.backendpitore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pitore.backendpitore.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    @Autowired
    DocumentoService documentoService;

}
