package com.vancura.cz.vystavovac.service;

import com.vancura.cz.vystavovac.model.Vystava;
import com.vancura.cz.vystavovac.repository.VystavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VystavaServiceImpl implements VystavaService{
    private VystavaRepository vystavaRepository;
    @Autowired
    public VystavaServiceImpl(VystavaRepository vystavaRepository) {
        this.vystavaRepository = vystavaRepository;
    }
    @Override
    public Vystava getVystavaDetails(Long id) {
        return vystavaRepository.findById(id).orElse(null);
    }
    @Override
    public boolean createVystava(Vystava vystava) {
        vystavaRepository.save(vystava);
        return true;
    }
    @Override
    public boolean updateVystava(Vystava vystava) {
        Optional<Vystava> vystavaDB = vystavaRepository.findById(vystava.getId());
        if (vystavaDB.isPresent()) {
            vystavaRepository.save(vystava);
            return true;
        }
        return false;
    }
    @Override
    public Vystava deleteVystava(Long id) {
        Optional<Vystava> vystavaDB = vystavaRepository.findById(id);
        if (vystavaDB.isPresent()) {
            Vystava vystava = vystavaDB.get();
            vystavaRepository.delete(vystava);
            return vystava;
        }
        return null;
    }

    @Override
    public List<Vystava> getAllVystava() {
        return vystavaRepository.findAll();
    }
}
