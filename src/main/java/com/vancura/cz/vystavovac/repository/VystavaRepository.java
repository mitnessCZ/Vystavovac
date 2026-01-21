package com.vancura.cz.vystavovac.repository;

import com.vancura.cz.vystavovac.model.Vystava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VystavaRepository extends JpaRepository<Vystava, Long> {
}
