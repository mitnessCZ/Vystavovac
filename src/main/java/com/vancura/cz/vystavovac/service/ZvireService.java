package com.vancura.cz.vystavovac.service;


import com.vancura.cz.vystavovac.model.Zvire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZvireService {
    boolean createZvire(Zvire zvire);
    boolean updateZvire(Zvire zvire);
    Zvire deleteZvire(Long id);
    Zvire getZvireDetails(Long id);
    List<Zvire>getAllZvirata();

}
