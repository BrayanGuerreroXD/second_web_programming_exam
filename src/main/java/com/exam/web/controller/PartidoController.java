package com.exam.web.controller;

import com.exam.web.entities.Partido;
import com.exam.web.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
