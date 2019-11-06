package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.WizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class WizardController {

    private WizardRepository repository = new WizardRepository();

    @GetMapping("/wizards")
    public String getAll(Model model) {

        model.addAttribute("wizards", repository.findAll());

        return "wizards";
    }

    @GetMapping("/wizard")
    public String getWizard(Model model,
                            @RequestParam(required = false, defaultValue = "-1") Long delete,
                            @RequestParam(required = false) Long id) {

        if (delete != -1) {
            repository.deleteById(delete);
            return "redirect:wizards";
        }
        if (id != null) {
            model.addAttribute("wizard", repository.findById(id));
        }

        return "wizard";
    }

    @PostMapping("/wizard")
    public String postWizard(Model model,
                             @RequestParam Long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam Date birthday,
                             @RequestParam(required = false, defaultValue = "") String birthPlace,
                             @RequestParam(required = false, defaultValue = "") String biography,
                             @RequestParam(required = false, defaultValue = "false") boolean muggle) {

        Wizard wizard = new Wizard(id, firstName, lastName, birthday, birthPlace, biography, muggle);
        if (id != -1) {
            model.addAttribute("wizard", repository.update(wizard));
        } else {
            model.addAttribute("wizard", repository.save(wizard));
        }

        return "redirect:wizards";
    }
}
