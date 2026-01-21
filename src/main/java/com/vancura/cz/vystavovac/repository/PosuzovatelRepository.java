package com.vancura.cz.vystavovac.repository;

import com.vancura.cz.vystavovac.model.Posuzovatel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosuzovatelRepository extends JpaRepository<Posuzovatel, Long> {
}
