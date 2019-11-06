package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchoolController {

    private SchoolRepository repository = new SchoolRepository();

    @GetMapping("/schools")
    public String getAll(Model model) {

        model.addAttribute("schools", repository.findAll());

        return "schools";
    }

    @GetMapping("/school")
    public String getSchool(Model model,
                            @RequestParam(required = false, defaultValue = "-1") Long delete,
                            @RequestParam(required = false) Long id) {

        if (delete != -1) {
            repository.deleteById(delete);
            return "redirect:schools";
        }
        if (id != null) {
            model.addAttribute("school", repository.findById(id));
        }

        return "school";
    }

    @PostMapping("/school")
    public String postSchool(Model model,
                             @RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam Long capacity,
                             @RequestParam String country) {

        School school = new School(id, name, capacity, country);
        if (id != -1) {
            model.addAttribute("school", repository.update(school));
        } else {
            model.addAttribute("school", repository.save(school));
        }

        return "redirect:schools";
    }
}
