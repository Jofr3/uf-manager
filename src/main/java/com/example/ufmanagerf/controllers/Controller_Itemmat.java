package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.services.Itemmat.Service_Itemmat;
import com.example.ufmanagerf.services.Uf.Service_Uf;
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
public class Controller_Itemmat {

    @Autowired
    private Service_Itemmat ItemmatService;

    @Autowired
    private Service_Uf UfService;

    @GetMapping("/notes")
    public String index(Model m) {
        m.addAttribute("notes", ItemmatService.getAll());
        return "Itemmat/index";
    }

    @GetMapping("/notes/create")
    public String create(Model m) {
        m.addAttribute("nota", new Itemmat());
        m.addAttribute("ufs", UfService.getAll());
        return "Itemmat/create";
    }

    @PostMapping("/notes/save")
    public String save(@Valid @ModelAttribute Itemmat nota, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            ItemmatService.add(nota);
            ItemmatService.addUf(nota, nota.getUf());
            redir.addFlashAttribute("flash", "La nota s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("nota", nota);
            return "Itemmat/create";
        }
        return "redirect:/notes";
    }

    @GetMapping("/notes/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Itemmat nota = ItemmatService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("obj", nota);
        System.out.println(nota);
        return "redirect:/notes";
    }

    @GetMapping("/notes/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        ItemmatService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "La nota s'ha eliminat correctament");
        return "redirect:/notes";
    }

    @GetMapping("/notes/edit")
    public String edit(HttpServletRequest request, Model m) {
        Itemmat nota = ItemmatService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("nota", nota);
        m.addAttribute("ufs", UfService.getAll());
        return "Itemmat/edit";
    }

    @PostMapping("/notes/editPost")
    public String editPost(@Valid @ModelAttribute Itemmat nota, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        Uf oldUf = UfService.get(Integer.parseInt(request.getParameter("uf")));
        nota.setIdItemmat(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            ItemmatService.edit(nota);
            redir.addFlashAttribute("flash", "La nota s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Itemmat/edit";
        }
        return "redirect:/notes";
    }
}