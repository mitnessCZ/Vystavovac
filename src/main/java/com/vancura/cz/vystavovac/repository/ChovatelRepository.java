package com.vancura.cz.vystavovac.repository;

import com.vancura.cz.vystavovac.model.Chovatel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChovatelRepository extends JpaRepository<Chovatel, Long> {
}
