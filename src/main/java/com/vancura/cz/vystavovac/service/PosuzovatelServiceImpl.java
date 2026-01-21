package com.vancura.cz.vystavovac.service;

import com.vancura.cz.vystavovac.model.Posuzovatel;
import com.vancura.cz.vystavovac.repository.PosuzovatelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosuzovatelServiceImpl implements PosuzovatelService{
    private PosuzovatelRepository posuzovatelRepository;

@Autowired
public PosuzovatelServiceImpl(PosuzovatelRepository posuzovatelRepository) {
    this.posuzovatelRepository = posuzovatelRepository;
}
@Override
public Posuzovatel getPosuzovatelDetails(Long id) {
    return posuzovatelRepository.findById(id).orElse(null);
}
    @Override
    public Posuzovatel createPosuzovatel(Posuzovatel posuzovatel) {
        return posuzovatelRepository.save(posuzovatel);
    }
    @Override
    public Posuzovatel updatePosuzovatel(Posuzovatel posuzovatel) {
        // Check posuzovatel id existuje
        Optional<Posuzovatel> posuzovatelDB = posuzovatelRepository.findById(posuzovatel.getId());
        if (posuzovatelDB.isPresent()) {
            // Update posuzovatel
            return posuzovatelRepository.save(posuzovatel);
        }
        return null;
    }
    @Override
    public Posuzovatel deletePosuzovatel(Long id) {
        Optional<Posuzovatel> posuzovatelDB = posuzovatelRepository.findById(id);
        if (posuzovatelDB.isPresent()) {
            // smaz posuzovatel z repository
            posuzovatelRepository.delete(posuzovatelDB.get());
            return posuzovatelDB.get();
        }
        return null; //posuzovatel nenalezen
    }
    @Override
    public List<Posuzovatel> getAllPosuzovatel() {
        return posuzovatelRepository.findAll();
    }
}

