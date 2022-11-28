package com.exam.web.repository;

import com.exam.web.entities.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}
