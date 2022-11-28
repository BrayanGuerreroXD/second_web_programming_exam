package com.exam.web.controller;

import com.exam.web.entities.Resultado;
import com.exam.web.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    ResultadoRepository resultadoRepo;

    @PutMapping("/{id}")
    public Resultado putResultadobyId(@PathVariable Integer id, @RequestBody Resultado resultado) {
        Optional<Resultado> resultadoCurrent = resultadoRepo.findById(id);

        if (resultadoCurrent.isPresent()) {
            Resultado resultadoReturn = resultadoCurrent.get();
            resultadoReturn.setPartido(resultado.getPartido());
            resultadoReturn.setSeleccion(resultado.getSeleccion());
            resultadoReturn.setGoleS(resultado.getGoleS());
            resultadoReturn.setAmarillas(resultado.getAmarillas());
            resultadoReturn.setRojas(resultado.getRojas());
            resultadoRepo.save(resultadoReturn);
            return resultadoReturn;
        }

        return null;
    }
}
