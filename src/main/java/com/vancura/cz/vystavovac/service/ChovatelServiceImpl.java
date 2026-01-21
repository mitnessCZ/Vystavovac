package com.vancura.cz.vystavovac.service;

import com.vancura.cz.vystavovac.model.Chovatel;
import com.vancura.cz.vystavovac.repository.ChovatelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChovatelServiceImpl implements ChovatelService{

    private ChovatelRepository chovatelRepository;

    @Autowired
    public ChovatelServiceImpl(ChovatelRepository chovatelRepository){
        this.chovatelRepository = chovatelRepository;
    }

    @Override
    public Chovatel getChovatelDetails(Long id) {
        return chovatelRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createChovatel(Chovatel chovatel) {
        chovatelRepository.save(chovatel);
        return true;
    }

    @Override
    public boolean updateChovatel(Chovatel chovatel)
    {
        Optional<Chovatel> chovatelDB = chovatelRepository.findById(chovatel.getId());
        if (chovatelDB.isPresent()){
            chovatelRepository.save(chovatel);
            return true;
        }
        return false;
    }

    @Override
    public Chovatel deleteChovatel(Long id) {
        Optional<Chovatel> chovatelDB = chovatelRepository.findById(id);
        if (chovatelDB.isPresent()) {
            Chovatel chovatel = chovatelDB.get();
            chovatelRepository.delete(chovatel);
            return chovatel;
        }
        return null;
    }
    @Override
    public List<Chovatel> getAllChovatel() {
        return chovatelRepository.findAll();
    }
    @Override
    public Chovatel getChovatelById(Long id) {
        return chovatelRepository.findById(id).orElse(null);
    }
}
