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

// Final
// TODO repassar els validators, que tinguin sentit

// EXTRA (si tens temps)
// TODO borrar tots els modals dels Modi
// TODO borrar totes les funcions i codi no utilitzat

