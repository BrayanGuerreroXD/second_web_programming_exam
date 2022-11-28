package com.exam.web.controller;

import com.exam.web.entities.Resultado;
import com.exam.web.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    ResultadoRepository resultadoRepo;

    @GetMapping
    public List<Resultado> getResultadoAll() {
        return resultadoRepo.findAll();
    }

    @PostMapping
    public Resultado postResultado(@RequestBody Resultado resultado) {
        resultadoRepo.save(resultado);
        return resultado;
    }

    @PutMapping("/{id}")
    public Resultado putResultadobyId(@PathVariable Integer id, @RequestBody Resultado resultado) {
        Optional<Resultado> resultadoCurrent = resultadoRepo.findById(id);

        if (resultadoCurrent.isPresent()) {
            Resultado resultadoReturn = resultadoCurrent.get();
            resultadoReturn.setPartido(resultado.getPartido());
            resultadoReturn.setSeleccion(resultado.getSeleccion());
            resultadoReturn.setGoles(resultado.getGoles());
            resultadoReturn.setAmarillas(resultado.getAmarillas());
            resultadoReturn.setRojas(resultado.getRojas());
            resultadoRepo.save(resultadoReturn);
            return resultadoReturn;
        }

        return null;
    }
}
