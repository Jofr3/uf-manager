package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Estudiant;
import com.example.ufmanagerf.model.Grup;
import com.example.ufmanagerf.services.Estudiant.Service_Estudiant;
import com.example.ufmanagerf.services.Grup.Service_Grup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class Controller_Grup {

    @Autowired
    private Service_Grup GrupService;

    @Autowired
    private Service_Estudiant EstudiantService;

    @GetMapping("/grups")
    public String index(Model m) {
        m.addAttribute("grups", GrupService.getAll());
        return "Grup/index";
    }

    @GetMapping("/grups/create")
    public String create(Model m) {
        m.addAttribute("grup", new Grup());
        return "Grup/create";
    }

    @PostMapping("/grups/save")
    public String save(@Valid @ModelAttribute Grup grup, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            if (GrupService.exists(grup.getNomGrup())) {
                bindingResult.addError(new FieldError("grup", "nomGrup", "El nom ja existeix"));
                return "Grup/create";
            }
            GrupService.add(grup);
            redir.addFlashAttribute("flash", "El grup s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("grup", grup);
            return "Grup/create";
        }
        return "redirect:/grups";
    }

    @GetMapping("/grups/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Grup grup = GrupService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("mssg", "Segur que vols eliminar el grup?");
        redir.addFlashAttribute("del", "grups");
        System.out.println(grup);
        return "redirect:/grups";
    }

    @GetMapping("/grups/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        GrupService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "El grup s'ha eliminat correctament");
        return "redirect:/grups";
    }

    @GetMapping("/grups/edit")
    public String edit(HttpServletRequest request, Model m) {
        Grup grup = GrupService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("grup", grup);
        return "Grup/edit";
    }

    @PostMapping("/grups/editPost")
    public String editPost(@Valid @ModelAttribute Grup grup, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        Grup newGrup = GrupService.get(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            if (GrupService.existsEdit(grup.getNomGrup(), Integer.parseInt(request.getParameter("id")))) {
                bindingResult.addError(new FieldError("grup", "nomGrup", "El nom ja existeix"));
                return "Grup/edit";
            }
            newGrup.setNomGrup(grup.getNomGrup());
            GrupService.edit(newGrup);
            redir.addFlashAttribute("flash", "El grup s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Grup/edit";
        }
        return "redirect:/grups";
    }

    @GetMapping("/grups/estudiants")
    public String estudiants(Model m, HttpServletRequest request) {
        Grup grup = GrupService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("grup", grup);
        return "Grup/estudiants";
    }

    @GetMapping("/grups/estudiants/modi")
    public String estudiantsModi(Model m, HttpServletRequest request) {
        Grup grup = GrupService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("grup", grup);
        m.addAttribute("estudiantsNoGrup", EstudiantService.getAllWhereGrupIsNull());
        return "Grup/estudiantsModi";
    }

    @GetMapping("/grups/estudiants/add")
    public String estudiantsAdd(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Grup grup = GrupService.get(Integer.parseInt(request.getParameter("idGrup")));
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("idEstudiant")));
        grup.setEstudiant(estudiant);
        estudiant.setGrup(grup);
        EstudiantService.edit(estudiant);
        GrupService.edit(grup);
        return "redirect:modi?id=" + grup.getIdGrup();
    }

    @GetMapping("/grups/estudiants/remove")
    public String estudiantsRemove(Model m, HttpServletRequest request, RedirectAttributes redir) {
        Grup grup = GrupService.get(Integer.parseInt(request.getParameter("idGrup")));
        Estudiant estudiant = EstudiantService.get(Integer.parseInt(request.getParameter("idEstudiant")));
        grup.removeEstudiant(estudiant);
        estudiant.setGrup(null);
        EstudiantService.edit(estudiant);
        GrupService.edit(grup);
        return "redirect:modi?id=" + grup.getIdGrup();
    }
}
