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

// TODO acabar index de notes (mostrar estudiant de la matricula)
// TODO la matricula de la nota es borra al editar-la
// TODO acabar estudiants i plans de expedient
// TODO affegir una variable nom a totes les classes que no la tenen i fe refractor a tot
// TODO hi han dates que nomes son l'any (o totes ns)
// TODO si intento crear una nota sense uf peta (posar un validate required)

// Final
// TODO repassar els validators, que tinguin sentit

// EXTRA (si tens temps)
// TODO canviar els edits que utilitzin la id per paremetre i no per el form en ocult

