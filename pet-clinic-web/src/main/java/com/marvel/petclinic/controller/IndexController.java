package com.marvel.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //Passing list of mapping which will redirect to the controller.
    @RequestMapping({"","/","index","index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/oups"})
    public String ErrorHandlerController() {
        return "NotImplementedYet";
    }
}
