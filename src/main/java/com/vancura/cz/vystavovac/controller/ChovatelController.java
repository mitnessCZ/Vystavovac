package com.vancura.cz.vystavovac.controller;


import com.vancura.cz.vystavovac.model.Chovatel;
import com.vancura.cz.vystavovac.service.ChovatelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChovatelController {
    private ChovatelService chovatelService;


    @Autowired
    public ChovatelController(ChovatelService chovatelService){
        this.chovatelService = chovatelService;

    }
    @GetMapping("/chovatel")
    public String listOfAllChovatel(Model model){
        model.addAttribute("chovatele",chovatelService.getAllChovatel());
        return "list_chovatele";
    }

    @GetMapping("/chovatel/detail/{id}")
    public String chovatelDetail(@PathVariable long id, Model model) {
        model.addAttribute("chovatel", chovatelService.getChovatelDetails(id));
        return "detail_chovatel";
    }
    @GetMapping("/chovatel/create")
    public String createChovatelForm(Model model) {
        model.addAttribute("chovatel", new Chovatel());
        model.addAttribute("edit", false);
        return "edit_chovatel";
    }
    @PostMapping("/chovatel/create")
    public String createChovatelSubmit(@Valid Chovatel chovatel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "edit_chovatel";
        }
        chovatelService.createChovatel(chovatel);
        return "redirect:/chovatel";
    }
    @GetMapping("/chovatel/edit/{id}")
    public String editChovatelForm(Model model, @PathVariable Long id) {
        model.addAttribute("chovatel", chovatelService.getChovatelDetails(id));
        model.addAttribute("edit", true);
        return "edit_chovatel";
    }

    @PostMapping("/chovatel/edit")
    public String editChovatelSubmit(@Valid Chovatel chovatel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "edit_chovatel";
        }
        chovatelService.updateChovatel(chovatel);
        return "redirect:/chovatel";
    }

    @GetMapping("/chovatel/delete/{id}")
    public String deleteChovatel(@PathVariable Long id) {
        chovatelService.deleteChovatel(id);
        return "redirect:/chovatel";
    }
}
