package com.marvel.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {

    @RequestMapping({"","/","/index","/index.html"})
    public String getVetList(){
        return "owners/index";
    }
}
