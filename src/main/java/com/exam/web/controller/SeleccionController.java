package com.exam.web.controller;

import com.exam.web.entities.Seleccion;
import com.exam.web.repository.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/selecciones")
public class SeleccionController {

    @Autowired
    SeleccionRepository seleccionRepo;

    @GetMapping
    public List<Seleccion> getSeleccionAll() {
        return seleccionRepo.findAll();
    }

    @PostMapping
    public Seleccion postSeleccion(@RequestBody Seleccion seleccion) {
        seleccionRepo.save(seleccion);
        return seleccion;
    }
}

