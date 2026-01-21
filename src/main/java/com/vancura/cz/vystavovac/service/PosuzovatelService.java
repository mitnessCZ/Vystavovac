    package com.vancura.cz.vystavovac.service;


    import com.vancura.cz.vystavovac.model.Posuzovatel;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public interface PosuzovatelService {
        Posuzovatel getPosuzovatelDetails(Long id);
        Posuzovatel createPosuzovatel(Posuzovatel posuzovatel);
        Posuzovatel updatePosuzovatel(Posuzovatel posuzovatel);
        Posuzovatel deletePosuzovatel(Long id);
        List<Posuzovatel> getAllPosuzovatel();
    }
