package ru.simple.opds.scaner.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpdsScanerController {

    @GetMapping({"/", "/index", "index.html"})
    public String getStart(Model model) {
        return "index";
    }
}
