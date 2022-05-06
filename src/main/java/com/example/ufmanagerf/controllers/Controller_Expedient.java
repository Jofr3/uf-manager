package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Expedient;
import com.example.ufmanagerf.model.Itemmat;
import com.example.ufmanagerf.model.Matricula;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.services.Expedient.Service_Expedient;
import com.example.ufmanagerf.services.Itemmat.Service_Itemmat;
import com.example.ufmanagerf.services.Matricula.Service_Matricula;
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
public class Controller_Expedient {

    @Autowired
    private Service_Expedient ExpedientService;

    @Autowired
    private Service_Matricula MatriculaService;

    @GetMapping("/expedients")
    public String index(Model m) {
        m.addAttribute("expedients", ExpedientService.getAll());
        return "Expedient/index";
    }

    @GetMapping("/expedients/create")
    public String create(Model m) {
        m.addAttribute("expedient", new Expedient());
        m.addAttribute("matricules", MatriculaService.getAllWhereExpedientIsNull());
        return "Expedient/create";
    }

    @PostMapping("/expedients/save")
    public String save(@Valid @ModelAttribute Expedient expedient, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            ExpedientService.add(expedient);
            //ExpedientService.addMatricules(expedient, expedient.getMatricules());
            Expedient expedient1 = ExpedientService.get(expedient.getIdExpedient());
            System.out.println(expedient1);
            System.out.println(expedient1.getMatricules());
            redir.addFlashAttribute("flash", "L'expedient s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("expedient", expedient);
            return "Expedient/create";
        }
        return "redirect:/expedients";
    }

    @GetMapping("/expedients/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Expedient expedient = ExpedientService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("obj", expedient);
        System.out.println(expedient);
        return "redirect:/expedients";
    }

    @GetMapping("/expedients/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        ExpedientService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "L'expedient s'ha eliminat correctament");
        return "redirect:/expedients";
    }

    @GetMapping("/expedients/edit")
    public String edit(HttpServletRequest request, Model m) {
        Expedient expedient = ExpedientService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("expedient", expedient);
        m.addAttribute("matricules", MatriculaService.getAllWhereExpedientIsNullOrExpedientIsEquals(expedient));
        return "Expedient/edit";
    }

    @PostMapping("/expedients/editPost")
    public String editPost(@Valid @ModelAttribute Expedient expedient, HttpServletRequest request, BindingResult bindingResult, RedirectAttributes redir) {
        expedient.setIdExpedient(Integer.parseInt(request.getParameter("id")));
        if (!bindingResult.hasErrors()) {
            List<Matricula> allMatricules = MatriculaService.getAll();
            List<Matricula> newMatricules = expedient.getMatricules();
            ExpedientService.edit(expedient);
            ExpedientService.removeMatricules(expedient, allMatricules);
            ExpedientService.addMatricules(expedient, newMatricules);
            redir.addFlashAttribute("flash", "L'expedient s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Expedient/edit";
        }
        return "redirect:/expedients";
    }

    @GetMapping("/expedients/matricules")
    public String filter(Model m, HttpServletRequest request) {
        Expedient expedient = ExpedientService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("expedient", expedient);
        m.addAttribute("matricules", ExpedientService.filterMatricula(expedient));
        return "Expedient/filter";
    }

    @GetMapping("/expedients/matricules/edit")
    public String notes(Model m, HttpServletRequest request) {
        Expedient expedient = ExpedientService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("expedient", expedient);
        m.addAttribute("matriculesNoExpedient", MatriculaService.getAllWhereExpedientIsNull());
        return "Expedient/matricules";
    }

    @PostMapping("/expedient/matricules/editPost")
    public String notesPost(@ModelAttribute Expedient expedient, Model m, HttpServletRequest request, RedirectAttributes redir) {
        Expedient EXPEDIENT = ExpedientService.get(Integer.parseInt(request.getParameter("id")));
        List<Matricula> allMatricules = MatriculaService.getAll();
        List<Matricula> newMatricules = expedient.getMatricules();
        ExpedientService.removeMatricules(EXPEDIENT, allMatricules);
        ExpedientService.addMatricules(EXPEDIENT, newMatricules);
        redir.addFlashAttribute("flash", "La matricula s'ha editat correctament");
        return "redirect:/expedients";
    }
/*



*/
}
