package com.exam.web.controller;

import com.exam.web.entities.Partido;
import com.exam.web.entities.Seleccion;
import com.exam.web.repository.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{grupo}/")
    public List<Seleccion> getSeleccionbyGrupo(@PathVariable String grupo) {
        List<Seleccion> seleccions = seleccionRepo.findAll();

        for(Seleccion seleccion: seleccions) {
            if(!seleccion.getGrupo().equals(grupo)) {
                seleccions.remove(seleccion);
            }
        }
        return seleccions;
    }

    @PostMapping
    public Seleccion postSeleccion(@RequestBody Seleccion seleccion) {
        seleccionRepo.save(seleccion);
        return seleccion;
    }
}

