package com.vancura.cz.vystavovac.service;

import com.vancura.cz.vystavovac.model.Zvire;
import com.vancura.cz.vystavovac.repository.ZvireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class ZvireServiceImpl  implements ZvireService{
    private final ZvireRepository zvireRepository;

    @Autowired
    public ZvireServiceImpl(ZvireRepository zvireRepository){
        this.zvireRepository = zvireRepository;
    }

    @Override
    public boolean createZvire(Zvire zvire) {
        zvireRepository.save(zvire);
        return true;
    }
@Override
    public boolean updateZvire(Zvire zvire){
    Optional<Zvire> zvireDB = zvireRepository.findById(zvire.getId());
    if (zvireDB.isPresent()) {
        zvireRepository.save(zvire);
        return true;
    }
    return false;
}
    @Override
    public Zvire getZvireDetails(Long id) {
        return zvireRepository.findById(id).orElse(null);
    }
    @Override
    public Zvire deleteZvire(Long id) {
        Optional<Zvire> zvireDB = zvireRepository.findById(id);
        if (zvireDB.isPresent()) {
            Zvire zvire = zvireDB.get();
            zvireRepository.delete(zvire);
            return zvire;
        }
        return null;
    }
    @Override
    public List<Zvire> getAllZvirata() {
        return zvireRepository.findAll();
    }
}
