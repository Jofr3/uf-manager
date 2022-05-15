package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.services.Curs.Service_Curs;
import com.example.ufmanagerf.services.Pla.Service_Pla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Main {

    @Autowired
    private Service_Curs CursService;

    @Autowired
    private Service_Pla PlaService;

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("plans", PlaService.getAll());
        m.addAttribute("cursActiu", CursService.getActiveCurs());
        m.addAttribute("cursosInactius", CursService.getAllInactiveCursos());
        return "index";
    }
}

// TODO arreglar cascade on delete
// TODO arreglar el flash de error al eliminar
// TODo main menu

