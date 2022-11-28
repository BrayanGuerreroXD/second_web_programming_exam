package com.exam.web.controller;

import com.exam.web.entities.Estadio;
import com.exam.web.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/estadio")
public class EstadioController {

    @Autowired
    EstadioRepository estadioRepo;

    @GetMapping
    public List<Estadio> getEstadioAll() {
        return estadioRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public Estadio deleteEstadiobyId(@PathVariable Integer id) {
        Optional<Estadio> estadio = estadioRepo.findById(id);

        if (estadio.isPresent()) {
            Estadio estadioReturn = estadio.get();
            estadioRepo.deleteById(id);
            return estadioReturn;
        }

        return null;
    }
}
