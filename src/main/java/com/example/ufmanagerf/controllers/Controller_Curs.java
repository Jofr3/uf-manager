package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.services.Curs.Service_Curs;
import com.example.ufmanagerf.services.Estudiant.Service_Estudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class Controller_Curs {

    @Autowired
    private Service_Curs CursService;

    @GetMapping("/cursos")
    public String index(Model m) {
        m.addAttribute("cursos", CursService.getAll());
        return "Curs/index";
    }

    @GetMapping("/cursos/create")
    public String create(Model m) {
        m.addAttribute("curs", new Curs());
        return "Curs/create";
    }

    @PostMapping("/cursos/save")
    public String save(@Valid @ModelAttribute Curs curs, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            CursService.add(curs);
            redir.addFlashAttribute("flash", "El curs s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("curs", curs);
            return "Curs/create";
        }
        return "redirect:/cursos";
    }

    @GetMapping("/cursos/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Curs curs = CursService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("mssg", "Segur que vols eliminar el curs?");
        redir.addFlashAttribute("del", "cursos");
        System.out.println(curs);
        return "redirect:/cursos";
    }

    @GetMapping("/cursos/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        CursService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "El curs s'ha eliminat correctament");
        return "redirect:/cursos";
    }

    @GetMapping("/cursos/edit")
    public String edit(HttpServletRequest request, Model m) {
        Curs curs = CursService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("curs", curs);
        return "Curs/edit";
    }

    @PostMapping("/cursos/editPost")
    public String editPost(@Valid @ModelAttribute Curs curs, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        curs.setIdCurs(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            CursService.edit(curs);
            redir.addFlashAttribute("flash", "El curs s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Curs/edit";
        }
        return "redirect:/cursos";
    }
/*
    @GetMapping("/ufs/notes")
    public String filter(Model m, HttpServletRequest request) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("uf", uf);
        m.addAttribute("notes", ItemmatService.filterUf(uf));
        return "Uf/filter";
    }

    @GetMapping("/ufs/notes/edit")
    public String notes(Model m, HttpServletRequest request) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("uf", uf);
        m.addAttribute("notesNoUf", ItemmatService.getAllWhereUfIsNull());
        return "Uf/itemmats";
    }

    @PostMapping("/ufs/notes/editPost")
    public String notesPost(@ModelAttribute Uf uf, Model m, HttpServletRequest request, RedirectAttributes redir) {
        Uf UF = UfService.get(Integer.parseInt(request.getParameter("id")));
        List<Itemmat> allNotes = ItemmatService.getAll();
        List<Itemmat> newNotes = uf.getItemmats();
        UfService.removeNotes(UF, allNotes);
        UfService.addNotes(UF, newNotes);
        redir.addFlashAttribute("flash", "La uf s'ha editat correctament");
        return "redirect:/ufs";
    }
*/
}
