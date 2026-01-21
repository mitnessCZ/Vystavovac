package com.vancura.cz.vystavovac.controller;

import com.vancura.cz.vystavovac.model.Vystava;
import com.vancura.cz.vystavovac.service.VystavaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class VystavaController {
    private VystavaService vystavaService;

    @Autowired
    public VystavaController(VystavaService vystavaService) {
        this.vystavaService = vystavaService;
    }

    @GetMapping("/vystava")
    public String listOfAllVystava(Model model) {
        model.addAttribute("vystavy", vystavaService.getAllVystava());
        return "list_vystava";
    }

    @GetMapping("/vystava/detail/{id}")
    public String vystavaDetail(@PathVariable Long id, Model model) {
        Vystava vystava = vystavaService.getVystavaDetails(id);
        model.addAttribute("vystava", vystava);
        model.addAttribute("zvirata", vystava.getZvirata());
        model.addAttribute("chovatele", vystava.getChovatele());
        model.addAttribute("posuzovatele", vystava.getPosuzovatele());
       //debug test
        if (vystava != null) {
            System.out.println("Vystava: " + vystava.getNazev());
            System.out.println("Pocet Zvirat: " + vystava.getPocetZvirat());
            System.out.println("Pocet Chovatelu: " + vystava.getPocetChovatelu());
            System.out.println("Pocet Posuzovatelu: " + vystava.getPocetPosuzovatelu());
        } else {
            System.out.println("Vystava not found with ID: " + id);
        }
        model.addAttribute("vystava", vystavaService.getVystavaDetails(id));
        return "detail_vystava";
    }


    @GetMapping("/vystava/create")
    public String createVystavaForm(Model model) {
        model.addAttribute("vystava", new Vystava());
        model.addAttribute("edit", false);
        return "edit_vystava";
    }

    @PostMapping("/vystava/create")
    public String createVystavaSubmit(@Valid @ModelAttribute Vystava vystava, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            return "edit_vystava";
        }
        vystavaService.createVystava(vystava);
        return "redirect:/vystava";
    }

    @GetMapping("/vystava/edit/{id}")
    public String editVystavaForm(Model model, @PathVariable Long id) {
        Vystava vystava = vystavaService.getVystavaDetails(id);
        if (vystava == null) {
            return "redirect:/vystava";
        }
        model.addAttribute("vystava", vystavaService.getVystavaDetails(id));
        model.addAttribute("edit", true);
        return "edit_vystava";
    }

    @PostMapping("/vystava/edit")
    public String editVystavaSubmit(@Valid @ModelAttribute Vystava vystava, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "edit_vystava";
        }
        vystavaService.updateVystava(vystava);
        return "redirect:/vystava";
    }

    @GetMapping("/vystava/delete/{id}")
    public String deleteVystava(@PathVariable Long id) {
        vystavaService.deleteVystava(id);
        return "redirect:/vystava";
    }
}
