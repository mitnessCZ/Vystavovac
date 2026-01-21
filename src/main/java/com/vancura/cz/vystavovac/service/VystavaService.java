package com.vancura.cz.vystavovac.service;


import com.vancura.cz.vystavovac.model.Vystava;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VystavaService {
    Vystava getVystavaDetails(Long id);
    boolean createVystava(Vystava vystava);
    boolean updateVystava(Vystava vystava);
    Vystava deleteVystava(Long id);
    List<Vystava> getAllVystava();

}
