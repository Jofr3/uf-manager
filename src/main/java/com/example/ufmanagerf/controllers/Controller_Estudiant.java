package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.*;
import com.example.ufmanagerf.services.Estudiant.Service_Estudiant;
import com.example.ufmanagerf.services.Expedient.Service_Expedient;
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

    @Autowired
    private Service_Expedient ExpedientService;

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
            if (EstudiantService.exists(estudiant.getDniEstudiant())) {
            bindingResult.addError(new FieldError("estudiant", "dniEstudiant", "Aquest DNI ja esta en us"));
                return "Estudiant/create";
            }
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
        Estudiant newEstudiant = EstudiantService.get(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            if (EstudiantService.existsEdit(estudiant.getDniEstudiant(), Integer.parseInt(request.getParameter("id")))) {
                bindingResult.addError(new FieldError("estudiant", "dniEstudiant", "Aquest DNI ja esta en us"));
                return "Estudiant/edit";
            }
            newEstudiant.setNomEstudiant(estudiant.getNomEstudiant());
            newEstudiant.setCognomEstudiant(estudiant.getCognomEstudiant());
            newEstudiant.setMailEstudiant(estudiant.getMailEstudiant());
            newEstudiant.setDniEstudiant(estudiant.getDniEstudiant());
            newEstudiant.setDataNaixEstudiant(estudiant.getDataNaixEstudiant());
            EstudiantService.edit(newEstudiant);
            redir.addFlashAttribute("flash", "L'estudiant s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Estudiant/edit";
        }
        return "redirect:/estudiants";
    }

    @GetMapping("/estudiants/expedient")
    public String expedient(Model m, HttpServletRequest request) {
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("estudiant", estudiant);
        m.addAttribute("expedientsEstudiant", ExpedientService.getAllWhereEstudiantIs(estudiant));
        return "Estudiant/expedient";
    }

    @GetMapping("/estudiants/expedient/modi")
    public String expedientModi(Model m, HttpServletRequest request) {
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("estudiant", estudiant);
        m.addAttribute("expedientsEstudiant", ExpedientService.getAllWhereEstudiantIs(estudiant));
        m.addAttribute("expedientsNoEstudiant", ExpedientService.getAllWhereEstudiantIsNull());
        System.out.println(ExpedientService.getAllWhereEstudiantIs(estudiant));
        return "Estudiant/expedientModi";
    }

    @GetMapping("/estudiants/expedient/add")
    public String expedientAdd(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("idEstudiant")));
        Expedient expedient = ExpedientService.get(Integer.parseInt(request.getParameter("idExpedient")));
        estudiant.setExpedient(expedient);
        expedient.setEstudiant(estudiant);
        ExpedientService.edit(expedient);
        EstudiantService.edit(estudiant);
        return "redirect:modi?id=" + estudiant.getIdEstudiant();
    }

    @GetMapping("/estudiants/expedient/remove")
    public String expedientRemove(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("idEstudiant")));
        Expedient expedient = ExpedientService.get(Integer.parseInt(request.getParameter("idExpedient")));
        estudiant.setExpedient(null);
        expedient.setEstudiant(null);
        ExpedientService.edit(expedient);
        EstudiantService.edit(estudiant);
        return "redirect:modi?id=" + estudiant.getIdEstudiant();
    }
}
