package com.vancura.cz.vystavovac.controller;

import com.vancura.cz.vystavovac.model.Posuzovatel;
import com.vancura.cz.vystavovac.service.PosuzovatelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PosuzovatelController {
    private PosuzovatelService posuzovatelService;

    @Autowired
    public PosuzovatelController(PosuzovatelService posuzovatelService) {
        this.posuzovatelService = posuzovatelService;
    }

    @GetMapping("/posuzovatel")
    public String listOfAllPosuzovatel(Model model) {
        model.addAttribute("posuzovatele", posuzovatelService.getAllPosuzovatel());
        return "list_posuzovatel";
    }

    @GetMapping("/posuzovatel/detail/{id}")
    public String posuzovatelDetail(@PathVariable Long id, Model model) {
        model.addAttribute("posuzovatel", posuzovatelService.getPosuzovatelDetails(id));
        return "detail_posuzovatel";
    }

    @GetMapping("/posuzovatel/create")
    public String createPosuzovatelForm(Model model) {
        model.addAttribute("posuzovatel", new Posuzovatel());
        model.addAttribute("edit", false);
        return "edit_posuzovatel";
    }

    @PostMapping("/posuzovatel/create")
    public String createPosuzovatelSubmit(@Valid @ModelAttribute Posuzovatel posuzovatel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "edit_posuzovatel";
        }
        posuzovatelService.createPosuzovatel(posuzovatel);
        return "redirect:/posuzovatel";
    }

    @GetMapping("/posuzovatel/edit/{id}")
    public String editPosuzovatelForm(Model model, @PathVariable Long id) {
        model.addAttribute("posuzovatel", posuzovatelService.getPosuzovatelDetails(id));
        model.addAttribute("edit", true);
        return "edit_posuzovatel";
    }

    @PostMapping("/posuzovatel/edit")
    public String editPosuzovatelSubmit(@Valid Posuzovatel posuzovatel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "edit_posuzovatel";
        }
        posuzovatelService.updatePosuzovatel(posuzovatel);
        return "redirect:/posuzovatel";
    }

    @GetMapping("/posuzovatel/delete/{id}")
    public String deletePosuzovatel(@PathVariable Long id) {
        posuzovatelService.deletePosuzovatel(id);
        return "redirect:/posuzovatel";
    }
}
