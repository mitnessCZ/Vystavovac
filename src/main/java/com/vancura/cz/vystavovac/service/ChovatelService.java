package com.vancura.cz.vystavovac.service;


import com.vancura.cz.vystavovac.model.Chovatel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChovatelService {
    Chovatel getChovatelDetails(Long id);
    boolean createChovatel(Chovatel chovatel);
    boolean updateChovatel(Chovatel chovatel);
    Chovatel deleteChovatel(Long id);
    Chovatel getChovatelById(Long id);
    List<Chovatel> getAllChovatel();
}
