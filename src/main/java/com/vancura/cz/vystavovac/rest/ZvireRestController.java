package com.vancura.cz.vystavovac.rest;

import com.vancura.cz.vystavovac.model.Zvire;
import com.vancura.cz.vystavovac.service.ZvireService;
import com.vancura.cz.vystavovac.service.ZvireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZvireRestController {
    private ZvireService zvireService;
    @Autowired
    public ZvireRestController(ZvireService zvireService){
        this.zvireService = zvireService;
    }
    @GetMapping("/rest/getAllZvire")
    public List<Zvire> getAllZvire(){
        return zvireService.getAllZvirata();
    }
    @GetMapping("/rest/getZvireById")
    public Zvire getZvireById(@PathVariable Long id){
        return zvireService.getZvireDetails(id);
    }
    @PostMapping("/rest/addNewZvire")
    public String addNewZvire(@RequestBody Zvire zvire){
        boolean created = zvireService.createZvire(zvire);
        if (created) {
            return "Zvire bylo úspěšně vytvořeno.";
        } else {
            return "Chyba při vytváření zvířete.";
        }
    }
    @PutMapping("/rest/update")
    public String updateZvire(@RequestBody Zvire zvire){
        boolean updated = zvireService.updateZvire(zvire);
        if (updated) {
            return "Zvire bylo úspěšně aktualizováno.";
        } else {
            return "Chyba při aktualizaci zvířete.";
        }
    }

    @DeleteMapping("/rest/delete/{id}")
    public String deleteZvire(@PathVariable Long id){
        Zvire deletedZvire = zvireService.deleteZvire(id);
        if (deletedZvire != null) {
            return "Zvire s ID " + id + " bylo úspěšně smazáno.";
        } else {
            return "Zvire s ID " + id + " nebylo nalezeno nebo se nepodařilo smazat.";
        }
    }
}
