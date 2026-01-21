package com.vancura.cz.vystavovac.rest;


import com.vancura.cz.vystavovac.model.Posuzovatel;
import com.vancura.cz.vystavovac.service.PosuzovatelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/posuzovatele")
public class PosuzovatelRestController {
    private PosuzovatelService posuzovatelService;
    @Autowired
    public PosuzovatelRestController(PosuzovatelService posuzovatelService){
        this.posuzovatelService = posuzovatelService;
    }
    @GetMapping("/getAll")
    public List<Posuzovatel> getAllPosuzovatele(){
        return posuzovatelService.getAllPosuzovatel();
    }

    @GetMapping("/getById/{id}")
    public Posuzovatel getPosuzovatelById(@PathVariable Long id){
        return posuzovatelService.getPosuzovatelDetails(id);
    }

    @PostMapping("/addNew")
    public String addNewPosuzovatel(@RequestBody Posuzovatel posuzovatel){
        Posuzovatel created = posuzovatelService.createPosuzovatel(posuzovatel);
        if (created != null) {
            return "Posuzovatel byl úspěšně vytvořen.";
        } else {
            return "Chyba při vytváření posuzovatele.";
        }
    }

    @PutMapping("/update")
    public String updatePosuzovatel(@RequestBody Posuzovatel posuzovatel){
        Posuzovatel updated = posuzovatelService.updatePosuzovatel(posuzovatel);
        if (updated != null) {
            return "Posuzovatel byl úspěšně aktualizován.";
        } else {
            return "Chyba při aktualizaci posuzovatele.";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deletePosuzovatel(@PathVariable Long id){
        Posuzovatel deletedPosuzovatel = posuzovatelService.deletePosuzovatel(id);
        if (deletedPosuzovatel != null) {
            return "Posuzovatel s ID " + id + " byl úspěšně smazán.";
        } else {
            return "Posuzovatel s ID " + id + " nebyl nalezen nebo se nepodařilo smazat.";
        }
    }
}
