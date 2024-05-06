package com.finki.ukim.mk.predmetnik.web;

import com.finki.ukim.mk.predmetnik.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/preference")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @GetMapping("/change")
    public String getChangePreference(Model model) {
        model.addAttribute("preferences", this.preferenceService.findAll());
        return "change-preference";
    }

    @PostMapping("/change")
    public String changePreference(HttpServletRequest request,
                                   @RequestParam Integer id) {
        this.preferenceService.changePreference(id, Integer.parseInt(request.getRemoteUser()));
        return "redirect:/courses/filtered";
    }

}
