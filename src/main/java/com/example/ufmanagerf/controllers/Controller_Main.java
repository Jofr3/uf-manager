package com.example.ufmanagerf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Main {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

// EXTRA (si tens temps)
// TODO arreglar el flash de error al eliminar

