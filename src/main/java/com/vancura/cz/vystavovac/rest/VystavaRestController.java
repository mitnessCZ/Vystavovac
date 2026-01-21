package com.vancura.cz.vystavovac.rest;


import com.vancura.cz.vystavovac.model.Vystava;
import com.vancura.cz.vystavovac.service.VystavaService;
import com.vancura.cz.vystavovac.service.ZvireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VystavaRestController {
    private VystavaService vystavaService;
    @Autowired
    public VystavaRestController(ZvireService zvireService){
        this.vystavaService = vystavaService;
    }
    @GetMapping("/getAll")
    public List<Vystava> getAllVystavy(){
        return vystavaService.getAllVystava();
    }

    @GetMapping("/getById/{id}")
    public Vystava getVystavaById(@PathVariable Long id){
        return vystavaService.getVystavaDetails(id);
    }

    @PostMapping("/addNew")
    public String addNewVystava(@RequestBody Vystava vystava){
        boolean created = vystavaService.createVystava(vystava);
        if (created) {
            return "Vystava byla úspěšně vytvořena.";
        } else {
            return "Chyba při vytváření výstavy.";
        }
    }

    @PutMapping("/update")
    public String updateVystava(@RequestBody Vystava vystava){
        boolean updated = vystavaService.updateVystava(vystava);
        if (updated) {
            return "Vystava byla úspěšně aktualizována.";
        } else {
            return "Chyba při aktualizaci výstavy.";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVystava(@PathVariable Long id){
        Vystava deletedVystava = vystavaService.deleteVystava(id);
        if (deletedVystava != null) {
            return "Vystava s ID " + id + " byla úspěšně smazána.";
        } else {
            return "Vystava s ID " + id + " nebyla nalezena nebo se nepodařilo smazat.";
        }
    }
}
