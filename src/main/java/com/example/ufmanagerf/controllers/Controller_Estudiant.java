package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.services.Estudiant.Service_Estudiant;
import com.example.ufmanagerf.services.Itemmat.Service_Itemmat;
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
public class Controller_Estudiant {

    @Autowired
    private Service_Estudiant EstudiantService;

    @GetMapping("/estudiants")
    public String index(Model m) {
        m.addAttribute("estudiants", EstudiantService.getAll());
        return "Estudiant/index";
    }

    @GetMapping("/estudiants/create")
    public String create(Model m) {
        m.addAttribute("estudiant", new Estudiant());
        return "Estudiant/create";
    }

    @PostMapping("/estudiants/save")
    public String save(@Valid @ModelAttribute Estudiant estudiant, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            EstudiantService.add(estudiant);
            redir.addFlashAttribute("flash", "L'estudiant s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("estudiant", estudiant);
            return "Estudiant/create";
        }
        return "redirect:/estudiants";
    }

    @GetMapping("/estudiants/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("mssg", "Segur que vols eliminar l'estudiant?");
        redir.addFlashAttribute("del", "estudiants");
        System.out.println(estudiant);
        return "redirect:/estudiants";
    }

    @GetMapping("/estudiants/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        EstudiantService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "L'estudiant s'ha eliminat correctament");
        return "redirect:/estudiants";
    }

    @GetMapping("/estudiants/edit")
    public String edit(HttpServletRequest request, Model m) {
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("estudiant", estudiant);
        return "Estudiant/edit";
    }

    @PostMapping("/estudiants/editPost")
    public String editPost(@Valid @ModelAttribute Estudiant estudiant, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        estudiant.setIdEstudiant(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            EstudiantService.edit(estudiant);
            redir.addFlashAttribute("flash", "L'estudiant s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Estudiant/edit";
        }
        return "redirect:/estudiants";
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
