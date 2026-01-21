package com.vancura.cz.vystavovac.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeyController {
    @GetMapping("/")
    public String home(){
        return "Vitejte";
    }

   @GetMapping("/403")
    public String forbidden() {
        return "403";
   }
}
