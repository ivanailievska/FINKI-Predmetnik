package com.finki.ukim.mk.predmetnik.web;


import com.finki.ukim.mk.predmetnik.exceptions.InvalidArgumentsException;
import com.finki.ukim.mk.predmetnik.exceptions.PasswordsDoNotMatchException;
import com.finki.ukim.mk.predmetnik.exceptions.UsernameAlreadyExistsException;
import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.models.Program;
import com.finki.ukim.mk.predmetnik.models.Role;
import com.finki.ukim.mk.predmetnik.service.PreferenceService;
import com.finki.ukim.mk.predmetnik.service.ProgramService;
import com.finki.ukim.mk.predmetnik.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final PreferenceService preferenceService;
    private final ProgramService programService;
    private final StudentService studentService;

    public RegisterController(PreferenceService preferenceService, ProgramService programService, StudentService studentService) {
        this.preferenceService = preferenceService;
        this.programService = programService;
        this.studentService = studentService;
    }

    @GetMapping
    public String getForm(Model model) {
        List<Preference> preferences = this.preferenceService.findAll();
        List<Program> programs = this.programService.findAll();
        model.addAttribute("preferences", preferences);
        model.addAttribute("programs", programs);
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String index,
                           @RequestParam String password,
                           @RequestParam String repeat,
                           @RequestParam Integer programId,
                           @RequestParam Integer preferenceId,
                           @RequestParam Role role) throws PasswordsDoNotMatchException, UsernameAlreadyExistsException, InvalidArgumentsException {

        if (this.studentService.findById(Integer.parseInt(index)).isPresent())
            return "redirect:/register?StudentAlreadyExists";

        if (password.equals(repeat)) {
            Preference preference = this.preferenceService.findById(preferenceId).get();
            Program program = this.programService.findById(programId).get();
            this.studentService.register(Integer.parseInt(index), name, surname, password, repeat, preference, program, role);
            return "redirect:/login";
        } else {
            return "redirect:/register?PasswordsDoNotMatch";
        }
    }

}