package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.services.Curs.Service_Curs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Main {

    @Autowired
    private Service_Curs CursService;

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("cursos", CursService.getAll());
        return "index";
    }
}

// EXTRA (si tens temps)
// TODO arreglar el flash de error al eliminar

