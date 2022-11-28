package com.exam.web.controller;

import com.exam.web.entities.Partido;
import com.exam.web.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    PartidoRepository partidoRepo;

    @GetMapping
    public List<Partido> getPartidoAll() {
        return partidoRepo.findAll();
    }

    @GetMapping("/{id}/resultados")
    public Partido getPartidobyId(@PathVariable Integer id) {
        Optional<Partido> partido = partidoRepo.findById(id);

        if (partido.isPresent()) {
            return partido.get();
        }

        return null;
    }
}
