package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Matricula;
import com.example.ufmanagerf.model.Uf;
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
public class Controller_Uf {

    @Autowired
    private Service_Uf UfService;

    @Autowired
    private Service_Itemmat ItemmatService;

    @GetMapping("/ufs")
    public String index(Model m) {
        m.addAttribute("ufs", UfService.getAll());
        return "Uf/index";
    }

    @GetMapping("/ufs/create")
    public String create(Model m) {
        m.addAttribute("uf", new Uf());
        return "Uf/create";
    }

    @PostMapping("/ufs/save")
    public String save(@Valid @ModelAttribute Uf uf, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            if (UfService.exists(uf.getNomUf())) {
                bindingResult.addError(new FieldError("uf", "nomUf", "El nom ja existeix"));
                return "Uf/create";
            }
            UfService.add(uf);
            redir.addFlashAttribute("flash", "La uf s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("uf", uf);
            return "Uf/create";
        }
        return "redirect:/ufs";
    }

    @GetMapping("/ufs/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("mssg", "Segur que vols eliminar la uf?");
        redir.addFlashAttribute("del", "ufs");
        System.out.println(uf);
        return "redirect:/ufs";
    }

    @GetMapping("/ufs/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        UfService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "La uf s'ha eliminat correctament");
        return "redirect:/ufs";
    }

    @GetMapping("/ufs/edit")
    public String edit(HttpServletRequest request, Model m) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("uf", uf);
        return "Uf/edit";
    }

    @PostMapping("/ufs/editPost")
    public String editPost(@Valid @ModelAttribute Uf uf, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        Uf newUf = UfService.get(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            if (UfService.existsEdit(uf.getNomUf(), Integer.parseInt(request.getParameter("id")))) {
                bindingResult.addError(new FieldError("uf", "nomUf", "El nom ja existeix"));
                return "Uf/edit";
            }
            newUf.setNumUf(uf.getNumUf());
            newUf.setNomUf(uf.getNomUf());
            newUf.setHoresUf(uf.getHoresUf());
            UfService.edit(newUf);
            redir.addFlashAttribute("flash", "La uf s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Uf/edit";
        }
        return "redirect:/ufs";
    }

    @GetMapping("/ufs/notes")
    public String notes(Model m, HttpServletRequest request) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("uf", uf);
        return "Uf/itemmat";
    }

    @GetMapping("/ufs/notes/modi")
    public String notaModi(Model m, HttpServletRequest request) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("uf", uf);
        m.addAttribute("notesNoUf", ItemmatService.getAllWhereUfIsNull());
        return "Uf/itemmatModi";
    }

    @GetMapping("/ufs/notes/add")
    public String notaAdd(HttpServletRequest request) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("idUf")));
        Itemmat nota = ItemmatService.get(Integer.parseInt(request.getParameter("idNota")));
        uf.setItemmat(nota);
        nota.setUf(uf);
        ItemmatService.edit(nota);
        UfService.edit(uf);
        return "redirect:modi?id=" + uf.getIdUf();
    }

    @GetMapping("/ufs/notes/remove")
    public String notaRemove(HttpServletRequest request) {
        Uf uf = UfService.get(Integer.parseInt(request.getParameter("idUf")));
        Itemmat nota = ItemmatService.get(Integer.parseInt(request.getParameter("idNota")));
        uf.removeItemmat(nota);
        nota.setUf(null);
        ItemmatService.edit(nota);
        UfService.edit(uf);
        return "redirect:modi?id=" + uf.getIdUf();
    }
}
