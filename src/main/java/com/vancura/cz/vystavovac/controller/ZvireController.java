package com.vancura.cz.vystavovac.controller;

import com.vancura.cz.vystavovac.model.Zvire;
import com.vancura.cz.vystavovac.model.Chovatel;
import com.vancura.cz.vystavovac.service.ZvireService;
import com.vancura.cz.vystavovac.service.ChovatelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ZvireController {

    private ZvireService zvireService;
    private ChovatelService chovatelService;

    @Autowired
    public ZvireController(ZvireService zvireService, ChovatelService chovatelService) {
        this.zvireService = zvireService;
        this.chovatelService = chovatelService;
    }

    @GetMapping("/zvire")
    public String listOfAllZvire(Model model) {
        model.addAttribute("zvirata", zvireService.getAllZvirata());

        return "list_zvire";
    }

    @GetMapping("/zvire/detail/{id}")
    public String zvireDetail(@PathVariable Long id, Model model) {
        model.addAttribute("zvire", zvireService.getZvireDetails(id));
        return "detail_zvire";
    }

    @GetMapping("/zvire/create")
    public String createZvireForm(Model model) {
        model.addAttribute("zvire", new Zvire());
        model.addAttribute("chovatele", chovatelService.getAllChovatel());
        model.addAttribute("edit", false);
        return "edit_zvire";
    }

    @PostMapping("/zvire/create")
    public String createZvireSubmit(@Valid @ModelAttribute Zvire zvire, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chovatele", chovatelService.getAllChovatel());
            model.addAttribute("edit", false);
            return "edit_zvire";
        }
        zvireService.createZvire(zvire);
        return "redirect:/zvire";
    }

    @GetMapping("/zvire/edit/{id}")
    public String editZvireForm(Model model, @PathVariable Long id) {
        model.addAttribute("zvire", zvireService.getZvireDetails(id));
        model.addAttribute("chovatele", chovatelService.getAllChovatel());
        model.addAttribute("edit", true);
        return "edit_zvire";
    }

    @PostMapping("/zvire/edit")
    public String editZvireSubmit(@Valid @ModelAttribute Zvire zvire, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "edit_zvire";
        }
        zvireService.updateZvire(zvire);
        return "redirect:/zvire";
    }

    @GetMapping("/zvire/delete/{id}")
    public String deleteZvire(@PathVariable Long id) {
        zvireService.deleteZvire(id);
        return "redirect:/zvire";
    }
}
