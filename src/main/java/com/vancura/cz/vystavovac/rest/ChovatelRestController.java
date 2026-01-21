package com.vancura.cz.vystavovac.rest;


import com.vancura.cz.vystavovac.model.Chovatel;
import com.vancura.cz.vystavovac.service.ChovatelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/chovatele")
public class ChovatelRestController {
    private ChovatelService chovatelService;
    @Autowired
    public ChovatelRestController(ChovatelService chovatelService){
        this.chovatelService = chovatelService;
    }

    @GetMapping("/getAll")
    public List<Chovatel> getAllChovatele(){
        return chovatelService.getAllChovatel();
    }

    @GetMapping("/getById/{id}")
    public Chovatel getChovatelById(@PathVariable Long id){
        return chovatelService.getChovatelDetails(id);
    }

    @PostMapping("/addNew")
    public String addNewChovatel(@RequestBody Chovatel chovatel){
        boolean created = chovatelService.createChovatel(chovatel);
        if (created) {
            return "Chovatel byl úspěšně vytvořen.";
        } else {
            return "Chyba při vytváření chovatele.";
        }
    }

    @PutMapping("/update")
    public String updateChovatel(@RequestBody Chovatel chovatel){
        boolean updated = chovatelService.updateChovatel(chovatel);
        if (updated) {
            return "Chovatel byl úspěšně aktualizován.";
        } else {
            return "Chyba při aktualizaci chovatele.";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteChovatel(@PathVariable Long id){
        Chovatel deletedChovatel = chovatelService.deleteChovatel(id);
        if (deletedChovatel != null) {
            return "Chovatel s ID " + id + " byl úspěšně smazán.";
        } else {
            return "Chovatel s ID " + id + " nebyl nalezen nebo se nepodařilo smazat.";
        }
    }
}
