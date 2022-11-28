package com.exam.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import  javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="resultado")
@Data
public class Resultado {

    @Id
    @SequenceGenerator(name="resultado_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="resultado_id_seq")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    @OneToOne
    @JoinColumn(name = "seleccion_id")
    private Seleccion seleccion;

    @Column(name = "goles")
    private int goleS;

    @Column(name = "amarillas")
    private int amarillas;

    @Column(name = "rojas")
    private int rojas;
}
