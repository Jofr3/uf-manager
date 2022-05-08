package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.*;
import com.example.ufmanagerf.services.Curs.Service_Curs;
import com.example.ufmanagerf.services.Itemmat.Service_Itemmat;
import com.example.ufmanagerf.services.Mp.Service_Mp;
import com.example.ufmanagerf.services.Pla.Service_Pla;
import com.example.ufmanagerf.services.Uf.Service_Uf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class Controller_Pla {

    @Autowired
    private Service_Pla PlaService;

    @Autowired
    private Service_Mp MpService;

    @Autowired
    private Service_Curs CursService;

    @GetMapping("/plans")
    public String index(Model m) {
        m.addAttribute("plans", PlaService.getAll());
        return "Pla/index";
    }

    @GetMapping("/plans/create")
    public String create(Model m) {
        m.addAttribute("pla", new Pla());
        return "Pla/create";
    }

    @PostMapping("/plans/save")
    public String save(@Valid @ModelAttribute Pla pla, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            PlaService.add(pla);
            redir.addFlashAttribute("flash", "El pla s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("pla", pla);
            return "Pla/create";
        }
        return "redirect:/plans";
    }

    @GetMapping("/plans/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("mssg", "Segur que vols eliminar el pla?");
        redir.addFlashAttribute("del", "plans");
        System.out.println(pla);
        return "redirect:/plans";
    }

    @GetMapping("/plans/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        PlaService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "El pla s'ha eliminat correctament");
        return "redirect:/plans";
    }

    @GetMapping("/plans/edit")
    public String edit(HttpServletRequest request, Model m) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("pla", pla);
        return "Pla/edit";
    }

    @PostMapping("/plans/editPost")
    public String editPost(@Valid @ModelAttribute Pla pla, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        Pla newPla = PlaService.get(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            newPla.setNomPla(pla.getNomPla());
            newPla.setEstudi(pla.getEstudi());
            PlaService.edit(newPla);
            redir.addFlashAttribute("flash", "El pla s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Pla/edit";
        }
        return "redirect:/plans";
    }

    @GetMapping("/plans/mps")
    public String mps(Model m, HttpServletRequest request) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("pla", pla);
        return "Pla/mps";
    }

    @GetMapping("/plans/mps/modi")
    public String mpsModi(Model m, HttpServletRequest request) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("pla", pla);
        m.addAttribute("mpsNoPla", MpService.getAllWherePlaIsNull());
        return "Pla/mpsModi";
    }

    @GetMapping("/plans/mps/add")
    public String mpAdd(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("idPla")));
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("idMp")));
        pla.setMp(mp);
        mp.setPla(pla);
        PlaService.edit(pla);
        MpService.edit(mp);
        redir.addFlashAttribute("pla", pla);
        redir.addFlashAttribute("mpsNoPla", MpService.getAllWherePlaIsNull());
        return "redirect:modi?id=" + pla.getIdPla();
    }

    @GetMapping("/plans/mps/remove")
    public String mpRemove(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("idPla")));
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("idMp")));
        pla.removeMp(mp);
        mp.setPla(null);
        PlaService.edit(pla);
        MpService.edit(mp);
        redir.addFlashAttribute("pla", pla);
        redir.addFlashAttribute("mpsNoPla", MpService.getAllWherePlaIsNull());
        return "redirect:modi?id=" + pla.getIdPla();
    }

    @GetMapping("/plans/cursos")
    public String cursos(Model m, HttpServletRequest request) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("pla", pla);
        return "Pla/cursos";
    }

    @GetMapping("/plans/cursos/modi")
    public String cursosModi(Model m, HttpServletRequest request) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("pla", pla);
        m.addAttribute("cursosNoPla", CursService.getAllWhereCursIsNull());
        return "Pla/cursosModi";
    }

    @GetMapping("/plans/cursos/add")
    public String cursAdd(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("idPla")));
        Curs curs = CursService.get(Integer.parseInt(request.getParameter("idCurs")));
        pla.setCurs(curs);
        curs.setPla(pla);
        PlaService.edit(pla);
        CursService.edit(curs);
        redir.addFlashAttribute("pla", pla);
        redir.addFlashAttribute("cursosNoPla", CursService.getAllWhereCursIsNull());
        return "redirect:modi?id=" + pla.getIdPla();
    }

    @GetMapping("/plans/cursos/remove")
    public String cursRemove(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Pla pla = PlaService.get(Integer.parseInt(request.getParameter("idPla")));
        Curs curs = CursService.get(Integer.parseInt(request.getParameter("idCurs")));
        pla.removeCurs(curs);
        curs.setPla(null);
        PlaService.edit(pla);
        CursService.edit(curs);
        redir.addFlashAttribute("pla", pla);
        redir.addFlashAttribute("cursosNoPla", CursService.getAllWhereCursIsNull());
        return "redirect:modi?id=" + pla.getIdPla();
    }

/*
    @GetMapping("/plans/mps")
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