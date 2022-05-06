package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Matricula;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.services.Itemmat.Service_Itemmat;
import com.example.ufmanagerf.services.Matricula.Service_Matricula;
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
public class Controller_Matricula {

    @Autowired
    private Service_Matricula MatriculaService;

    @Autowired
    private Service_Itemmat ItemmatService;

    @GetMapping("/matricules")
    public String index(Model m) {
        m.addAttribute("matricules", MatriculaService.getAll());
        return "Matricula/index";
    }

    @GetMapping("/matricules/create")
    public String create(Model m) {
        m.addAttribute("matricula", new Matricula());
        m.addAttribute("notes", ItemmatService.getAllWhereMatriculaIsNull());
        return "Matricula/create";
    }

    @PostMapping("/matricules/save")
    public String save(@Valid @ModelAttribute Matricula matricula, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            MatriculaService.add(matricula);
            MatriculaService.addNotes(matricula, matricula.getItemmats());
            redir.addFlashAttribute("flash", "La matricula s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("matricula", matricula);
            return "Matricula/create";
        }
        return "redirect:/matricules";
    }

    @GetMapping("/matricules/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Matricula matricula = MatriculaService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("obj", matricula);
        System.out.println(matricula);
        return "redirect:/matricules";
    }

    @GetMapping("/matricules/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        MatriculaService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "La matricula s'ha eliminat correctament");
        return "redirect:/matricules";
    }

    @GetMapping("/matricules/edit")
    public String edit(HttpServletRequest request, Model m) {
        Matricula matricula = MatriculaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("matricula", matricula);
        m.addAttribute("notes", ItemmatService.getAllWhereMatriculaIsNullOrMatriculaIs(matricula));
        return "Matricula/edit";
    }

    @PostMapping("/matricules/editPost")
    public String editPost(@Valid @ModelAttribute Matricula matricula, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        matricula.setIdMatricula(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            List<Itemmat> allNotes = ItemmatService.getAll();
            List<Itemmat> newNotes = matricula.getItemmats();
            MatriculaService.edit(matricula);
            MatriculaService.removeNotes(matricula, allNotes);
            MatriculaService.addNotes(matricula, newNotes);
            redir.addFlashAttribute("flash", "La matricula s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Matricula/edit";
        }
        return "redirect:/matricules";
    }

    @GetMapping("/matricules/notes")
    public String filter(Model m, HttpServletRequest request) {
        Matricula matricula = MatriculaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("matricula", matricula);
        m.addAttribute("notes", ItemmatService.filterMatricula(matricula));
        return "Matricula/filter";
    }

    @GetMapping("/matricules/notes/edit")
    public String notes(Model m, HttpServletRequest request) {
        Matricula matricula = MatriculaService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("matricula", matricula);
        m.addAttribute("notesNoMatricula", ItemmatService.getAllWhereMatriculaIsNull());
        return "Matricula/itemmats";
    }

    @PostMapping("/matricules/notes/editPost")
    public String notesPost(@ModelAttribute Matricula matricula, HttpServletRequest request, RedirectAttributes redir) {
        Matricula MATRICULA = MatriculaService.get(Integer.parseInt(request.getParameter("id")));
        List<Itemmat> allNotes = ItemmatService.getAll();
        List<Itemmat> newNotes = matricula.getItemmats();
        System.out.println(newNotes);
        MatriculaService.removeNotes(MATRICULA, allNotes);
        MatriculaService.addNotes(MATRICULA, newNotes);
        redir.addFlashAttribute("flash", "La matricula s'ha editat correctament");
        return "redirect:/matricules";
    }
}
