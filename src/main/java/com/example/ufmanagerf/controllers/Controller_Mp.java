package com.example.ufmanagerf.controllers;

import com.example.ufmanagerf.model.Curs;
import com.example.ufmanagerf.model.Grup;
import com.example.ufmanagerf.model.Mp;
import com.example.ufmanagerf.model.Uf;
import com.example.ufmanagerf.services.Mp.Service_Mp;
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
public class Controller_Mp {

    @Autowired
    private Service_Mp MpService;

    @Autowired
    private Service_Uf UfSerivce;

    @GetMapping("/mps")
    public String index(Model m) {
        m.addAttribute("mps", MpService.getAll());
        return "Mp/index";
    }

    @GetMapping("/mps/create")
    public String create(Model m) {
        m.addAttribute("mp", new Mp());
        m.addAttribute("ufs", UfSerivce.getAllWhereMpIsNull());
        return "Mp/create";
    }

    @PostMapping("/mps/save")
    public String save(@Valid @ModelAttribute Mp mp, BindingResult bindingResult, Model m, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            if(MpService.exists(mp.getNomMp())){
                bindingResult.addError(new FieldError("mp", "nomMp", "El nom ja existeix"));
                return "Mp/create";
            }
            MpService.add(mp);
            redir.addFlashAttribute("flash", "La mp s'ha creat correctament");
        } else {
            System.out.println("Validation error");
            m.addAttribute("mp", mp);
            return "Mp/create";
        }
        return "redirect:/mps";
    }

    @GetMapping("/mps/delete/modal")
    public String deleteModal(HttpServletRequest request, RedirectAttributes redir, Model m) {
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("id", request.getParameter("id"));
        redir.addFlashAttribute("mssg", "Segur que vols eliminar la mp?");
        redir.addFlashAttribute("del", "mps");
        System.out.println(mp);
        return "redirect:/mps";
    }

    @GetMapping("/mps/delete")
    public String delete(HttpServletRequest request, RedirectAttributes redir) {
        MpService.remove(Integer.parseInt(request.getParameter("id")));
        redir.addFlashAttribute("flash", "La mp s'ha eliminat correctament");
        return "redirect:/mps";
    }

    @GetMapping("/mps/edit")
    public String edit(HttpServletRequest request, Model m) {
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("mp", mp);
        m.addAttribute("ufs", UfSerivce.getAllWhereMpIsNullOrMpIsEquals(mp));
        return "Mp/edit";
    }

    @PostMapping("/mps/editPost")
    public String editPost(@Valid @ModelAttribute Mp mp, BindingResult bindingResult, RedirectAttributes redir) {
        if (!bindingResult.hasErrors()) {
            if(MpService.existsEdit(mp.getNomMp(), mp.getIdMp())){
                bindingResult.addError(new FieldError("mp", "nomMp", "El nom ja existeix"));
                return "Mp/edit";
            };
            MpService.edit(mp);
            redir.addFlashAttribute("flash", "La mp s'ha editat correctament");
        } else {
            System.out.println("Validation error");
            return "Mp/edit";
        }
        return "redirect:/mps";
    }

    @GetMapping("/mps/ufs")
    public String filter(Model m, HttpServletRequest request) {
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("mp", mp);
        return "Mp/ufs";
    }

    @GetMapping("/mps/ufs/modi")
    public String ufsModi(Model m, HttpServletRequest request) {
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("id")));
        m.addAttribute("mp", mp);
        m.addAttribute("ufsNoMp", UfSerivce.getAllWhereMpIsNull());
        return "Mp/ufsModi";
    }

    @GetMapping("/mps/ufs/add")
    public String ufAdd(HttpServletRequest request, RedirectAttributes redir) {
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("idMp")));
        Uf uf = UfSerivce.get(Integer.parseInt(request.getParameter("idUf")));
        mp.setUf(uf);
        uf.setMp(mp);
        UfSerivce.edit(uf);
        MpService.edit(mp);
        return "redirect:modi?id=" + mp.getIdMp();
    }

    @GetMapping("/mps/ufs/remove")
    public String ufRemove(HttpServletRequest request, RedirectAttributes redir) {
        Mp mp = MpService.get(Integer.parseInt(request.getParameter("idMp")));
        Uf uf = UfSerivce.get(Integer.parseInt(request.getParameter("idUf")));
        mp.removeUf(uf);
        uf.setMp(null);
        UfSerivce.edit(uf);
        MpService.edit(mp);
        return "redirect:modi?id=" + mp.getIdMp();
    }
}
