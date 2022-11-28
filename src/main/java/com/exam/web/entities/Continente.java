package com.exam.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="continente")
@Data
public class Continente {

    @Id
    @SequenceGenerator(name="continente_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="continente_id_seq")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
}
